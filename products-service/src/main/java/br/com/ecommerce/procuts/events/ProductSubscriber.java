package br.com.ecommerce.procuts.events;

import br.com.ecommerce.procuts.domain.Product;
import br.com.ecommerce.procuts.events.representation.Order;
import br.com.ecommerce.procuts.events.representation.OrderTotal;
import br.com.ecommerce.procuts.handler.EntityNotFoundException;
import br.com.ecommerce.procuts.repository.ProductRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class ProductSubscriber {

    private final ProductRepository productRepository;
    private final Queue orderTotalQueue;
    private final RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "${mq.queues.orders}")
    @Transactional
    public void consumeOrderCreatedEvent(@Payload String payload) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Order order = mapper.readValue(payload, Order.class);
        BigDecimal total = order.getProducts().stream().map(prod -> {

            Product product = productRepository.findById(prod.getProductId()).orElseThrow(
                    () -> new EntityNotFoundException("Product not found with id: " + prod.getProductId())
            );

            if (product.getStock() < prod.getQuantity()) {
                throw new IllegalArgumentException("Not enough stock for product with id: " + prod.getProductId());
            }

            product.setStock(product.getStock() - prod.getQuantity());
            productRepository.save(product);

            return product.getPrice().multiply(new BigDecimal(prod.getQuantity()));
        }).reduce(BigDecimal.ZERO, BigDecimal::add);

        OrderTotal orderTotal = new OrderTotal(total);
        String json = convertIntoJson(orderTotal);
        System.out.println(json);
    }

    private String convertIntoJson(OrderTotal dto) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(dto);
    }
}
package br.com.ecommerce.orders.events;

import br.com.ecommerce.orders.domain.Order;
import br.com.ecommerce.orders.enums.Status;
import br.com.ecommerce.orders.events.representation.OrderReceivedStatus;
import br.com.ecommerce.orders.events.representation.OrderStatusResponse;
import br.com.ecommerce.orders.repository.OrderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderEventConsumer {

    private final OrderRepository orderRepository;

    @RabbitListener(queues = "${mq.queues.order-processed}")
    public void receiveAndChangeOrderStatus(@Payload String payload) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            OrderStatusResponse orderStatusResponse = mapper.readValue(payload, OrderStatusResponse.class);

            if(orderStatusResponse.getStatus() == OrderReceivedStatus.APPROVED) {
                Order order = orderRepository.findById(orderStatusResponse.getOrderId())
                    .orElseThrow(() -> new RuntimeException("Order nao processada." + orderStatusResponse.getOrderId()));

                order.setStatus(Status.CONFIRMED);
                order.setTotal(orderStatusResponse.getTotal());
                orderRepository.save(order);

                log.info("Order {} status updated to CONFIRMED with total: {}",
                        order.getId(), orderStatusResponse.getTotal());
            } else {
                log.info("Order {} was rejected", orderStatusResponse.getOrderId());
            }

        } catch (JsonProcessingException ex) {
            log.error("Error processing order status update message: {}", ex.getMessage(), ex);
            throw new RuntimeException("Failed to process order status update", ex);
        } catch (Exception ex) {
            log.error("Unexpected error processing order status update: {}", ex.getMessage(), ex);
            throw new RuntimeException("Unexpected error during order processing", ex);
        }
    }
}

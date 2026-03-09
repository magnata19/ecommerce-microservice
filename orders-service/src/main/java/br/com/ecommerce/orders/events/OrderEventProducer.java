package br.com.ecommerce.orders.events;

import br.com.ecommerce.orders.dto.OrderCreateDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderEventProducer {

    private final RabbitTemplate rabbitTemplate;
    private final Queue orderQueue;

    public OrderEventProducer(RabbitTemplate rabbitTemplate, Queue orderQueue) {
        this.rabbitTemplate = rabbitTemplate;
        this.orderQueue = orderQueue;
    }

    public void sendOrderCreatedEvent(OrderCreateDto dto) throws JsonProcessingException {
        try {
            String json = convertIntoJson(dto);
            rabbitTemplate.convertAndSend(orderQueue.getName(), json);
        } catch (Exception ex) {
            throw new JsonProcessingException("Error converting OrderCreateDto to JSON: " + ex.getMessage()) {};
        }
    }

    private String convertIntoJson(OrderCreateDto dto) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(dto);
    }
}

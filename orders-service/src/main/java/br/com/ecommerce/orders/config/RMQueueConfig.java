package br.com.ecommerce.orders.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RMQueueConfig {

    @Value("${mq.queues.orders}")
    private String orderQueueName;

    @Value("${mq.queues.order-processed}")
    private String orderProcessedQueueName;

    @Bean
    public Queue orderQueue() {
        return new Queue(orderQueueName, true);
    }

    @Bean
    public Queue orderProcessedQueue() {
        return new Queue(orderProcessedQueueName, true);
    }
}

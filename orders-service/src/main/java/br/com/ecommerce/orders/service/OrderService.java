package br.com.ecommerce.orders.service;

import br.com.ecommerce.orders.config.OrderMapper;
import br.com.ecommerce.orders.domain.Order;
import br.com.ecommerce.orders.dto.MessageDto;
import br.com.ecommerce.orders.dto.OrderCreateDto;
import br.com.ecommerce.orders.dto.OrderResponseDto;
import br.com.ecommerce.orders.events.OrderEventProducer;
import br.com.ecommerce.orders.repository.OrderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

  private final OrderRepository orderRepository;
  private final OrderEventProducer orderEventProducer;


  @Transactional
  public MessageDto createOrder(OrderCreateDto dto) throws JsonProcessingException {
    Order order = orderRepository.save(OrderMapper.toEntity(dto));
    orderEventProducer.sendOrderCreatedEvent(OrderMapper.toDto(order));
    return new MessageDto(order.getId(),"Order created successfully!", order.getStatus().toString());
  }

  public OrderResponseDto getOrderById(String id) {
    Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    return OrderMapper.toResponseDto(order);
  }

}

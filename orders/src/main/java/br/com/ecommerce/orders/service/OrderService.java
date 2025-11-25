package br.com.ecommerce.orders.service;

import br.com.ecommerce.orders.config.OrderMapper;
import br.com.ecommerce.orders.domain.Order;
import br.com.ecommerce.orders.dto.OrderCreateDto;
import br.com.ecommerce.orders.dto.OrderResponseDto;
import br.com.ecommerce.orders.enums.Status;
import br.com.ecommerce.orders.http.ProductClient;
import br.com.ecommerce.orders.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {

  private final OrderRepository orderRepository;
  private final ProductClient productClient;

  @Transactional
  public OrderResponseDto createOrder(OrderCreateDto dto) {
    productClient.decreaseStock(dto.getProductId(), dto.getQuantity());
    Order order = orderRepository.save(OrderMapper.toEntity(dto));
    order.setStatus(Status.PENDING);
    return OrderMapper.toDto(order);
  }

  public OrderResponseDto getOrderById(Long id) {
    Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    return OrderMapper.toDto(order);
  }

  public Page<OrderResponseDto> getOrders(Pageable pageable) {
    return orderRepository.findAll(pageable)
            .map(order -> OrderMapper.toDto(order));
  }
}

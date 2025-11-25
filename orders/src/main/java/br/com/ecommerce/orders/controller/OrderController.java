package br.com.ecommerce.orders.controller;

import br.com.ecommerce.orders.dto.MessageDto;
import br.com.ecommerce.orders.dto.OrderCreateDto;
import br.com.ecommerce.orders.dto.OrderResponseDto;
import br.com.ecommerce.orders.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

  private final OrderService orderService;

  @PostMapping("/create")
  @CircuitBreaker(name = "createOrder", fallbackMethod = "createOrderFallback")
  public ResponseEntity<OrderResponseDto> createOrder(@RequestBody OrderCreateDto dto) {
    OrderResponseDto order = orderService.createOrder(dto);
    URI uri = UriComponentsBuilder.fromPath("/{id}").buildAndExpand(order.getId()).toUri();
    return ResponseEntity.created(uri).body(order);
  }

  @GetMapping
  public ResponseEntity<Page<OrderResponseDto>> getOrders(Pageable pageable){
    Page<OrderResponseDto> orders = orderService.getOrders(pageable);
    return ResponseEntity.ok(orders);
  }

  @GetMapping("/{id}")
  public ResponseEntity<OrderResponseDto> getOrder(@PathVariable Long id){
    return ResponseEntity.ok(orderService.getOrderById(id));
  }

  public ResponseEntity<MessageDto> createOrderFallback(OrderCreateDto dto, Exception e){
    MessageDto fallbackMessage = orderService.createOrderFallback();
    return ResponseEntity.ok(fallbackMessage);
  }
}

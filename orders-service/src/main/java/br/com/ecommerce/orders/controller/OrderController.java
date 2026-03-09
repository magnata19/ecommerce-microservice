package br.com.ecommerce.orders.controller;

import br.com.ecommerce.orders.dto.MessageDto;
import br.com.ecommerce.orders.dto.OrderCreateDto;
import br.com.ecommerce.orders.dto.OrderResponseDto;
import br.com.ecommerce.orders.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

  private final OrderService orderService;

  @PostMapping("/create")
  public ResponseEntity<MessageDto> createOrder(@RequestBody OrderCreateDto dto) throws JsonProcessingException {
    MessageDto response = orderService.createOrder(dto);
    return ResponseEntity.ok(response);
  }

//  @GetMapping
//  public ResponseEntity<Page<OrderResponseDto>> getOrders(Pageable pageable){
//    Page<OrderResponseDto> orders = orderService.getOrders(pageable);
//    return ResponseEntity.ok(orders);
//  }
//
  @GetMapping("/{id}")
  public ResponseEntity<OrderResponseDto> getOrder(@PathVariable String id){
    return ResponseEntity.ok(orderService.getOrderById(id));
  }
}

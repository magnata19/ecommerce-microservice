package br.com.ecommerce.orders.config;

import br.com.ecommerce.orders.domain.Order;
import br.com.ecommerce.orders.dto.OrderCreateDto;
import br.com.ecommerce.orders.dto.OrderResponseDto;
import br.com.ecommerce.orders.enums.Status;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OrderMapper {

  public static Order toEntity(OrderCreateDto dto) {
    return new Order(
            dto.getCustomerId(),
            dto.getProducts()
    );
  }

  public static OrderCreateDto toDto(Order order) {
    return new OrderCreateDto(
            order.getCustomerId(),
            order.getProducts()
    );
  }

  public static OrderResponseDto toResponseDto(Order order) {
    return new OrderResponseDto(
            order.getId(),
            order.getCustomerId(),
            order.getProducts(),
            order.getStatus(),
            order.getTotal()
    );
  }
}

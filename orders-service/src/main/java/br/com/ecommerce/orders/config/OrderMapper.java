package br.com.ecommerce.orders.config;

import br.com.ecommerce.orders.domain.Order;
import br.com.ecommerce.orders.dto.OrderCreateDto;
import br.com.ecommerce.orders.dto.OrderResponseDto;
import br.com.ecommerce.orders.enums.Status;
import org.modelmapper.ModelMapper;

public class OrderMapper {

  public static Order toEntity(OrderCreateDto dto) {
    Order order = new Order();
    order.setProductId(dto.getProductId());
    order.setQuantity(dto.getQuantity());
    order.setStatus(Status.PENDING);
    return order;
  }

  public static OrderResponseDto toDto(Order order) {
    return new  ModelMapper().map(order, OrderResponseDto.class);
  }
}

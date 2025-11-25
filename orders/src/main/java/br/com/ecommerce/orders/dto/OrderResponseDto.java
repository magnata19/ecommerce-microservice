package br.com.ecommerce.orders.dto;

import br.com.ecommerce.orders.enums.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponseDto {

  private Long id;
  private Long productId;
  private Integer quantity;
  private Status status;
}

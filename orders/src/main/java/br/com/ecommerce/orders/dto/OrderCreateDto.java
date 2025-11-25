package br.com.ecommerce.orders.dto;

import br.com.ecommerce.orders.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreateDto {

  private Long productId;
  private Integer quantity;
}

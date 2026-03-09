package br.com.ecommerce.orders.dto;

import br.com.ecommerce.orders.domain.ProductOrder;
import br.com.ecommerce.orders.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreateDto {

  private UUID customerId;
  private List<ProductOrder> products;
}

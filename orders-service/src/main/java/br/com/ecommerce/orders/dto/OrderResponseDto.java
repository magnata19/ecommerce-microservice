package br.com.ecommerce.orders.dto;

import br.com.ecommerce.orders.domain.ProductOrder;
import br.com.ecommerce.orders.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class OrderResponseDto {

  private String id;
  private UUID customerId;
  private List<ProductOrder> products;
  private Status status;
  private BigDecimal total;
}

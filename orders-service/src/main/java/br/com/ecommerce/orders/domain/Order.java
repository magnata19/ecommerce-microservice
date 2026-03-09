package br.com.ecommerce.orders.domain;

import br.com.ecommerce.orders.enums.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "orders")
public class Order {

  @Id
  private String id;
  private UUID customerId;
  private List<ProductOrder> products;
  @Enumerated(EnumType.STRING)
  private Status status = Status.PENDING;
  private BigDecimal total;

  public Order(UUID customerId, List<ProductOrder> products) {
    this.customerId = customerId;
    this.products = products;
  }
}

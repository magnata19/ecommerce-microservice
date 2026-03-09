package br.com.ecommerce.procuts.events.representation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderTotal {

    private String orderId;
    private BigDecimal total;
    private OrderStatus status;
}

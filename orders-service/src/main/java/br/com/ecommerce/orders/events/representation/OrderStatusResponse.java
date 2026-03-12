package br.com.ecommerce.orders.events.representation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatusResponse {
    private String orderId;
    private BigDecimal total;
    private OrderReceivedStatus status;
}

package br.com.ecommerce.procuts.events.representation;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String customerId;
    private List<OrderProduct> products;
}

package br.com.ecommerce.procuts.events.representation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderProduct {

    private UUID productId;
    private Integer quantity;
}

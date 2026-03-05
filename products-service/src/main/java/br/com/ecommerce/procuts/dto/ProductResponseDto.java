package br.com.ecommerce.procuts.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class ProductResponseDto {

  private UUID id;
  private String name;
  private String description;
  private Integer stock;
  private BigDecimal price;
}

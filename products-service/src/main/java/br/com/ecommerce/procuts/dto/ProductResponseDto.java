package br.com.ecommerce.procuts.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class ProductResponseDto {

  private Long id;
  private String name;
  private String description;
  private Integer stock;
  private BigDecimal price;
}

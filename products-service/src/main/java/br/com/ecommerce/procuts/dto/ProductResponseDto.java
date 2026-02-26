package br.com.ecommerce.procuts.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {

  private Long id;
  private String name;
  private Integer stock;
  private String description;

}

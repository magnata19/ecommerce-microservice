package br.com.ecommerce.procuts.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateDto {

  @NotBlank
  private String name;
  @NotBlank
  private String description;
  @NotBlank
  private Integer stock;
  @NotBlank
  private BigDecimal price;
}

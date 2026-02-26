package br.com.ecommerce.procuts.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateDto {

  @NotBlank
  private String name;
  @NotBlank
  private Integer stock;
  @NotBlank
  private String description;
}

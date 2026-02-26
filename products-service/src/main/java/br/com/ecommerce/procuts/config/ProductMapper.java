package br.com.ecommerce.procuts.config;

import br.com.ecommerce.procuts.domain.Product;
import br.com.ecommerce.procuts.dto.ProductCreateDto;
import br.com.ecommerce.procuts.dto.ProductResponseDto;
import org.modelmapper.ModelMapper;

public class ProductMapper {

  public static Product toEntity(ProductCreateDto dto) {
    return new ModelMapper().map(dto, Product.class);
  }

  public static ProductResponseDto toDto(Product product) {
    return new ModelMapper().map(product, ProductResponseDto.class);
  }
}

package br.com.ecommerce.procuts.config;

import br.com.ecommerce.procuts.domain.Product;
import br.com.ecommerce.procuts.dto.ProductCreateDto;
import br.com.ecommerce.procuts.dto.ProductResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

  public static Product toEntity(ProductCreateDto dto) {
    return new Product(
            dto.getName(),
            dto.getDescription(),
            dto.getStock(),
            dto.getPrice()
    );
  }

  public static ProductResponseDto toDto(Product product) {
    return new ProductResponseDto(
            product.getId(),
            product.getName(),
            product.getDescription(),
            product.getStock(),
            product.getPrice()
    );
  }
}

package br.com.ecommerce.procuts.service;

import br.com.ecommerce.procuts.config.ProductMapper;
import br.com.ecommerce.procuts.domain.Product;
import br.com.ecommerce.procuts.dto.ProductResponseDto;
import br.com.ecommerce.procuts.handler.EntityNotFoundException;
import br.com.ecommerce.procuts.handler.StockException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.ecommerce.procuts.dto.ProductCreateDto;
import br.com.ecommerce.procuts.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;

  public ProductResponseDto createProduct(ProductCreateDto dto) {
    Product product = productRepository.save(ProductMapper.toEntity(dto));
    return ProductMapper.toDto(product);
  }

  public Page<ProductResponseDto> getAllProducts(Pageable pageable) {
    return productRepository.findAll(pageable)
            .map(p -> ProductMapper.toDto(p));
  }

  public ProductResponseDto getProductById(UUID id) {
    Optional<Product> product = productRepository.findById(id);
    if(product.isEmpty()){
      throw new br.com.ecommerce.procuts.handler.EntityNotFoundException("Product not found.");
    }
    return ProductMapper.toDto(product.get());
  }

  public void decreaseStock(UUID productId, Integer quantity) {
    Optional<Product> product = productRepository.findById(productId);
    if(product.isEmpty()){
      throw new EntityNotFoundException("Product not found.");
    }
    product.get().setStock(product.get().getStock() - quantity);
    if(quantity > product.get().getStock()){
      throw new StockException("Insufficient stock.");
    }
    productRepository.save(product.get());
  }
}

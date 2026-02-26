package br.com.ecommerce.procuts.service;

import br.com.ecommerce.procuts.config.ProductMapper;
import br.com.ecommerce.procuts.domain.Product;
import br.com.ecommerce.procuts.dto.ProductResponseDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.ecommerce.procuts.dto.ProductCreateDto;
import br.com.ecommerce.procuts.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

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

  public ProductResponseDto getProductById(Long id) {
    Optional<Product> product = productRepository.findById(id);
    if(!product.isPresent()){
      throw new EntityNotFoundException("Product not found.");
    }
    return ProductMapper.toDto(product.get());
  }

  public void decreaseStock(Long productId, Integer quantity) {
    Optional<Product> product = productRepository.findById(productId);
    if(!product.isPresent()){
      throw new EntityNotFoundException("Product not found.");
    }
    product.get().setStock(product.get().getStock() - quantity);
    if(quantity > product.get().getStock()){
      throw new RuntimeException("Insufficient stock.");
    }
    productRepository.save(product.get());
  }
}

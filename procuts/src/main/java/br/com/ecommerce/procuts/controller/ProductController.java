package br.com.ecommerce.procuts.controller;

import br.com.ecommerce.procuts.dto.ProductCreateDto;
import br.com.ecommerce.procuts.dto.ProductResponseDto;
import br.com.ecommerce.procuts.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @PostMapping
  public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductCreateDto dto) {
    ProductResponseDto product = productService.createProduct(dto);
    URI uri = UriComponentsBuilder.fromPath("/api/v1/products/{id}").buildAndExpand(product.getId()).toUri();
    return ResponseEntity.created(uri).body(product);
  }

  @GetMapping
  public ResponseEntity<Page<ProductResponseDto>> getAllProducts(Pageable pageable) {
    Page<ProductResponseDto> allProducts = productService.getAllProducts(pageable);
    return ResponseEntity.ok(allProducts);
  }
}

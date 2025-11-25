package br.com.ecommerce.orders.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("product-service")
public interface ProductClient {
  @RequestMapping(method = RequestMethod.PUT, value = "/api/v1/products/decrease-stock/{productId}/{quantity}")
  void decreaseStock(@PathVariable Long productId, @PathVariable Integer quantity);
}
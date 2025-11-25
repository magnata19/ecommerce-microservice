package br.com.ecommerce.procuts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ecommerce.procuts.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

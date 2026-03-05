package br.com.ecommerce.procuts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ecommerce.procuts.domain.Product;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

}

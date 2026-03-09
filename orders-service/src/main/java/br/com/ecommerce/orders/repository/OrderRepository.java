package br.com.ecommerce.orders.repository;

import br.com.ecommerce.orders.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface OrderRepository extends MongoRepository<Order, String> {
}

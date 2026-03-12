package br.com.ecommerce.orders.repository;

import br.com.ecommerce.orders.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}

package br.com.ecommerce.orders.repository;

import br.com.ecommerce.orders.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

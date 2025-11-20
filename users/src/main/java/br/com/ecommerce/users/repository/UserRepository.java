package br.com.ecommerce.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ecommerce.users.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

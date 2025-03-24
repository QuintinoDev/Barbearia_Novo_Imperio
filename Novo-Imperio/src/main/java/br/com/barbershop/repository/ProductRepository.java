package br.com.barbershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.barbershop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

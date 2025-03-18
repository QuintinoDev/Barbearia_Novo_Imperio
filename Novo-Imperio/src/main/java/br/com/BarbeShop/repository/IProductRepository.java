package br.com.BarbeShop.repository;

import br.com.BarbeShop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
}

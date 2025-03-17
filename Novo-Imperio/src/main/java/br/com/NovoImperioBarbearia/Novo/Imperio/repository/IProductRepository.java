package br.com.NovoImperioBarbearia.Novo.Imperio.repository;

import br.com.NovoImperioBarbearia.Novo.Imperio.modelo.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
}

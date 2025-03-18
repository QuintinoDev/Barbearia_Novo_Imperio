package br.com.BarbeShop.repository;

import br.com.BarbeShop.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceRepository extends JpaRepository<Service, Long> {
}

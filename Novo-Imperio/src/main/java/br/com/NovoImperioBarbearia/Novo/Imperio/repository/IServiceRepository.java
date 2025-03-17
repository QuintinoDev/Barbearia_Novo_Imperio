package br.com.NovoImperioBarbearia.Novo.Imperio.repository;

import br.com.NovoImperioBarbearia.Novo.Imperio.modelo.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceRepository extends JpaRepository<Service, Long> {
}

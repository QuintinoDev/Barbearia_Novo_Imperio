package br.com.NovoImperioBarbearia.Novo.Imperio.repository;

import br.com.NovoImperioBarbearia.Novo.Imperio.modelo.Client;
import br.com.NovoImperioBarbearia.Novo.Imperio.modelo.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findByCliente(Client client);
}

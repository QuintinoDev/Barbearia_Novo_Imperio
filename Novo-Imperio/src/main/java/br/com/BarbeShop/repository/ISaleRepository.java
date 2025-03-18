package br.com.BarbeShop.repository;

import br.com.BarbeShop.model.Client;
import br.com.BarbeShop.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findByCliente(Client client);
}

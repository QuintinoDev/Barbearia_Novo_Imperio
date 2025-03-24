package br.com.barbershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.barbershop.model.Client;
import br.com.barbershop.model.Sale;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findByCliente(Client client);
}

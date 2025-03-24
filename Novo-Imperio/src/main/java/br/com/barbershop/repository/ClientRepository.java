package br.com.barbershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.barbershop.model.Client;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

    Optional<Client> findByNomeContainingIgnoreCase(String nome);
    List<Client> findByNome(String nome);
}

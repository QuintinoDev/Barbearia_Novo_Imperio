package br.com.barbershop.repository;

import br.com.barbershop.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

    Optional<Client> findByNomeContainingIgnoreCase(String nome);

    Page<Client> findAllByAtivoTrue(Pageable paginacao);
}

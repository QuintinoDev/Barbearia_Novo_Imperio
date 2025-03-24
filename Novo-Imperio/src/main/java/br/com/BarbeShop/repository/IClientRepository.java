package br.com.BarbeShop.repository;

import br.com.BarbeShop.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IClientRepository extends JpaRepository<Client,Long> {

    Optional<Client> findByNomeContainingIgnoreCase(String nome);

    Page<Client> findAllByAtivoTrue(Pageable paginacao);
}

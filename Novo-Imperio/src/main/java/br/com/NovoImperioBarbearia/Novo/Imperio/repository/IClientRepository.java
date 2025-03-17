package br.com.NovoImperioBarbearia.Novo.Imperio.repository;

import br.com.NovoImperioBarbearia.Novo.Imperio.modelo.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IClientRepository extends JpaRepository<Client,Long> {

    Optional<Client> findByNomeContainingIgnoreCase(String nome);
    List<Client> findByNome(String nome);
}

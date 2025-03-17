package br.com.NovoImperioBarbearia.Novo.Imperio.repository;

import br.com.NovoImperioBarbearia.Novo.Imperio.modelo.Barber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBarberRepository extends JpaRepository<Barber, Long> {
    //Buscar barbeiro pelo nome
    List<Barber> findByNome(String nome);
}

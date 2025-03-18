package br.com.BarbeShop.repository;

import br.com.BarbeShop.model.Barber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBarberRepository extends JpaRepository<Barber, Long> {
    //Buscar barbeiro pelo nome
    List<Barber> findByNome(String nome);
}

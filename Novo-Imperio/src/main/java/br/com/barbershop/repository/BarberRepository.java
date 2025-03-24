package br.com.barbershop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.barbershop.model.Barber;


@Repository
public interface BarberRepository extends JpaRepository<Barber, Long>, BaseRepository<Barber> {
    List<Barber> findAllByAtivoTrue();
}

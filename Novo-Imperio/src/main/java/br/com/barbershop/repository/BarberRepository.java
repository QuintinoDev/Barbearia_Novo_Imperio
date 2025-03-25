package br.com.barbershop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.barbershop.model.Barber;


@Repository
public interface BarberRepository extends JpaRepository<Barber, Long>, BaseRepository<Barber> {
    Page<Barber> findAllByAtivoTrue(Pageable paginacao);
}

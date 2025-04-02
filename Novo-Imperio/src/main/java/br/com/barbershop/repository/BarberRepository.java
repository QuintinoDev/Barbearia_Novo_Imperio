package br.com.barbershop.repository;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.barbershop.model.Barber;

import java.time.LocalDateTime;


@Repository
public interface BarberRepository extends JpaRepository<Barber, Long>, BaseRepository<Barber> {
    Page<Barber> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
            select b from Barber
            wherw
            b.ativo= 1
            and
            b.id not in(
                select b.barber.id from Scheduling s
                where
                s.data = :date)
            order by rand()
            limit 1
            """)
    Barber escolherBarbeiroDisponivelAleatorio(@NotNull @Future LocalDateTime data);
}

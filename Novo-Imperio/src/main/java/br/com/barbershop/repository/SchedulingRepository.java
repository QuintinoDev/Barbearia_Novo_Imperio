package br.com.barbershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.barbershop.model.Barber;
import br.com.barbershop.model.Client;
import br.com.barbershop.model.Scheduling;

import java.util.List;

public interface SchedulingRepository extends JpaRepository<Scheduling, Long> {
    List<Scheduling> findByBarbeiro(Barber barbeiro);
    List<Scheduling> findByCliente(Client cliente);
}

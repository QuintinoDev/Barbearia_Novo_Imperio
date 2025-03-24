package br.com.barbershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.barbershop.model.Payment;
import br.com.barbershop.model.Scheduling;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findByAgendamento(Scheduling agendamento);
}

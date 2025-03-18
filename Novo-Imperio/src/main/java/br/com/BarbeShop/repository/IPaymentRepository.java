package br.com.BarbeShop.repository;

import br.com.BarbeShop.model.Payment;
import br.com.BarbeShop.model.Scheduling;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IPaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findByAgendamento(Scheduling agendamento);
}

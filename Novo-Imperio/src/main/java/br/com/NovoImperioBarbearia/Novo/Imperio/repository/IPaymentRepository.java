package br.com.NovoImperioBarbearia.Novo.Imperio.repository;

import br.com.NovoImperioBarbearia.Novo.Imperio.modelo.Payment;
import br.com.NovoImperioBarbearia.Novo.Imperio.modelo.Scheduling;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IPaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findByScheduling(Scheduling scheduling);
}

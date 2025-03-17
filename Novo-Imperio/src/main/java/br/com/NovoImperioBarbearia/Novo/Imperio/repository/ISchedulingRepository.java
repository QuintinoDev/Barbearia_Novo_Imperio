package br.com.NovoImperioBarbearia.Novo.Imperio.repository;

import br.com.NovoImperioBarbearia.Novo.Imperio.modelo.Barber;
import br.com.NovoImperioBarbearia.Novo.Imperio.modelo.Client;
import br.com.NovoImperioBarbearia.Novo.Imperio.modelo.Scheduling;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISchedulingRepository extends JpaRepository<Scheduling, Long> {
    List<Scheduling> findByBarber(Barber barber);
    List<Scheduling> findByClient(Client client);
}

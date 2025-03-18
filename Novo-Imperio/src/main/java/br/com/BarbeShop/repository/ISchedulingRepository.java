package br.com.BarbeShop.repository;

import br.com.BarbeShop.model.Barber;
import br.com.BarbeShop.model.Client;
import br.com.BarbeShop.model.Scheduling;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISchedulingRepository extends JpaRepository<Scheduling, Long> {
    List<Scheduling> findByBarber(Barber barber);
    List<Scheduling> findByClient(Client client);
}

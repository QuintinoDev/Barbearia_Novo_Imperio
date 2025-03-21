package br.com.BarbeShop.repository;

import br.com.BarbeShop.model.Barber;
import org.hibernate.query.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IBarberRepository extends JpaRepository<Barber, Long> {
    List<Barber> findAllByAtivoTrue();
}

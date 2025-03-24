package br.com.barbershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.barbershop.model.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}

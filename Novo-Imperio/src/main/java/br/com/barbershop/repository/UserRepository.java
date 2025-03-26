package br.com.barbershop.repository;

import br.com.barbershop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

//Repository responsavel pela Autenticação
public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByLogin(String login);
}

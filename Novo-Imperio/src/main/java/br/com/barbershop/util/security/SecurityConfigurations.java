package br.com.barbershop.util.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
//Classe criada para configurar nosso segurança do condigo
public class SecurityConfigurations {


    //Essa anotação serve para exportar uma classe para o spring, fazendo com que ele consiga carrega-la e realize sua injeção
    @Bean
    //SecurityFilterChain objeto do spring usado para configurar essa parte de autenticação e de autorização
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        //Estou desabilitando o csrf porque vamos usar o token que ja proteje desse ataque
        return http.csrf(c -> c.disable())
                .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
        return configuration.getAuthenticationManager();
    }

    //Usado para aceitar a senha via BCrypt de hashing da senha
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

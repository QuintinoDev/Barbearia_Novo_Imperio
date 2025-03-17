package br.com.NovoImperioBarbearia.Novo.Imperio.service;

import br.com.NovoImperioBarbearia.Novo.Imperio.main.Main;
import br.com.NovoImperioBarbearia.Novo.Imperio.repository.IBarberRepository;
import br.com.NovoImperioBarbearia.Novo.Imperio.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("br.com.NovoImperioBarbearia.Novo.Imperio.repository")
@EntityScan("br.com.NovoImperioBarbearia.Novo.Imperio.modelo")
public class NovoImperioApplication implements CommandLineRunner {
	@Autowired
	IBarberRepository barberRepository;
	@Autowired
	IClientRepository clientRepository;

	public static void main(String[] args) {
		SpringApplication.run(NovoImperioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main(barberRepository, clientRepository);
		main.exibirMenu();
	}
}

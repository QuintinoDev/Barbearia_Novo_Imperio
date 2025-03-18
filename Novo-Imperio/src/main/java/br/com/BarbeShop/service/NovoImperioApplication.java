package br.com.BarbeShop.service;

import br.com.BarbeShop.main.Main;
import br.com.BarbeShop.model.Barber;
import br.com.BarbeShop.repository.IBarberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NovoImperioApplication implements CommandLineRunner {

	IBarberRepository barberRepository;

	public static void main(String[] args) {
		SpringApplication.run(NovoImperioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main(barberRepository);
		main.exibirMenu();
	}
}

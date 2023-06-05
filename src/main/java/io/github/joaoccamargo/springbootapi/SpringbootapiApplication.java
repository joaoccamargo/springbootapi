package io.github.joaoccamargo.springbootapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.github.joaoccamargo.springbootapi.domain.entity.Cliente;
import io.github.joaoccamargo.springbootapi.domain.repository.Clientes;

@SpringBootApplication
public class SpringbootapiApplication {

	@Bean
	public CommandLineRunner commandLineRunner(@Autowired Clientes clientes){
		return args -> {
			Cliente c = new Cliente(null, "fulano");
			clientes.save(c);
		};
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringbootapiApplication.class, args);
	}

}

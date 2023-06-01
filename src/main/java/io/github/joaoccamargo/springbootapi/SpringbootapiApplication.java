package io.github.joaoccamargo.springbootapi;

import java.util.List;

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
	public CommandLineRunner init(@Autowired Clientes clientes){
		return args -> {
			clientes.salvar(new Cliente(null, "Jose"));
			clientes.salvar(new Cliente(null, "Maria"));
			clientes.salvar(new Cliente(null, "Carlos"));
			
			List<Cliente> todosClientes = clientes.obterTodos();
			todosClientes.forEach(System.out::println);

			todosClientes.forEach(c -> {
				c.setNome(c.getNome() + " atualizado. ");
				clientes.atualizar(c);
			});
			

			todosClientes = clientes.obterTodos();
			todosClientes.forEach(System.out::println);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootapiApplication.class, args);
	}

}

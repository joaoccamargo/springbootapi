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
			clientes.save(new Cliente(null, "Jose"));
			clientes.save(new Cliente(null, "Maria"));
			clientes.save(new Cliente(null, "Carlos"));
			
			List<Cliente> todosClientes = clientes.findAll();
			todosClientes.forEach(System.out::println);

			System.out.println("Atualizando clientes");
			todosClientes.forEach(c -> {
				c.setNome(c.getNome() + " atualizado. ");
				clientes.save(c);
			});
			
			todosClientes = clientes.findAll();
			todosClientes.forEach(System.out::println);

			System.out.println("Buscando cliente por nome");
			clientes.findByNomeLike("Cli").forEach(System.out::println);

			System.out.println("Deletando clientes");
			clientes.findAll().forEach(c -> {
				clientes.delete(c);
			});

			todosClientes = clientes.findAll();
			if(todosClientes.isEmpty()){
				System.out.println("Nenhum cliente encontrado");
			}else{
				todosClientes.forEach(System.out::println);
			}

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootapiApplication.class, args);
	}

}

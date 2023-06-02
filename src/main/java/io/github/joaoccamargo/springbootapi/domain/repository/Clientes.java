package io.github.joaoccamargo.springbootapi.domain.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import io.github.joaoccamargo.springbootapi.domain.entity.Cliente;

public interface Clientes extends JpaRepository<Cliente, Integer>{

    // Transforma metodo em query, query methods
    List<Cliente> findByNomeLike(String nome);
    //List<Cliente> findByNomeOrIdOrderById(String nome, Integer id);
    
    boolean existsByNome(String nome);
}

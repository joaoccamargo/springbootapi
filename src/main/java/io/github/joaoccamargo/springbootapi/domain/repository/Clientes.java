package io.github.joaoccamargo.springbootapi.domain.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import io.github.joaoccamargo.springbootapi.domain.entity.Cliente;

public interface Clientes extends JpaRepository<Cliente, Integer>{

    List<Cliente> findByNomeLike(String nome); // Transforma o metodo em uma query.
}

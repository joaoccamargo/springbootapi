package io.github.joaoccamargo.springbootapi.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.github.joaoccamargo.springbootapi.domain.entity.Cliente;

public interface Clientes extends JpaRepository<Cliente, Integer>{

    // Transforma metodo em query, query methods
    @Query(value = " select * from cliente c where c.nome like '%:nome%' ", nativeQuery = true) // consulta nativa sql
    //@Query(value = " select c from Cliente c where c.nome like :nome ") // consulta jpql
    List<Cliente> encontrarPorNome( @Param("nome") String nome);

    @Query(" delete from Cliente c where c.nome =:nome ")
    @Modifying
    void deleteByNome(String nome);
    
    
    //List<Cliente> findByNomeOrIdOrderById(String nome, Integer id);
    //boolean existsByNome(String nome);
}

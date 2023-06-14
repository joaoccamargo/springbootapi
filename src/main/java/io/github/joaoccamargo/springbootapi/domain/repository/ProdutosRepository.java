package io.github.joaoccamargo.springbootapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.joaoccamargo.springbootapi.domain.entity.Produto;

public interface ProdutosRepository extends JpaRepository<Produto, Integer>{
    
}

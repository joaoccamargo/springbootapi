package io.github.joaoccamargo.springbootapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.joaoccamargo.springbootapi.domain.entity.Pedido;


public interface Pedidos extends JpaRepository<Pedido, Integer> {
    
}

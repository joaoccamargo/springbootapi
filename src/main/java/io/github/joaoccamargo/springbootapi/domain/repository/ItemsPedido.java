package io.github.joaoccamargo.springbootapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.joaoccamargo.springbootapi.domain.entity.ItemPedido;

public interface ItemsPedido extends JpaRepository<ItemPedido, Integer> {
    
}

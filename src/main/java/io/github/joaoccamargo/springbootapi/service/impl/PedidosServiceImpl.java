package io.github.joaoccamargo.springbootapi.service.impl;

import org.springframework.stereotype.Service;

import io.github.joaoccamargo.springbootapi.domain.repository.Pedidos;
import io.github.joaoccamargo.springbootapi.service.PedidoService;

@Service
public class PedidosServiceImpl implements PedidoService{
    
    private Pedidos pedidosRepository;

    public PedidosServiceImpl(Pedidos pedidosRepository){
        this.pedidosRepository = pedidosRepository;
    }
}

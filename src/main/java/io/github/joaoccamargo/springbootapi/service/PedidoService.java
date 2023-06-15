package io.github.joaoccamargo.springbootapi.service;

import io.github.joaoccamargo.springbootapi.domain.entity.Pedido;
import io.github.joaoccamargo.springbootapi.rest.dto.PedidoDTO;

public interface PedidoService {
    Pedido salvar(PedidoDTO pedidoDTO);

    
}

package io.github.joaoccamargo.springbootapi.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.joaoccamargo.springbootapi.domain.entity.Pedido;
import io.github.joaoccamargo.springbootapi.rest.dto.PedidoDTO;
import io.github.joaoccamargo.springbootapi.service.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    
    private PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService){
        this.pedidoService = pedidoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer save(@RequestBody PedidoDTO pedidoDTO){
       Pedido pedido = pedidoService.salvar(pedidoDTO);
       return pedido.getId();
    }
    
}

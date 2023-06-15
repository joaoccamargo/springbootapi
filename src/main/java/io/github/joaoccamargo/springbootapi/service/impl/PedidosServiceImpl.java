package io.github.joaoccamargo.springbootapi.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import io.github.joaoccamargo.springbootapi.domain.entity.Cliente;
import io.github.joaoccamargo.springbootapi.domain.entity.Pedido;
import io.github.joaoccamargo.springbootapi.domain.exception.RegraNegocioException;
import io.github.joaoccamargo.springbootapi.domain.repository.ClientesRepository;
import io.github.joaoccamargo.springbootapi.domain.repository.Pedidos;
import io.github.joaoccamargo.springbootapi.domain.repository.ProdutosRepository;
import io.github.joaoccamargo.springbootapi.rest.dto.ItemPedidoDTO;
import io.github.joaoccamargo.springbootapi.rest.dto.PedidoDTO;
import io.github.joaoccamargo.springbootapi.service.PedidoService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PedidosServiceImpl implements PedidoService{
    
    private final Pedidos pedidosRepository;
    private final ClientesRepository clientesRepository;
    private final ProdutosRepository produtosRepository;

    /* atributos final lombok
    public PedidosServiceImpl(Pedidos pedidosRepository, ClientesRepository clientesRepository, ProdutosRepository produtosRepository){
        this.pedidosRepository = pedidosRepository;
        this.clientesRepository = clientesRepository;
        this.produtosRepository = produtosRepository;
    }
    */

    @Override
    public Pedido salvar(PedidoDTO pedidoDTO) {
        Integer idCliente = pedidoDTO.getCliente();
        Cliente cliente = clientesRepository
                .findById(idCliente)
                .orElseThrow(() -> new RegraNegocioException("Código de cliente inválido."));

        Pedido pedido = new Pedido();
        pedido.setTotal(pedidoDTO.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);

        return pedido; 
    }

    private void salvarItems(List<ItemPedidoDTO> items){
        if(items.isEmpty()){
            throw new RegraNegocioException("Não é possivel realizar um pedido sem items.");
        }
    }
}

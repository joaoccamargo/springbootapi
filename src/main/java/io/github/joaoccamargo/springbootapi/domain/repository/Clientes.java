package io.github.joaoccamargo.springbootapi.domain.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import io.github.joaoccamargo.springbootapi.domain.entity.Cliente;

@Repository // Identifica como repositorio
public class Clientes {

    @Autowired
    private EntityManager entityManager;

    @Transactional // O import precisa ser o org.springframework.transaction.annotation.Transactional;
    public Cliente salvar(Cliente cliente){
        entityManager.persist(cliente);
        return cliente;
    }

    @Transactional
    public Cliente atualizar(Cliente cliente){
        entityManager.merge(cliente);
        return cliente;
    }

    @Transactional
    public void deletar(Cliente cliente){

        if(!entityManager.contains(cliente)){
            cliente = entityManager.merge(cliente);
        }
        entityManager.remove(cliente);
    }

    @Transactional
    public void deletar(Integer id){
        Cliente cliente = entityManager.find(Cliente.class, id);
        deletar(cliente);
    }

    @Transactional(readOnly = true)
    public List<Cliente> buscarPorNome(String nome){
        String jpql = " SELECT c FROM cliente c WHERE c.nome like :nome"; // Os : pontos serve para identificar o parametro no jpa.
        TypedQuery<Cliente> query = entityManager.createQuery(jpql, Cliente.class);
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();      
    }
    
    @Transactional
    public List<Cliente> obterTodos(){
        return entityManager.createQuery("FROM cliente", Cliente.class).getResultList();
    }

}

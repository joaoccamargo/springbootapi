package io.github.joaoccamargo.springbootapi.domain.repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import io.github.joaoccamargo.springbootapi.domain.entity.Cliente;

@Repository
public class Clientes {

    // JDBC

    private static final String INSERT = "INSERT INTO CLIENTE (nome) VALUES (?)";
    private static final String SELECT_ALL = "SELECT * FROM CLIENTE";
    private static final String UPDATE = "UPDATE CLIENTE SET nome = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM CLIENTE WHERE id = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public Clientes(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public Cliente salvar(Cliente cliente){
        jdbcTemplate.update(INSERT, new Object[]{cliente.getNome()});
        return cliente;
    }

    public Cliente atualizar(Cliente cliente){
        jdbcTemplate.update(UPDATE, new Object[]{cliente.getNome(), cliente.getId()});
        return cliente;
    }

    public Cliente deletar(Cliente cliente){
        jdbcTemplate.update(DELETE, new Object[]{cliente.getId()});
        return cliente;
    }

    public List<Cliente> buscarPorNome(String nome){
        return jdbcTemplate.query(SELECT_ALL.concat(" where nome = ? "), 
                                            new Object[]{"%" + nome + "%"},
                                            obterClientesMapper());
    }
    
    public List<Cliente> obterTodos(){
        return jdbcTemplate.query(SELECT_ALL, obterClientesMapper());
    }

    private RowMapper<Cliente> obterClientesMapper(){
        return new RowMapper<Cliente>(){
            @Override
            public Cliente mapRow(ResultSet resultSet, int i) throws SQLException {
                Integer id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                return new Cliente(id, nome);
            }
        };
    }

}

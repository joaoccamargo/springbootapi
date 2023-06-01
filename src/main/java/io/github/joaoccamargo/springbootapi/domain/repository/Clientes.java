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

    private static final String INSERT = "INSERT INTO CLIENTE (nome) VALUES (?)";
    private static final String SELECT_ALL = "SELECT * FROM CLIENTE";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public Clientes(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public void salvar(Cliente cliente){
        jdbcTemplate.update(INSERT, new Object[]{cliente.getNome()});
    }
    
    public List<Cliente> obterTodos(){
        return jdbcTemplate.query(SELECT_ALL, new RowMapper<Cliente>(){
            @Override
            public Cliente mapRow(ResultSet resultSet, int i) throws SQLException {
                Integer id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                return new Cliente(id, nome);
            }
        });
    }

}

package io.github.joaoccamargo.springbootapi.domain.entity;


// Import JPA
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;

@Entity // Dizendo para JPA que está é uma entidade
@Table (name = "cliente") // Tabela do banco de dados é cliente.
public class Cliente {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Gerar ID Automaticamente H2
    @Column (name = "id") //Coluna Não precisa colocar caso nome seja igual do banco de dados.
    private Integer id;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "cpf", length = 11)
    private String cpf;

    // LAZY recomendado
    @JsonIgnore
    @OneToMany( mappedBy = "cliente", fetch = FetchType.LAZY)
    private Set<Pedido> pedidos;

    public Cliente(){}

    public Cliente(Integer id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nome=" + nome + "]";
    }

   
}

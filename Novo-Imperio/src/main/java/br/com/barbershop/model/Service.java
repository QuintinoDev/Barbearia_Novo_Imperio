package br.com.barbershop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

@Entity
@Table(name = "servicos")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private Double preco;
    private Integer duracao;
    @OneToMany(mappedBy = "servico", cascade = CascadeType.ALL)
    private List<Scheduling> agendamento;

    public Service(){}

    public Service(String nome, String descricao, Double preco, Integer duracao){
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.duracao = duracao;
    }
}

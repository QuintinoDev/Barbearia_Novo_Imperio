package br.com.BarbeShop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter

@Entity
@Table(name = "barbeiros")
public class Barber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    private String telefone;

    private LocalDateTime dataCadastro = LocalDateTime.now();

    @OneToMany(mappedBy = "barbeiro", cascade = CascadeType.ALL)
    private List<Scheduling> agendamentos;

    public Barber() {}

    public Barber(String nome, String email, String senha, String telefone) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
    }
}

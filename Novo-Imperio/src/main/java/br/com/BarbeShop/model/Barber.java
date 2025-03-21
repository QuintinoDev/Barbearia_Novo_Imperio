package br.com.BarbeShop.model;

import br.com.BarbeShop.dto.AtualizaBarber;
import br.com.BarbeShop.dto.CadastroBarber;
import jakarta.persistence.*;
import jakarta.validation.Valid;
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

    private String especialidade;

    @Column(nullable = false)
    private Boolean ativo;

    private LocalDateTime dataCadastro = LocalDateTime.now();

    @OneToMany(mappedBy = "barbeiro", cascade = CascadeType.ALL)
    private List<Scheduling> agendamentos;

    public Barber() {}

    public Barber(CadastroBarber barber) {
        this.nome = barber.nome();
        this.email = barber.email();
        this.senha = barber.senha();
        this.especialidade = barber.especialidade();
        this.ativo = true;
        this.telefone = barber.telefone();
    }

    public void atualizarCadastro(@Valid AtualizaBarber atualiza) {
        if (atualiza.nome() != null){
            this.nome = atualiza.nome();
        }
        if (atualiza.email() != null){
            this.email = atualiza.email();
        }
        if (atualiza.senha() != null){
            this.senha = atualiza.senha();
        }
        if (atualiza.especialidade() != null){
            this.especialidade = atualiza.especialidade();
        }
        if (atualiza.telefone() != null){
            this.telefone = atualiza.telefone();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}

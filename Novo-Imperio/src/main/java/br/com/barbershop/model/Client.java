package br.com.barbershop.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

import br.com.barbershop.dto.AtualizarClient;
import br.com.barbershop.dto.CadastroClient;

@Getter
@Setter

@Entity
@Table(name = "clientes")
public class Client{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    private String telefone;

    @Column(nullable = false)
    private Boolean ativo;

    private LocalDateTime dataCadastro = LocalDateTime.now();

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Scheduling> agendamento;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Sale> vendas;

    public Client() {}

    public Client(CadastroClient client) {
        this.nome = client.nome();
        this.email = client.email();
        this.senha = client.senha();
        this.telefone = client.telefone();
        this.ativo = true;
    }

    public void atualizarCadastro(@Valid AtualizarClient atualiza) {
        if (atualiza.nome() != null){
            this.nome = atualiza.nome();
        }
        if (atualiza.email() != null){
            this.email = atualiza.email();
        }
        if (atualiza.senha() != null){
            this.senha = atualiza.senha();
        }
        if (atualiza.telefone() != null){
            this.telefone = atualiza.telefone();
        }
    }

    public void excluir() {
        this.ativo = false;
    }

}

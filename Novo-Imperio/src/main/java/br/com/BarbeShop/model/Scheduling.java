package br.com.BarbeShop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter

@Entity
@Table(name="agendamentos")
public class Scheduling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "clientes_id", nullable = false)
    private Client cliente;

    @ManyToOne
    @JoinColumn(name = "barbeiros_id", nullable = false)
    private Barber barbeiro;

    @ManyToOne
    @JoinColumn(name = "servicos_id", nullable = false)
    private Service servico;

    private LocalDate dataHora;

    private String observacao;

    @Enumerated(EnumType.STRING)
    private StatusScheduling status;

    public Scheduling(){}

    public Scheduling(Client cliente, Barber barbeiro, LocalDate dataHora, String observacao, Service servico, StatusScheduling status) {
        this.cliente = cliente;
        this.barbeiro = barbeiro;
        this.dataHora = dataHora;
        this.observacao = observacao;
        this.servico = servico;
        this.status = status;
    }
}

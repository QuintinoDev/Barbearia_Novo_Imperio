package br.com.BarbeShop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter

@Entity
@Table(name="agendamentos")
public class Scheduling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Client cliente;

    @ManyToOne
    @JoinColumn(name = "barbeiro_id", nullable = false)
    private Barber barbeiro;

    @ManyToOne
    @JoinColumn(name = "servico_id", nullable = false)
    private Service servico;

    @OneToMany(mappedBy = "agendamento", cascade = CascadeType.ALL)
    private List<Payment> pagamento;

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

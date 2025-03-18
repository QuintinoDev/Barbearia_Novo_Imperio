package br.com.BarbeShop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter

@Entity
@Table(name = "pagamento")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "agendamento_id", nullable = false)
    private Scheduling agendamento;

    private Double valor;

    private LocalDate datePagamento;

    @Enumerated(EnumType.STRING)
    private ShapePayment formaPagamento;

    @Enumerated(EnumType.STRING)
    private StatusPayment status;

    public Payment() {}

    public Payment(Scheduling agendamento, Double valor, LocalDate datePagamento, ShapePayment formaPagamento, StatusPayment status) {
        this.agendamento = agendamento;
        this.valor = valor;
        this.datePagamento = datePagamento;
        this.formaPagamento = formaPagamento;
        this.status = status;
    }
}

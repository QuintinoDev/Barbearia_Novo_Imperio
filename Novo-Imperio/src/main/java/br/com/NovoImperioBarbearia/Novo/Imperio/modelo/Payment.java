package br.com.NovoImperioBarbearia.Novo.Imperio.modelo;

import java.time.LocalDate;

public class Payment {
    private Long id;
    private Scheduling agendamento;
    private Double valor;
    private LocalDate datePagamento;
    private ShapePayment formaPagamento;
    private StatusPayment status;

    public Payment() {}

    public Payment(Scheduling agendamento, Double valor, LocalDate datePagamento, ShapePayment formaPagamento, StatusPayment status) {
        this.agendamento = agendamento;
        this.valor = valor;
        this.datePagamento = datePagamento;
        this.formaPagamento = formaPagamento;
        this.status = status;
    }

    public Scheduling getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Scheduling agendamento) {
        this.agendamento = agendamento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getDatePagamento() {
        return datePagamento;
    }

    public void setDatePagamento(LocalDate datePagamento) {
        this.datePagamento = datePagamento;
    }

    public ShapePayment getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(ShapePayment formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public StatusPayment getStatus() {
        return status;
    }

    public void setStatus(StatusPayment status) {
        this.status = status;
    }
}

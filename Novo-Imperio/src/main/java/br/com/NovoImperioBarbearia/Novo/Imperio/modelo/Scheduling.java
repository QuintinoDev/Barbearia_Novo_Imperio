package br.com.NovoImperioBarbearia.Novo.Imperio.modelo;

import java.time.LocalDate;

public class Scheduling {
    private Long id;
    private Client cliente;
    private Barber barbeiro;
    private LocalDate dataHora;
    private String observacao;
    private Service servico;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getCliente() {
        return cliente;
    }

    public void setCliente(Client cliente) {
        this.cliente = cliente;
    }

    public Barber getBarbeiro() {
        return barbeiro;
    }

    public void setBarbeiro(Barber barbeiro) {
        this.barbeiro = barbeiro;
    }

    public LocalDate getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDate dataHora) {
        this.dataHora = dataHora;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Service getServico() {
        return servico;
    }

    public void setServico(Service servico) {
        this.servico = servico;
    }
}

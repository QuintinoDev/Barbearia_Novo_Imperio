package br.com.NovoImperioBarbearia.Novo.Imperio.modelo;

import java.util.List;

public class Client extends User {
    private List<Scheduling> agendamento;
    private List<Sale> vendas;

    public Client() {}

    public Client(String nome, String email, String senha, String telefone) {
        super(nome, email, senha, telefone);
    }

    public List<Scheduling> getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(List<Scheduling> agendamento) {
        this.agendamento = agendamento;
    }

    public List<Sale> getVendas() {
        return vendas;
    }

    public void setVendas(List<Sale> vendas) {
        this.vendas = vendas;
    }
}

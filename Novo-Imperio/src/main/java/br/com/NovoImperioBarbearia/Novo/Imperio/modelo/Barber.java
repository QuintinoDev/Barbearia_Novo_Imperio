package br.com.NovoImperioBarbearia.Novo.Imperio.modelo;

import java.util.List;

public class Barber extends User {

    private List<Scheduling> agendamentos;

    public Barber(){}

    public Barber(String nome, String email, String senha, String telefone) {
        super(nome, email, senha, telefone);
    }

    public List<Scheduling> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Scheduling> agendamentos) {
        this.agendamentos = agendamentos;
    }
}

package br.com.BarbeShop.dto;

import br.com.BarbeShop.model.Barber;

public record DadosBarbe( Long id, String nome,
                         String email,
                         String senha,
                         String telefone,
                         String especialidade) {

    public DadosBarbe(Barber barber){
        this(barber.getId(), barber.getNome(),barber.getEmail(),barber.getSenha(),barber.getTelefone(),barber.getEspecialidade());
    }
}

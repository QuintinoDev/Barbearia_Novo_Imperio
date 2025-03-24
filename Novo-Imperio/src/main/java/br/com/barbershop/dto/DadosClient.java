package br.com.barbershop.dto;

import br.com.barbershop.model.Client;

public record DadosClient(Long id, String nome,
                          String email,
                          String senha,
                          String telefone) {
    public DadosClient(Client client){
        this(client.getId(), client.getNome(),client.getEmail(),client.getSenha(),client.getTelefone());
    }
}

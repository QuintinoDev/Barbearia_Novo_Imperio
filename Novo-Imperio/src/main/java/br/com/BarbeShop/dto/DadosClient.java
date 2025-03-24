package br.com.BarbeShop.dto;

import br.com.BarbeShop.model.Client;

public record DadosClient(Long id, String nome,
                          String email,
                          String senha,
                          String telefone) {

    public DadosClient(Client client){
        this(client.getId(), client.getNome(),client.getEmail(),client.getSenha(),client.getTelefone());
    }
}

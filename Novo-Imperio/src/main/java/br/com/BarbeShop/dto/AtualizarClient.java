package br.com.BarbeShop.dto;

import jakarta.validation.constraints.NotNull;

public record AtualizarClient(@NotNull
                              Long id,
                              String nome,
                              String email,
                              String senha,
                              String telefone) {
}

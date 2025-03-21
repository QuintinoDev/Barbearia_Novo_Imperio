package br.com.BarbeShop.dto;

import jakarta.validation.constraints.NotNull;

public record AtualizaBarber(
        @NotNull
        Long id,
        String nome,
        String email,
        String senha,
        String telefone,
        String especialidade) {
}

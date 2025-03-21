package br.com.BarbeShop.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CadastroClient(
        //Valida se o camopo vem vazio ou null
        @NotBlank
        String nome,

        @NotBlank
        //Valida se o campo vem como Email
        @Email
        String email,

        @NotBlank
        String senha,

        @NotBlank
        String telefone) {
}

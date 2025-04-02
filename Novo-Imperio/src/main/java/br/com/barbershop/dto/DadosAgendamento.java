package br.com.barbershop.dto;

import br.com.barbershop.util.enumerated.StatusScheduling;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamento(
        //Escolha opcional do barbeiro caso, o cliente nao tenha preferência
        Long idBarber,
        @NotNull
        Long idClient,
        @NotNull
        Long idService,
        String observacao,
        @NotNull
        //Anotação para falar que a data tem que ser no futuro.
        @Future
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime data,
        @NotNull
        StatusScheduling status) {
}

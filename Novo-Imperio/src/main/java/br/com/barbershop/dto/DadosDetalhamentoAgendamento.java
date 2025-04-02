package br.com.barbershop.dto;

import br.com.barbershop.util.enumerated.StatusScheduling;

import java.time.LocalDateTime;

public record DadosDetalhamentoAgendamento(Long id,
                                           Long idBarber,
                                           Long idClient,
                                           Long idService,
                                           String observacao,
                                           LocalDateTime date,
                                           StatusScheduling status) {
}

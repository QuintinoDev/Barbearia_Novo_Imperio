package br.com.barbershop.controller;

import br.com.barbershop.dto.DadosAgendamento;
import br.com.barbershop.dto.DadosDetalhamentoAgendamento;
import br.com.barbershop.service.AgendamentoService;
import jakarta.validation.Valid;
import org.apache.tomcat.util.net.jsse.PEMFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agendamentos")
public class SchedulingController {

    @Autowired
    private AgendamentoService agendamento;

    @PostMapping
    @Transactional
    public ResponseEntity agendar (@RequestBody @Valid DadosAgendamento dados){
        agendamento.agendar(dados);
        return ResponseEntity.ok( new DadosDetalhamentoAgendamento(null,null,null,null,null, null, null));
    }
}

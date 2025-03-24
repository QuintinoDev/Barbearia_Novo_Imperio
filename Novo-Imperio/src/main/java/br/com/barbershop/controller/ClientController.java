package br.com.barbershop.controller;

import br.com.barbershop.dto.CadastroClient;
import br.com.barbershop.dto.DadosClient;
import br.com.barbershop.model.Client;
import br.com.barbershop.repository.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClientController {

    @Autowired
    private ClientRepository repository;

    @PostMapping
    public void cadastrarClient(@RequestBody @Valid CadastroClient client){
        repository.save( new Client(client));
    }

    //Colocamos para ser mostrado em paginas os clientes, com a Classe Pageable do Spring
    //PageableDefault usado para limitar oque vaio aparecer com a requisição
    @GetMapping
    public Page<DadosClient> listaClient(@PageableDefault(size = 10) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosClient::new);
    }

}

package br.com.barbershop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.barbershop.dto.AtualizarClient;
import br.com.barbershop.dto.CadastroClient;
import br.com.barbershop.dto.DadosClient;
import br.com.barbershop.model.Client;
import br.com.barbershop.repository.ClientRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClientController {

    @Autowired
    private ClientRepository repository;

    //Testado com postman, funcionando.
    @PostMapping
    @Transactional
    public ResponseEntity cadastrarClient(@RequestBody @Valid CadastroClient dados, UriComponentsBuilder uriBuilder){
        var client = new Client(dados);
        repository.save(client);
        //Criando uri com classe ja do spring UriComponentsBuilder, que ja fica encapsulado
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(client.getId()).toUri();
        //Retornado a Uri criada com o dto que fala as informações
        return ResponseEntity.created(uri).body( new DadosClient(client));
    }

    //Testado com postman, funcionando.
    //Colocamos para ser mostrado em paginas os clientes, com a Classe Pageable do Spring
    //PageableDefault usado para limitar oque vai aparecer com a requisição
    @GetMapping
    public ResponseEntity<Page<DadosClient>> listaClient(@PageableDefault(size = 10) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosClient::new);
        return ResponseEntity.ok(page);
    }

    //Testado com postman, fuincionando
    //Atualização por id, colocar id antes de atualizar
    @PutMapping
    @Transactional
    public ResponseEntity atualizarClient (@RequestBody @Valid AtualizarClient atualiza){
        var client = repository.getReferenceById(atualiza.id());
        client.atualizarCadastro(atualiza);

        return ResponseEntity.ok(new DadosClient(client));
    }

    //Testado com postman, funcionando
    @DeleteMapping("/{id}")
    @Transactional
    //Retornando codigo 204
    public ResponseEntity excluir (@PathVariable Long id){
        var client = repository.getReferenceById(id);
        client.excluir();
        return ResponseEntity.noContent().build();
    }

    //Buscando cliente especifico, e detalhando seus dados
    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity detalhar (@PathVariable Long id){
        var client = repository.getReferenceById(id);
        return ResponseEntity.ok( new DadosClient(client));
    }
}


package br.com.BarbeShop.Controller;

import br.com.BarbeShop.dto.AtualizaBarber;
import br.com.BarbeShop.dto.AtualizarClient;
import br.com.BarbeShop.dto.CadastroClient;
import br.com.BarbeShop.dto.DadosClient;
import br.com.BarbeShop.model.Client;
import br.com.BarbeShop.repository.IClientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClientController {

    @Autowired
    private IClientRepository repository;

    //Testado com postman, funcionando.
    @PostMapping
    @Transactional
    public void cadastrarClient(@RequestBody @Valid CadastroClient client){
        repository.save( new Client(client));
    }

    //Testado com postman, funcionando.
    //Colocamos para ser mostrado em paginas os clientes, com a Classe Pageable do Spring
    //PageableDefault usado para limitar oque vai aparecer com a requisição
    @GetMapping
    public Page<DadosClient> listaClient(@PageableDefault(size = 10) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosClient::new);
    }

    //Testado com postman, fuincionando
    //Atualização por id, colocar id antes de atualizar
    @PutMapping
    @Transactional
    public void atualizarClient (@RequestBody @Valid AtualizarClient atualiza){
        var client = repository.getReferenceById(atualiza.id());
        client.atualizarCadastro(atualiza);
    }

    //Testado com postman, funcionando
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir (@PathVariable Long id){
        var client = repository.getReferenceById(id);
        client.excluir();
    }

}

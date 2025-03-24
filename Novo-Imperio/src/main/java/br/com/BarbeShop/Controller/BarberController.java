package br.com.BarbeShop.Controller;

import br.com.BarbeShop.dto.AtualizaBarber;
import br.com.BarbeShop.dto.CadastroBarber;
import br.com.BarbeShop.dto.DadosBarbe;
import br.com.BarbeShop.model.Barber;
import br.com.BarbeShop.repository.IBarberRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/barbeiros")
public class BarberController {

    @Autowired
     private IBarberRepository repository;

    //@RequestBody quando a requisição vem pelo corpo do Json
    //@Valid para usar a validação que colocamos no CadastroBarber
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid CadastroBarber dados, UriComponentsBuilder uriBuilder){
        var barbe = new Barber(dados);
        repository.save(barbe);
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(barbe.getId()).toUri();
        return ResponseEntity.created(uri).body( new DadosBarbe(barbe));
    }

//  Listar somente os perfis de barbeiros que estão ativos
    @GetMapping
    @Transactional
    public ResponseEntity<List<DadosBarbe>> listaBarbeiro(){
        var lista =  repository.findAllByAtivoTrue().stream().map(DadosBarbe::new).toList();
        return ResponseEntity.ok(lista);
    }

    //Anotação para atulaização de cadastro
    @PutMapping
    @Transactional
    public ResponseEntity atualizarDados(@RequestBody @Valid AtualizaBarber atualiza){
        var barber = repository.getReferenceById(atualiza.id());
        barber.atualizarCadastro(atualiza);

        return ResponseEntity.ok(new DadosBarbe(barber));
    }

//    Exclusão simples apaga todos os registros do banco de dados
//    @DeleteMapping("/{id}")
//    public void excluir(@PathVariable Long id){
//        repository.deleteById(id);
//    }

//  Deletando de forma logica, so tornando o nome da coluna ativo em falso
    @DeleteMapping("/{id}")
    @Transactional
//  RespondeEntity volta uma resposta 204, a sim falando que nossa requisição não tem retorno
    public ResponseEntity excluir(@PathVariable Long id){
        var barber = repository.getReferenceById(id);
        barber.excluir();
        return ResponseEntity.noContent().build();
    }

    //Buscar barbeiro e detalhar as informações
    @GetMapping("/{id}")
    public ResponseEntity detalhar (@PathVariable Long id){
        var barber = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosBarbe(barber));
    }
}

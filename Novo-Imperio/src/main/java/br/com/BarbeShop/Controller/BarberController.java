package br.com.BarbeShop.Controller;

import br.com.BarbeShop.dto.AtualizaBarber;
import br.com.BarbeShop.dto.CadastroBarber;
import br.com.BarbeShop.dto.DadosBarbe;
import br.com.BarbeShop.model.Barber;
import br.com.BarbeShop.repository.IBarberRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
    public void cadastrar(@RequestBody @Valid CadastroBarber cadastro){
        repository.save(new Barber(cadastro));
    }

//  Listar somente os perfis de barbeiros que estão ativos
    @GetMapping
    @Transactional
    public List<DadosBarbe> listaBarbeiro(){
        return repository.findAllByAtivoTrue().stream().map(DadosBarbe::new).toList();
    }

    //Anotação para atulaização de cadastro
    @PutMapping
    @Transactional
    public void atualizarDados(@RequestBody @Valid AtualizaBarber atualiza){
        var barber = repository.getReferenceById(atualiza.id());
        barber.atualizarCadastro(atualiza);
    }

//    Exclusão simples apaga todos os registros do banco de dados
//    @DeleteMapping("/{id}")
//    public void excluir(@PathVariable Long id){
//        repository.deleteById(id);
//    }

//  Deletando de forma logica, so tornando o nome da coluna ativo em falso
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var barber = repository.getReferenceById(id);
        barber.excluir();
    }
}

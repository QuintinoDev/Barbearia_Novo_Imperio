package br.com.barbershop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
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

import com.fasterxml.jackson.annotation.JsonView;

import br.com.barbershop.model.Barber;
import br.com.barbershop.repository.BarberRepository;
import br.com.barbershop.util.assignment.Views;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/barbeiros")
public class BarberController {

    @Autowired
    private BarberRepository repository;
    
    @GetMapping("/{id}")
    @Transactional
    @JsonView(Views.Viewable.class)
    public ResponseEntity<Barber> consultar(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok) 
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping
    @Transactional
    @JsonView(Views.Viewable.class)
    public ResponseEntity<Page<Barber>> consultar(@PageableDefault(size = 10) Pageable paginacao){
    	Page<Barber> page = repository.findAllByAtivoTrue(paginacao);
    	return ResponseEntity.ok(page);
    }

    @PostMapping
    @Transactional
    @JsonView(Views.Viewable.class)
    public ResponseEntity<Barber> cadastrar(@RequestBody @Valid @JsonView(Views.Editable.class) Barber barber) {
        Barber savedBarber = repository.save(barber);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBarber); 
    }

    @PutMapping("/{id}")
    @Transactional
    @JsonView(Views.Viewable.class)
    public ResponseEntity<Barber> atualizarDados(@PathVariable Long id, @RequestBody @Valid @JsonView(Views.Editable.class) Barber barber){
    	Barber updatedBarber = repository.findOneAndUpdateAttributes(barber, id); 
    	return ResponseEntity.ok(repository.save(updatedBarber));
    }
    
    @DeleteMapping("/{id}")
    @Transactional
    @JsonView(Views.Viewable.class)
    public ResponseEntity<Void> excluir(@PathVariable Long id){
    	Barber barber = repository.getReferenceById(id);
    	barber.logicalDelete();
    	repository.save(barber);
    	
    	return ResponseEntity.noContent().build();
    }
}

package br.com.barbershop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
    public Optional<Barber> consultar(@PathVariable Long id){
    	return repository.findById(id);
    }
    
    @GetMapping
    @Transactional
    @JsonView(Views.Viewable.class)
    public List<Barber> consultar(){
    	return repository.findAll();
    }

    @PostMapping
    @Transactional
    @JsonView(Views.Viewable.class)
    public Barber cadastrar(@RequestBody @Valid Barber barber){
		return repository.save(barber);
    }

    @PutMapping
    @Transactional
    @JsonView(Views.Viewable.class)
    public Barber atualizarDados(@RequestBody @Valid Barber barber){
    	barber = repository.findOneAndUpdateAttributes(barber); 
    	return repository.save(barber);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @JsonView(Views.Viewable.class)
    public void excluir(@PathVariable Long id){
    	Barber barber = repository.getReferenceById(id);
    	repository.delete(barber);
    }
}

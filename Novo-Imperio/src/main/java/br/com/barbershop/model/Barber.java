package br.com.barbershop.model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.barbershop.util.assignment.Create;
import br.com.barbershop.util.assignment.Views;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "barbeiros")
public class Barber extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Viewable.class)
    private Long id;
    
    @NotBlank
    @Size(min=1, max=50)
	@JsonView(Views.Editable.class)
    private String nome;
    
    @NotBlank
    @Size(min=1, max=50)
	@JsonView(Views.Editable.class)
    private String senha;

    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", message = "{email.violation}")
    @JsonView(Views.Editable.class)
    private String email;

    @NotBlank
    @Pattern(regexp = "^(\\+\\d{1,3}\\s?)?(\\(?\\d{2,4}\\)?\\s?)?\\d{4,5}-?\\d{4}$", message = "{phone.violation}")
    @JsonView(Views.Editable.class)
    private String telefone;

    @NotBlank(groups = Create.class)
    @JsonView(Views.Create.class)
    private String especialidade;

    @NotNull
    @JsonView(Views.Internal.class)
    private Boolean ativo = true;

    @CreationTimestamp 
    @Column(updatable = false) 
    @JsonView(Views.Viewable.class)
    private LocalDateTime dataCadastro;

    @OneToMany(mappedBy = "barbeiro", cascade = CascadeType.ALL)
    @JsonView(Views.Viewable.class)
    private List<Scheduling> agendamentos;
    
    public void logicalDelete() {
    	this.ativo = false;
    }
}

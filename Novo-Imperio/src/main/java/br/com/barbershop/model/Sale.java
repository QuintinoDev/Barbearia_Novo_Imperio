package br.com.barbershop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

import br.com.barbershop.util.enumerated.StatusPayment;

@Getter
@Setter

@Entity
@Table(name = "venda")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Client cliente;

    @ManyToMany
    @JoinTable(name = "venda_produto",
            joinColumns = @JoinColumn(name = "venda_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id"))
    private List<Product> produtos;

    private LocalDate dataVenda;

    private Double valorTotal;

    @Enumerated(EnumType.STRING)
    private StatusPayment formaPagamento;

    public Sale(){}

    public Sale(Client cliente, List<Product> produtos, LocalDate dataVenda, Double valorTotal, StatusPayment formaPagamento) {
        this.cliente = cliente;
        this.produtos = produtos;
        this.dataVenda = dataVenda;
        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;
    }
}

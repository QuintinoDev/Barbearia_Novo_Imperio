package br.com.NovoImperioBarbearia.Novo.Imperio.modelo;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getCliente() {
        return cliente;
    }

    public void setCliente(Client cliente) {
        this.cliente = cliente;
    }

    public List<Product> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Product> produtos) {
        this.produtos = produtos;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public StatusPayment getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(StatusPayment formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}

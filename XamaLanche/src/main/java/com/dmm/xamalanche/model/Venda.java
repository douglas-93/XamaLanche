package com.dmm.xamalanche.model;

import com.dmm.xamalanche.enums.FormaPagamento;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "vendas")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private BigDecimal Valor;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Produto> produtos;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;

    @Version
    private Integer versao = 0;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return Valor;
    }

    public void setValor(BigDecimal valor) {
        Valor = valor;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Integer getVersao() {
        return versao;
    }

    public void setVersao(Integer versao) {
        this.versao = versao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venda venda = (Venda) o;
        return Objects.equals(id, venda.id) && Objects.equals(Valor, venda.Valor) && Objects.equals(produtos, venda.produtos) && Objects.equals(cliente, venda.cliente) && formaPagamento == venda.formaPagamento;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Valor, produtos, cliente, formaPagamento);
    }
}

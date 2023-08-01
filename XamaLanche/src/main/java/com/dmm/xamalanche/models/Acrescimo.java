package com.dmm.xamalanche.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "acrescimosProdutos")
public class Acrescimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private Boolean ativo;

    private BigDecimal valor;

    private Integer quantidade;

    @ManyToOne
    private Produto produto;

    @Version
    private Integer versao = 0;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
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
        Acrescimo acrescimo = (Acrescimo) o;
        return Objects.equals(id, acrescimo.id) && Objects.equals(nome, acrescimo.nome) && Objects.equals(ativo, acrescimo.ativo) && Objects.equals(valor, acrescimo.valor) && Objects.equals(quantidade, acrescimo.quantidade) && Objects.equals(produto, acrescimo.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, ativo, valor, quantidade, produto);
    }
}

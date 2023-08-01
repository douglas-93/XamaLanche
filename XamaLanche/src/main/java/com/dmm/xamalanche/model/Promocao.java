package com.dmm.xamalanche.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "promocao")
public class Promocao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Boolean ativo;

    private Date dataAtivacao;

    private Date dataValidade;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "promocao")
    private List<Produto> produtos;

    @Version
    private Integer versao = 0;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Date getDataAtivacao() {
        return dataAtivacao;
    }

    public void setDataAtivacao(Date dataAtivacao) {
        this.dataAtivacao = dataAtivacao;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
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
        Promocao promocao = (Promocao) o;
        return Objects.equals(id, promocao.id) && Objects.equals(ativo, promocao.ativo) && Objects.equals(dataAtivacao, promocao.dataAtivacao) && Objects.equals(dataValidade, promocao.dataValidade) && Objects.equals(produtos, promocao.produtos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ativo, dataAtivacao, dataValidade, produtos);
    }
}

package com.dmm.xamalanche.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "entrega")
public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Venda venda;

    @OneToOne
    private Endereco endereco;

    @OneToOne
    private Colaborador colaborador;

    @Version
    private Integer versao = 0;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
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
        Entrega entrega = (Entrega) o;
        return Objects.equals(id, entrega.id) && Objects.equals(venda, entrega.venda) && Objects.equals(endereco, entrega.endereco) && Objects.equals(colaborador, entrega.colaborador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, venda, endereco, colaborador);
    }
}

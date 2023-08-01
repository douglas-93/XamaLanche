package com.dmm.xamalanche.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String telefone;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
    private List<Endereco> endereco;

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

//    public List<Endereco> getEndereco() {
//        return endereco;
//    }
//
//    public void setEndereco(List<Endereco> endereco) {
//        this.endereco = endereco;
//    }

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
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id) && Objects.equals(nome, cliente.nome) && Objects.equals(telefone, cliente.telefone) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, telefone);
    }
}

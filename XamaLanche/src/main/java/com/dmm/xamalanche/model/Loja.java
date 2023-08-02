package com.dmm.xamalanche.model;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "loja")
public class Loja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "loja")
//    private List<Endereco> endereco;

    private Double pedidoMinimo;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "loja")
//    private List<Cardapio> cardapio;

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

//    public List<Endereco> getEndereco() {
//        return endereco;
//    }
//
//    public void setEndereco(List<Endereco> endereco) {
//        this.endereco = endereco;
//    }

    public double getPedidoMinimo() {
        return pedidoMinimo;
    }

    public void setPedidoMinimo(Double pedidoMinimo) {
        this.pedidoMinimo = pedidoMinimo;
    }

//    public List<Cardapio> getCardapio() {
//        return cardapio;
//    }
//
//    public void setCardapio(List<Cardapio> cardapio) {
//        this.cardapio = cardapio;
//    }

    public Integer getVersao() {
        return versao;
    }

    public void setVersao(Integer versao) {
        this.versao = versao;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Loja loja = (Loja) o;
//        return Objects.equals(id, loja.id) && Objects.equals(nome, loja.nome) && Objects.equals(endereco, loja.endereco) && Objects.equals(pedidoMinimo, loja.pedidoMinimo) && Objects.equals(cardapio, loja.cardapio);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, nome, endereco, pedidoMinimo, cardapio);
//    }
}

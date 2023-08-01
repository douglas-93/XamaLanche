package com.dmm.xamalanche.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private Boolean ativo;

    private BigDecimal valor;

    private Integer quantidade;

    @ManyToOne
    private Cardapio cardapio;


    @Version
    private Integer versao=0;
}

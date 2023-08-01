package com.dmm.xamalanche.models;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cardapios")
public class Cardapio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private Boolean ativo;

    private Date dataAtivacao;

    @ManyToOne
    private Loja loja;

    @OneToMany
    private List<Produto> produtos;

    @Version
    private Integer versao=0;
}

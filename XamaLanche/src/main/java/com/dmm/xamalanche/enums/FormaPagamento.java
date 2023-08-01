package com.dmm.xamalanche.enums;

public enum FormaPagamento {
    DINHEIRO("Dinheiro"),
    DEBITO("Débito"),
    CREDITO("Credito"),
    VALE("Vale"),
    PIX("PIX")
    ;

    FormaPagamento(String nome) {
        this.nome = nome;
    }

    private String nome;
}

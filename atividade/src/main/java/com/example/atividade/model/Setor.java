package com.example.atividade.model;

public enum Setor {
    ENGENHARIA("Engenharia"),
    SAUDE("Saúde"),
    JURIDICO("Juridico");

    private String texto;

    Setor(String texto){
        this.texto = texto;
    }
    public String getTexto(){
        return texto;
    }
}

package com.example.atividade1.model;

public enum Sexo {
    MASCULINO("masculino"),
    Feminino("feminino");
    private String texto;

     Sexo(String texto){
        this.texto=texto;
    }
    public String getTexto(){
         return texto;
    }
}

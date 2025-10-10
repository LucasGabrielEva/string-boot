package com.example.atividade1.model;

public enum EstadoCivil {
    SOLTEIRO("solteiro"),
    CASADO("casado"),
    SAPARADO("separado"),
    DIVORCIADO("divorciado"),
    VIUVO("viuvo");

    public String texto;

    EstadoCivil(String texto){
        this.texto=texto;
    }
    public String getTexto(){
        return texto;
    }
}

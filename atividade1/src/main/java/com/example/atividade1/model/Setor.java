package com.example.atividade1.model;

import javax.print.DocFlavor;

public enum Setor {
    ENGENHARIA("engenheiro"),
    SAUDE("saude"),
    JURIDICO("juridico");

    private String texto;

    Setor(String texto){
        this.texto=texto;
    }
    public String getTexto(){
        return texto;
    }

}

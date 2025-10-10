package com.example.aula0910.model;

public enum UnidadeFederativa {
    BAHIA("Bahia"),
    SAO_PAULO("São Paulo"),
    RIO_DE_JANEIRO("Rio de janeiro");
    private String texto;

    UnidadeFederativa(String texto){
        this.texto=texto;
    }
    public String getTexto(){
        return texto;
    }

}

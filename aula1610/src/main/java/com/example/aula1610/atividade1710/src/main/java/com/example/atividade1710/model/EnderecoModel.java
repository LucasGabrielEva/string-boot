package com.example.atividade1710.model;

import jakarta.persistence.*;

@Entity
public class EnderecoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String rua;
    @Column(nullable = false)
    private String logadouro;
    @Column(nullable = false)
    private String numero;
    @Column(nullable = false)
    private String cidade;

    public EnderecoModel() {
    }

    public EnderecoModel(Long id, String rua, String logadouro, String numero, String cidade) {
        this.id = id;
        this.rua = rua;
        this.logadouro = logadouro;
        this.numero = numero;
        this.cidade = cidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getLogadouro() {
        return logadouro;
    }

    public void setLogadouro(String logadouro) {
        this.logadouro = logadouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "EnderecoModel{" +
                "id=" + id +
                ", rua='" + rua + '\'' +
                ", logadouro='" + logadouro + '\'' +
                ", numero='" + numero + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}

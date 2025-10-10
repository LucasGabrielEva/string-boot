package com.example.atividade1.model;

import jakarta.persistence.*;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String logadouro;
    @Column(nullable = false)
    private String numero;
    @Column(nullable = false)
    private String complimeto;
    @Column(nullable = false)
    private String cidade;

    public Endereco() {
    }

    public Endereco(Long id, String logadouro, String numero, String complimeto, String cidade) {
        this.id = id;
        this.logadouro = logadouro;
        this.numero = numero;
        this.complimeto = complimeto;
        this.cidade = cidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getComplimeto() {
        return complimeto;
    }

    public void setComplimeto(String complimeto) {
        this.complimeto = complimeto;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", logadouro='" + logadouro + '\'' +
                ", numero='" + numero + '\'' +
                ", complimeto='" + complimeto + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}

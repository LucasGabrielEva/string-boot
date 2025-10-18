package com.example.atividade1710.model;

public enum FormaPagamento {
    CARTAO("cartao"),
    PIX("pix"),
    DINHEIRO("dinheiro");
    private String FormaPagamento;

    FormaPagamento(String FormaPagamento){
        this.FormaPagamento = FormaPagamento;
    }
    public String getFormaPagamento(){
        return FormaPagamento;
    }

}

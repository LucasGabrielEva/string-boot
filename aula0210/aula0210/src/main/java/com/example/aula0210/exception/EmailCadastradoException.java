package com.example.aula0210.exception;

public class EmailCadastradoException extends IllegalArgumentException {
    public EmailCadastradoException (String mensagem){
        super(mensagem);
    }

}

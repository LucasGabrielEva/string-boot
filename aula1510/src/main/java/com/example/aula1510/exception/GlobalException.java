package com.example.aula1510.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalException {
    // Padronizando mensagem exceção do Service
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> illegalArgumentoException(IllegalArgumentException erro) {
        return ResponseEntity
                .badRequest()
                .body(Map.of(
                        "mensagem", erro.getMessage(),
                        "sucesso", false));
    }
    //Padronizando mensagem de exceção de validação do ResquestDTO.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> methorArgumentoNotValidException(MethodArgumentNotValidException erro) {
        return ResponseEntity
                .badRequest()
                .body(Map.of(
                        "mensagem", erro.getFieldErrors().get(0).getDefaultMessage(),
                        "sucesso", false));
    }
}

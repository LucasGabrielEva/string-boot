package com.example.aula1709.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {
    @GetMapping("/")
    public String mensagem() {
        return "Bem-vindo";
    }
    @GetMapping("/dev")
    public String dev() {
        return "óla lucas gabriel";
    }


}

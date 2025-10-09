package com.example.aula0810.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {
    @GetMapping("/")
    public String menssagem(){
        return "Bem vindo";
    }
}

package com.example.aula0210;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {
    @GetMapping("/")
    public String messagem(){
        return "Bem vindo";
    }




}

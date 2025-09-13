package com.example.projeto2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

@Entity
@Table(name = "tab_cliente")
@AllArgsConstructor // Substitui o construtor completo .
@NoArgsConstructor // Substitui o construtor vazio.
@Data // Substitui getters e setters e toString.
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String telefone;




}

package br.thiago.com.forumHub.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String categoria;
}


package br.thiago.com.forumHub.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String mensagem;

    @Column(nullable = false)
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Column(nullable = false)
    private String estado;

    @ManyToOne
    private Usuario autor;

    @ManyToOne
    private Topico topico;

    @Column(nullable = false)
    private boolean solucao = false;
}

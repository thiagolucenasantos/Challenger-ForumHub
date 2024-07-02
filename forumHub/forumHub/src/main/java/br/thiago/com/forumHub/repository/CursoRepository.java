package br.thiago.com.forumHub.repository;

import br.thiago.com.forumHub.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}

package br.thiago.com.forumHub.repository;

import br.thiago.com.forumHub.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    List<Topico> findTop10ByOrderByDataCriacaoAsc();
    List<Topico> findByCursoNomeAndDataCriacaoYear(String nomeCurso, int ano);
}

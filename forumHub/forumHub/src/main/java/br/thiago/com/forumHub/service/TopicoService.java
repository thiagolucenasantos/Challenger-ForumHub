package br.thiago.com.forumHub.service;


import br.thiago.com.forumHub.model.Topico;
import br.thiago.com.forumHub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public Topico salvar(Topico topico) {
        return topicoRepository.save(topico);
    }

    public List<Topico> listarTodos() {
        return topicoRepository.findAll();
    }

    public Optional<Topico> buscarPorId(Long id) {
        return topicoRepository.findById(id);
    }

    public List<Topico> listarTop10() {
        return topicoRepository.findTop10ByOrderByDataCriacaoAsc();
    }

    public List<Topico> listarPorCursoEAno(String nomeCurso, int ano) {
        return topicoRepository.findByCursoNomeAndDataCriacaoYear(nomeCurso, ano);
    }

    public void deletar(Long id) {
        topicoRepository.deleteById(id);
    }
}

package br.thiago.com.forumHub.controller;



import br.thiago.com.forumHub.model.Topico;
import br.thiago.com.forumHub.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/topicos")
@Validated
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    public ResponseEntity<Topico> criarTopico(@RequestBody @Valid Topico topico) {
        return ResponseEntity.ok(topicoService.salvar(topico));
    }

    @GetMapping
    public ResponseEntity<List<Topico>> listarTopicos() {
        return ResponseEntity.ok(topicoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> detalharTopico(@PathVariable Long id) {
        return topicoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topico> atualizarTopico(@PathVariable Long id, @RequestBody @Valid Topico topico) {
        return topicoService.buscarPorId(id)
                .map(existingTopico -> {
                    topico.setId(existingTopico.getId());
                    return ResponseEntity.ok(topicoService.salvar(topico));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTopico(@PathVariable Long id) {
        return topicoService.buscarPorId(id)
                .map(topico -> {
                    topicoService.deletar(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/top10")
    public ResponseEntity<List<Topico>> listarTop10() {
        return ResponseEntity.ok(topicoService.listarTop10());
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Topico>> buscarPorCursoEAno(@RequestParam String curso, @RequestParam int ano) {
        return ResponseEntity.ok(topicoService.listarPorCursoEAno(curso, ano));
    }
}

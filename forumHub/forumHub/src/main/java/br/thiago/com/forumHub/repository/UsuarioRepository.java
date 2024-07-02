package br.thiago.com.forumHub.repository;

import br.thiago.com.forumHub.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}

package io.github.lucasaraujodecarvalho.clientes.model.repository;

import io.github.lucasaraujodecarvalho.clientes.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}

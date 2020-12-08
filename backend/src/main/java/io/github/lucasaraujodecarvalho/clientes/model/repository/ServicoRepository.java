package io.github.lucasaraujodecarvalho.clientes.model.repository;

import io.github.lucasaraujodecarvalho.clientes.model.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}

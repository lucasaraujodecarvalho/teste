package io.github.lucasaraujodecarvalho.clientes.rest;

import io.github.lucasaraujodecarvalho.clientes.exception.UsuarioCadastradoException;
import io.github.lucasaraujodecarvalho.clientes.model.entity.Usuario;
import io.github.lucasaraujodecarvalho.clientes.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody @Valid Usuario usuario){
        try {
            service.salvar(usuario);
        } catch (UsuarioCadastradoException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping
    public List<Usuario> obterTodos() {
        return service.obterUsuarios();
    }
}

package io.github.lucasaraujodecarvalho.clientes.service;

import io.github.lucasaraujodecarvalho.clientes.model.entity.Usuario;
import io.github.lucasaraujodecarvalho.clientes.model.repository.UsuarioRepository;
import io.github.lucasaraujodecarvalho.clientes.exception.UsuarioCadastradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario){
        boolean exists = usuarioRepository.existsByUsername(usuario.getUsername());
        if (exists) {
            throw new UsuarioCadastradoException(usuario.getUsername());
        }
        return usuarioRepository.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(s).orElseThrow(() -> new UsernameNotFoundException("Login não encontrado."));

        return User.builder().
                username(usuario.getUsername())
                .password(usuario.getPassword())
                .roles("USER").build();
    }
}

package br.com.dicasdeumdev.api.service;

import br.com.dicasdeumdev.api.domain.Usuario;
import br.com.dicasdeumdev.api.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class UsuarioService {

    public final UsuarioRepository usuarioRepository;

    public Usuario encontrarUser(Integer idUser) {
        Usuario usuarioEncontrado = this.usuarioRepository.findById(idUser)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Usuario não foi encontrado."));

        return usuarioEncontrado;
    }

}

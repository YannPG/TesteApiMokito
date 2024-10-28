package br.com.dicasdeumdev.api.service;

import br.com.dicasdeumdev.api.domain.Usuario;
import br.com.dicasdeumdev.api.domain.dto.UsuarioDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UsuarioService {
    Usuario encontrarPeloUsuario(Integer id);
    ResponseEntity<List<UsuarioDTO>> encontrarTodosUsuarios();
}

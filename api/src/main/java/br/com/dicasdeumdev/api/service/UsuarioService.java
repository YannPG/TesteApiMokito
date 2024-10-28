package br.com.dicasdeumdev.api.service;

import br.com.dicasdeumdev.api.domain.Usuario;

public interface UsuarioService {
    Usuario encontrarPeloUsuario(Integer id);
}

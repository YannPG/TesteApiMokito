package br.com.dicasdeumdev.api.service.shared;

import br.com.dicasdeumdev.api.domain.Usuario;
import br.com.dicasdeumdev.api.domain.forms.AtualizarUsuarioForms;
import br.com.dicasdeumdev.api.domain.forms.UsuarioForm;

public interface SharedUsuario {
  Usuario encontrarUsuarioPeloRegistro(String codigoRegistro);

  void validarEmail(AtualizarUsuarioForms usuarioForm);

  void validarEmail(UsuarioForm usuarioForm);
}

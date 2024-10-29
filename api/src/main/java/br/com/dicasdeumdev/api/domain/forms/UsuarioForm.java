package br.com.dicasdeumdev.api.domain.forms;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

@Getter
public class UsuarioForm {

  private String nome;

  private String email;

  @JsonIgnore
  private String password;

  private String codigoRegistro;
}

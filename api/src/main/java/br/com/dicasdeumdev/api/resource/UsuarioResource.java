package br.com.dicasdeumdev.api.resource;

import br.com.dicasdeumdev.api.domain.dto.UsuarioDTO;
import br.com.dicasdeumdev.api.domain.forms.AtualizarUsuarioForms;
import br.com.dicasdeumdev.api.domain.forms.UsuarioForm;
import br.com.dicasdeumdev.api.service.UsuarioService;
import java.util.List;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/user")
public class UsuarioResource {

  private final UsuarioService usuarioService;
  private ModelMapper modelMapper;

  @GetMapping(path = "/id-usuario/{idUser}")
  public ResponseEntity<UsuarioDTO> encontrarUser(@PathVariable Integer idUser) {
    return ResponseEntity.ok()
        .body(modelMapper.map(this.usuarioService.encontrarPeloUsuario(idUser), UsuarioDTO.class));
  }

  @GetMapping(path = "/todo-usuario")
  public ResponseEntity<List<UsuarioDTO>> encontrarTodosUsuario() {
    return this.usuarioService.encontrarTodosUsuarios();
  }

  @GetMapping(path = "/registro-usuario/{codigoRegistro}")
  public ResponseEntity<UsuarioDTO> encontrarUsuarioPeloRegistro(
      @PathVariable String codigoRegistro) {
    return ResponseEntity.ok()
        .body(this.usuarioService.encontrarUsuarioPeloRegistro(codigoRegistro));
  }

  @PostMapping(path = "/criar-usuario")
  public ResponseEntity<UsuarioDTO> criarNovoUsuario(@RequestBody UsuarioForm usuarioCriado) {
    return ResponseEntity.ok().body(this.usuarioService.criarUsuario(usuarioCriado));
  }

  @PutMapping(path = "/atualizar-usuario/{codigoRegistro}")
  public ResponseEntity<UsuarioDTO> atualizarUsuario(
      @PathVariable String codigoRegistro, @RequestBody AtualizarUsuarioForms usuarioAtualizado) {
    return ResponseEntity.ok()
        .body(this.usuarioService.atualizarUsuario(usuarioAtualizado, codigoRegistro));
  }

  @DeleteMapping("/deletar-usuario/{codigoRegistro}")
  public void deletarUsuario(@PathVariable String codigoRegistro) {

    this.usuarioService.deletarUsuarioCodigoRegistro(codigoRegistro);
  }
}

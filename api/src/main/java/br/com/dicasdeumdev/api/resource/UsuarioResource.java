package br.com.dicasdeumdev.api.resource;

import br.com.dicasdeumdev.api.domain.dto.UsuarioDTO;
import br.com.dicasdeumdev.api.domain.forms.UsuarioForm;
import br.com.dicasdeumdev.api.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/user")
public class UsuarioResource {

    private ModelMapper modelMapper;

    private final UsuarioService usuarioService;

    @GetMapping(path = "/usuario/{idUser}")
    public ResponseEntity<UsuarioDTO> encontrarUser(@PathVariable Integer idUser){
        return ResponseEntity.ok().body(modelMapper.map(this.usuarioService.encontrarPeloUsuario(idUser), UsuarioDTO.class));
    }

    @GetMapping(path = "/usuario")
    public ResponseEntity<List<UsuarioDTO>> encontrarTodosUsuario(){
        return this.usuarioService.encontrarTodosUsuarios();
    }

    @PostMapping(path = "/criar-usuario")
    public ResponseEntity<UsuarioDTO> criarNovoUsuario(@RequestBody UsuarioForm usuarioCriado){
        return ResponseEntity.ok().body(this.usuarioService.criarUsuario(usuarioCriado));
    }
}

package br.com.dicasdeumdev.api.resource;

import br.com.dicasdeumdev.api.domain.Usuario;
import br.com.dicasdeumdev.api.domain.dto.UsuarioDTO;
import br.com.dicasdeumdev.api.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

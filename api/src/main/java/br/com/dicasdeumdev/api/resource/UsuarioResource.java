package br.com.dicasdeumdev.api.resource;

import br.com.dicasdeumdev.api.domain.Usuario;
import br.com.dicasdeumdev.api.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/user")
public class UsuarioResource {

    private final UsuarioService usuarioService;

    @GetMapping(path = "/usuario/{idUser}")
    public ResponseEntity<Usuario> encontrarUser(@PathVariable Integer idUser){
        return ResponseEntity.ok().body(this.usuarioService.encontrarPeloUsuario(idUser));
    }
}
package br.com.dicasdeumdev.api.service.UsuarioServiceImpl;

import br.com.dicasdeumdev.api.domain.Usuario;
import br.com.dicasdeumdev.api.domain.dto.UsuarioDTO;
import br.com.dicasdeumdev.api.repository.UsuarioRepository;
import br.com.dicasdeumdev.api.service.UsuarioService;
import br.com.dicasdeumdev.api.service.exceptions.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsusarioServiceImpl implements UsuarioService {

    public final UsuarioRepository usuarioRepository;

    @Override
    public Usuario encontrarPeloUsuario(Integer idUser) {
        Optional<Usuario> usuarioEncontrado = this.usuarioRepository.findById(idUser);
        return usuarioEncontrado.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado. "));
    }

    @Override
    public ResponseEntity<List<UsuarioDTO>> encontrarTodosUsuarios(){
        return ResponseEntity.ok().body(UsuarioDTO.converte(this.usuarioRepository.findAll()));
    }
}

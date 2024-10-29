package br.com.dicasdeumdev.api.service.UsuarioServiceImpl;

import br.com.dicasdeumdev.api.domain.Usuario;
import br.com.dicasdeumdev.api.domain.dto.UsuarioDTO;
import br.com.dicasdeumdev.api.domain.forms.AtualizarUsuarioForms;
import br.com.dicasdeumdev.api.domain.forms.UsuarioForm;
import br.com.dicasdeumdev.api.repository.UsuarioRepository;
import br.com.dicasdeumdev.api.service.UsuarioService;
import br.com.dicasdeumdev.api.service.exceptions.ObjectNotFoundException;
import br.com.dicasdeumdev.api.service.shared.SharedUsuarioImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final SharedUsuarioImpl sharedUsuarioImpl;

    @Override
    public UsuarioDTO encontrarUsuarioPeloRegistro(String codigoRegistro){
        Usuario usuarioEncontrado = this.usuarioRepository
                .findByCodigoRegistro(codigoRegistro)
                .orElseThrow(()-> new ObjectNotFoundException("Não foi encontrado usuario com este registro."));
        return UsuarioDTO.converte(usuarioEncontrado);
    }

    @Override
    public Usuario encontrarPeloUsuario(Integer idUser) {
        Optional<Usuario> usuarioEncontrado = this.usuarioRepository.findById(idUser);
        return usuarioEncontrado.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado. "));
    }

    @Override
    public ResponseEntity<List<UsuarioDTO>> encontrarTodosUsuarios(){
        return ResponseEntity.ok().body(UsuarioDTO.converte(this.usuarioRepository.findAll()));
    }

    @Override
    public UsuarioDTO criarUsuario(UsuarioForm usuarioForm) {
        this.sharedUsuarioImpl.validarEmail(usuarioForm);
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(usuarioForm.getNome());
        novoUsuario.setEmail(usuarioForm.getEmail());
        novoUsuario.setPassword(usuarioForm.getPassword());
        novoUsuario.setCodigoRegistro((usuarioForm.getCodigoRegistro()));

        return UsuarioDTO.converte(this.usuarioRepository.save(novoUsuario));
    }

    @Override
    public UsuarioDTO atualizarUsuario(AtualizarUsuarioForms usuarioAtualizado, String codigoRegistro) {
        this.sharedUsuarioImpl.validarEmail(usuarioAtualizado);
        Usuario usuarioEncontrado = this.sharedUsuarioImpl
                .encontrarUsuarioPeloRegistro(codigoRegistro);
            usuarioEncontrado.setNome(usuarioAtualizado.getNome());
            usuarioEncontrado.setEmail(usuarioAtualizado.getEmail());
            usuarioEncontrado.setPassword(usuarioAtualizado.getPassword());
            usuarioEncontrado.setCodigoRegistro(codigoRegistro);
        this.usuarioRepository.save(usuarioEncontrado);
        return UsuarioDTO.converte(usuarioEncontrado);
    }
}

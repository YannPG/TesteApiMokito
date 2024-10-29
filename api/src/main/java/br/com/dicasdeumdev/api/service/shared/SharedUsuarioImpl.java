package br.com.dicasdeumdev.api.service.shared;

import br.com.dicasdeumdev.api.domain.Usuario;
import br.com.dicasdeumdev.api.domain.forms.AtualizarUsuarioForms;
import br.com.dicasdeumdev.api.domain.forms.UsuarioForm;
import br.com.dicasdeumdev.api.repository.UsuarioRepository;
import br.com.dicasdeumdev.api.service.exceptions.BadRequest;
import br.com.dicasdeumdev.api.service.exceptions.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SharedUsuarioImpl implements SharedUsuario {

    private final UsuarioRepository usuarioRepository;

    @Override
    public Usuario encontrarUsuarioPeloRegistro(String codigoRegistro){
        Usuario usuarioEncontrado = this.usuarioRepository
                .findByCodigoRegistro(codigoRegistro)
                .orElseThrow(()-> new ObjectNotFoundException("Não foi encontrado usuario com este registro."));
        return usuarioEncontrado;
    }

    @Override
    public void validarEmail(UsuarioForm usuarioForm) {
        boolean usuarioEncontrado = this.usuarioRepository
                .existsByEmail(usuarioForm.getEmail());
        if (usuarioEncontrado) {
            throw new BadRequest("Email já cadastrado.");
        }
    }

    @Override
    public void validarEmail(AtualizarUsuarioForms usuarioForm) {
        boolean usuarioEncontrado = this.usuarioRepository
                .existsByEmail(usuarioForm.getEmail());
        if (usuarioEncontrado) {
            throw new BadRequest("Email já cadastrado.");
        }
    }
}

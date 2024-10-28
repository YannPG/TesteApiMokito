package br.com.dicasdeumdev.api.domain.dto;

import br.com.dicasdeumdev.api.domain.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private Integer id;

    private String nome;

    private String email;

    @JsonIgnore
    private String password;

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.password = usuario.getPassword();
    }

    public static List<UsuarioDTO> converte (List<Usuario> usuarios){
        return usuarios.stream()
                .map(UsuarioDTO::new)
                .collect(Collectors.toList());
    }
}

package br.com.dicasdeumdev.api.repository;

import br.com.dicasdeumdev.api.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    boolean existsByEmail(String email);
    Optional<Usuario> findByCodigoRegistro(String codigoRegistro);
}

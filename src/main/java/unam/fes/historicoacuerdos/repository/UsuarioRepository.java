package unam.fes.historicoacuerdos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unam.fes.historicoacuerdos.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByUsername(String username);
}

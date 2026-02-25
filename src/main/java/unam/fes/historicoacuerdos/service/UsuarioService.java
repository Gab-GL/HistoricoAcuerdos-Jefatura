package unam.fes.historicoacuerdos.service;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import unam.fes.historicoacuerdos.model.Usuario;
import unam.fes.historicoacuerdos.repository.UsuarioRepository;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario autenticar(String username, String password) {
        Optional<Usuario> optionalUsuario =
                usuarioRepository.findByUsername(username);

        if (optionalUsuario.isEmpty()) {
            return null;
        }

        Usuario usuario = optionalUsuario.get();

        if (BCrypt.checkpw(password, usuario.getPassword())) {
            return usuario;
        }

        return null;
    }

    public Usuario crearUsuario(String username, String password) {

        String hash = BCrypt.hashpw(password, BCrypt.gensalt());

        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setPassword(hash);

        return usuarioRepository.save(usuario);
    }

}


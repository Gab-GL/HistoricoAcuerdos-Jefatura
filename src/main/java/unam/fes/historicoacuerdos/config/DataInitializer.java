package unam.fes.historicoacuerdos.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import unam.fes.historicoacuerdos.service.UsuarioService;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UsuarioService usuarioService;

    public DataInitializer(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    public void run(String... args) {
        //usuarioService.crearUsuario("jefatura", "ico8080");
    }
}

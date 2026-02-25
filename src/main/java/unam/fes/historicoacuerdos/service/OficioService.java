package unam.fes.historicoacuerdos.service;

import org.springframework.stereotype.Service;
import unam.fes.historicoacuerdos.model.Oficio;
import unam.fes.historicoacuerdos.repository.OficioRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class OficioService {

    private final OficioRepository oficioRepository;

    public OficioService(OficioRepository oficioRepository) {
        this.oficioRepository = oficioRepository;
    }

    public void guardar(Oficio oficio) {

        boolean regenerarHash = false;

        // Caso 1: registro nuevo
        if (oficio.getIdOficio() == null) {
            regenerarHash = true;
        }
        // Caso 2: registro existente
        else {
            Oficio existente = oficioRepository
                    .findById(oficio.getIdOficio())
                    .orElseThrow(() -> new RuntimeException("Oficio no encontrado"));

            // Comparación campo por campo
            if (!oficio.getPersona().equals(existente.getPersona())
                    || !oficio.getArea().equals(existente.getArea())
                    || !oficio.getAsunto().equals(existente.getAsunto())
                    || !oficio.getFecha().equals(existente.getFecha())) {

                regenerarHash = true;
            }
        }

        // Solo si hubo cambios reales
        if (regenerarHash) {
            String hash = UUID.randomUUID()
                    .toString()
                    .replace("-", "");
            oficio.setHash(hash);
        }

        oficioRepository.save(oficio);
    }



    public List<Oficio> obtenerTodos() {
        return oficioRepository.findAll();
    }

    public Oficio buscarPorId(Integer id) {
        return oficioRepository.findById(id).orElse(null);
    }

    public void eliminar(Integer id) {
        oficioRepository.deleteById(id);
    }

    public List<Oficio> buscar(String persona, String area, String asunto, LocalDate fecha) {
        return oficioRepository.buscar(persona, area, asunto, fecha);
    }

}


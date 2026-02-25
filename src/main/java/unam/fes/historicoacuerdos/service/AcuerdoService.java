package unam.fes.historicoacuerdos.service;
import org.springframework.stereotype.Service;
import unam.fes.historicoacuerdos.model.Acuerdo;
import unam.fes.historicoacuerdos.repository.AcuerdoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class AcuerdoService {

    private final AcuerdoRepository acuerdoRepository;

    public AcuerdoService(AcuerdoRepository acuerdoRepository) {
        this.acuerdoRepository = acuerdoRepository;
    }

    public List<Acuerdo> buscar(String persona, String area, String asunto, LocalDate fecha) {
        return acuerdoRepository.buscar(persona, area, asunto, fecha);
    }

    public void guardar(Acuerdo acuerdo) {

        boolean regenerarHash = false;

        if (acuerdo.getIdAcuerdo() == null) {
            regenerarHash = true;
        } else {
            Acuerdo existente = acuerdoRepository
                    .findById(acuerdo.getIdAcuerdo())
                    .orElseThrow(() -> new RuntimeException("Acuerdo no encontrado"));

            if (!acuerdo.getPersona().equals(existente.getPersona())
                    || !acuerdo.getArea().equals(existente.getArea())
                    || !acuerdo.getAsunto().equals(existente.getAsunto())
                    || !acuerdo.getFecha().equals(existente.getFecha())) {

                regenerarHash = true;
            }
        }

        if (regenerarHash) {
            acuerdo.setHash(UUID.randomUUID().toString().replace("-", ""));
        }

        acuerdoRepository.save(acuerdo);
    }



    public void eliminar(Integer id) {
        acuerdoRepository.deleteById(id);
    }

    public Acuerdo buscarPorId(Integer id) {
        return acuerdoRepository.findById(id).orElse(null);
    }
}


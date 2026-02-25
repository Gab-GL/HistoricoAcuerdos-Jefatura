package unam.fes.historicoacuerdos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import unam.fes.historicoacuerdos.model.Acuerdo;
import unam.fes.historicoacuerdos.service.AcuerdoService;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/acuerdos")
public class AcuerdoController {

    private final AcuerdoService acuerdoService;

    public AcuerdoController(AcuerdoService acuerdoService) {
        this.acuerdoService = acuerdoService;
    }

    @GetMapping
    public String mostrarAcuerdos(
            @RequestParam(required = false) String persona,
            @RequestParam(required = false) String area,
            @RequestParam(required = false) String asunto,
            @RequestParam(required = false) LocalDate fecha,
            Model model) {

        model.addAttribute("acuerdo", new Acuerdo());

        List<Acuerdo> lista = acuerdoService.buscar(persona, area, asunto, fecha);
        model.addAttribute("lista", lista);

        return "acuerdos";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Acuerdo acuerdo) {
        acuerdoService.guardar(acuerdo);
        return "redirect:/acuerdos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        acuerdoService.eliminar(id);
        return "redirect:/acuerdos";
    }
}


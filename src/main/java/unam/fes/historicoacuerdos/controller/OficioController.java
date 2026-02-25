package unam.fes.historicoacuerdos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import unam.fes.historicoacuerdos.model.Oficio;
import unam.fes.historicoacuerdos.service.OficioService;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/oficios")
public class OficioController {

    private final OficioService oficioService;

    public OficioController(OficioService oficioService) {
        this.oficioService = oficioService;
    }
    

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        oficioService.eliminar(id);
        return "redirect:/oficios";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("oficio", oficioService.buscarPorId(id));
        model.addAttribute("lista", oficioService.obtenerTodos());
        return "oficios";
    }

    @PostMapping("/guardar")
    public String guardarOficio(@ModelAttribute Oficio oficio) {
        oficioService.guardar(oficio);
        return "redirect:/oficios";
    }

    @GetMapping
    public String mostrarOficios(
            @RequestParam(required = false) String persona,
            @RequestParam(required = false) String area,
            @RequestParam(required = false) String asunto,
            @RequestParam(required = false) LocalDate fecha,
            Model model) {

        model.addAttribute("oficio", new Oficio());

        List<Oficio> lista = oficioService.buscar(persona, area, asunto, fecha);
        model.addAttribute("lista", lista);

        System.out.println("persona = " + persona);
        System.out.println("area = " + area);
        System.out.println("asunto = " + asunto);
        System.out.println("fecha = " + fecha);

        return "oficios";
    }





}

package com.Proyecto.controller;

import com.Proyecto.service.OfertaService;
import com.Proyecto.domain.Oferta;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OfertaController {

    @Autowired
    private OfertaService ofertaService;

    @GetMapping("/ofertas")
    public String mostrarOfertas(Model model) {
        List<Oferta> ofertas = ofertaService.obtenerOfertasActivas();
        model.addAttribute("ofertas", ofertas);
        return "ofertas/ofertas";
    }
}


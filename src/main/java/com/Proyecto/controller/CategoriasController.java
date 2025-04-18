package com.Proyecto.controller;

import com.Proyecto.domain.Categoria;
import com.Proyecto.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoriasController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/categoria/categorias")
    public String mostrarCategorias(Model model) {
        model.addAttribute("categorias", categoriaService.getCategorias());
        return "categoria/categorias";
    }

    @GetMapping("/categoria/listado")
    public String listarCategorias(Model model) {
        List<Categoria> categorias = categoriaService.getCategorias();
        model.addAttribute("categorias", categorias);
        return "categoria/listado"; 
    }
}

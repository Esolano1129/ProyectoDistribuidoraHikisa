
package com.Proyecto.controller;

import com.Proyecto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/tienda")
public class TiendaController {
    

    
    @Autowired
    private ProductoService productoService;

    @GetMapping("/listado")
    public String listado(Model model) {

        var productos = productoService.getProductos();
        model.addAttribute("productos", productos);
        
        return "/tienda/listado";
    }
    /*
    @GetMapping("/listado/{idCategoria}")
    public String listado(Model model, Categoria categoria) {
        var lista = categoriaService.getCategorias(false);
        model.addAttribute("categorias", lista);
        categoria=categoriaService.getCategoria(categoria);
        var productos =categoria.getProductos();
        model.addAttribute("productos", productos);
        
        return "/pruebas/listado";
    
    } */
   
    
}
    
    


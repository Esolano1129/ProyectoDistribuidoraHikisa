package com.Proyecto.controller;


import com.Proyecto.domain.Producto;
import com.Proyecto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService ProductoService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = ProductoService.getProductos();
        model.addAttribute("Productos", lista);
        return "/Productos/listado";
    }

    @GetMapping("/eliminar/{idProducto}")
    public String eliminar(Producto Producto) {
        ProductoService.delete(Producto);
        return "redirect:/Productos/listado";
    }

    @GetMapping("/modificar/{idProducto}")
    public String modificar(Producto Producto, Model model) { 
        Producto = ProductoService.getProducto(Producto);
        model.addAttribute("Producto", Producto);
        return "/Productos/modifica";
    }
}

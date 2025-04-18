package com.Proyecto.controller;

import com.Proyecto.domain.Categoria;
import com.Proyecto.domain.Producto;
import com.Proyecto.service.CategoriaService;
import com.Proyecto.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService ProductoService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = ProductoService.getProductos();
        model.addAttribute("productos", lista);
        return "/productos/listado";
    }

    @GetMapping("/eliminar/{idProducto}")
    public String eliminar(Producto Producto) {
        ProductoService.delete(Producto);
        return "redirect:/productos/listado";
    }

    @GetMapping("/modificar/{idProducto}")
    public String modificar(Producto Producto, Model model) {
        Producto = ProductoService.getProducto(Producto);
        model.addAttribute("producto", Producto);
        return "producto/editarProducto";
    }

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/categoria")
    public String productosPorCategoria(@RequestParam("nombre") String nombre, Model model) {
        Categoria categoria = categoriaService.getCategorias()
                .stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);

        if (categoria != null) {
            List<Producto> productos = ProductoService.getProductosPorCategoria(categoria);
            model.addAttribute("productos", productos);
            model.addAttribute("categoria", categoria);
            return "categoria/listado";  // ← Vista deseada
        }

        return "redirect:/categoria/categorias"; // ← Redirige a lista de categorías si no encuentra
    }


}

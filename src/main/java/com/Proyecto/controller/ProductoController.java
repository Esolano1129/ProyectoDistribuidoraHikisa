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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService ProductoService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = ProductoService.getProductos();
        var categorias = categoriaService.getCategorias(); // <-- Agrega esta línea

        model.addAttribute("productos", lista);
        model.addAttribute("categorias", categorias); // <-- Y esta también
        model.addAttribute("producto", new Producto()); // Para el form

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
        model.addAttribute("categorias", categoriaService.getCategorias());
        return "productos/modifica";
    }

    @PostMapping("/guardar")
    public String guardar(Producto producto, @RequestParam("imagenFile") MultipartFile imagenFile) {
        try {
            if (!imagenFile.isEmpty()) {
                String ruta = "/imagenes/";
                String nombreArchivo = UUID.randomUUID().toString() + "_" + imagenFile.getOriginalFilename();

                Path directorio = Paths.get("src/main/resources/static" + ruta);
                Files.createDirectories(directorio);

                Path archivo = directorio.resolve(nombreArchivo);
                imagenFile.transferTo(archivo.toFile());

                producto.setRutaImagen(ruta + nombreArchivo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ProductoService.save(producto);
        return "redirect:/productos/listado";
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

package com.Proyecto.service;

import com.Proyecto.domain.Categoria;
import com.Proyecto.domain.Producto;
import com.Proyecto.repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository ProductoRepository;

    @Transactional(readOnly = true)
    public List<Producto> getProductos() {
        var lista = ProductoRepository.findAll();

        return lista;
    }

    @Transactional(readOnly = true)
    public Producto getProducto(Producto producto) {
        producto = ProductoRepository.findById(producto.getIdProducto()).orElse(null);
        return producto;
    }

    @Transactional
    public void delete(Producto producto) {

        ProductoRepository.delete(producto);
    }

    @Transactional
    public void save(Producto producto) {

        ProductoRepository.save(producto);
    }

    @Transactional(readOnly = true)
    public List<Producto> getProductosPorCategoria(Categoria categoria) {
        return ProductoRepository.findByCategoria(categoria);
    }
}

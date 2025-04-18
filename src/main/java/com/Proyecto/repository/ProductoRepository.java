
package com.Proyecto.repository;

import com.Proyecto.domain.Categoria;
import com.Proyecto.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByCategoria(Categoria categoria);
}

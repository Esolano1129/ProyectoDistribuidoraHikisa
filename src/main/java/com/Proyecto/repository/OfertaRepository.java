package com.Proyecto.repository;

import com.Proyecto.domain.Oferta;
import java.util.List;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfertaRepository extends JpaRepository<Oferta, Long> {
    List<Oferta> findByFechaInicioBeforeAndFechaFinAfter(LocalDate inicio, LocalDate fin);
}
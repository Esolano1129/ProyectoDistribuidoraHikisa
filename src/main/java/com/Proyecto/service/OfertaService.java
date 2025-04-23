package com.Proyecto.service;

import com.Proyecto.domain.Oferta;
import com.Proyecto.repository.OfertaRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfertaService {

    @Autowired
    private OfertaRepository ofertaRepository;

    public List<Oferta> obtenerOfertasActivas() {
        LocalDate hoy = LocalDate.now();
        return ofertaRepository.findByFechaInicioBeforeAndFechaFinAfter(hoy, hoy);
        
      
    }
}


package com.springBajo8.springBajo8.service.impl;

import com.springBajo8.springBajo8.domain.HistorialPacientesDTOReactivo;
import com.springBajo8.springBajo8.domain.citasDTOReactiva;
import com.springBajo8.springBajo8.repository.IhistorialPacienteReactivaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class historialPacienteReactivaService {

    @Autowired
    IhistorialPacienteReactivaRepository historialRepository;

    public Flux<HistorialPacientesDTOReactivo> buscarHistorialPorIdpaciente(String idpaciente){
        return historialRepository.findByIdPaciente(idpaciente);
    }

    public Mono<HistorialPacientesDTOReactivo> save(HistorialPacientesDTOReactivo historialPacientesDTOReactivo) {
        return historialRepository.save(historialPacientesDTOReactivo);
    }
}

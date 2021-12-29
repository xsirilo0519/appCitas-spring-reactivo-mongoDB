package com.springBajo8.springBajo8.web;

import com.springBajo8.springBajo8.domain.HistorialPacientesDTOReactivo;
import com.springBajo8.springBajo8.domain.citasDTOReactiva;
import com.springBajo8.springBajo8.service.impl.historialPacienteReactivaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class historialReactivaResource {
    @Autowired
    historialPacienteReactivaService historialService;

    @GetMapping("/historital/{idPaciente}")
    private Flux<HistorialPacientesDTOReactivo> findAllByidPaciente(@PathVariable("idPaciente") String idPaciente) {
        return this.historialService.buscarHistorialPorIdpaciente(idPaciente);
    }
    @PostMapping("/historital")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<HistorialPacientesDTOReactivo> save(@RequestBody HistorialPacientesDTOReactivo historialPacientesDTOReactivo) {
        return this.historialService.save(historialPacientesDTOReactivo);
    }

}

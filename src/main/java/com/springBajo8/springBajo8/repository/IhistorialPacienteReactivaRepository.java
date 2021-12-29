package com.springBajo8.springBajo8.repository;

import com.springBajo8.springBajo8.domain.HistorialPacientesDTOReactivo;
import com.springBajo8.springBajo8.domain.citasDTOReactiva;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface IhistorialPacienteReactivaRepository extends ReactiveMongoRepository<HistorialPacientesDTOReactivo, String> {
    Flux<HistorialPacientesDTOReactivo> findByIdPaciente(String idPaciente);
}

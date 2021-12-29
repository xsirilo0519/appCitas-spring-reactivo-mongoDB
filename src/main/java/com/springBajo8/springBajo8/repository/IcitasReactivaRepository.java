package com.springBajo8.springBajo8.repository;

//import com.yoandypv.reactivestack.messages.domain.Message;
import com.springBajo8.springBajo8.Utils.FiltradoFechayHora;
import com.springBajo8.springBajo8.domain.citasDTOReactiva;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.util.Date;

public interface IcitasReactivaRepository extends ReactiveMongoRepository<citasDTOReactiva, String> {
    Flux<citasDTOReactiva> findByIdPaciente(String idPaciente);
    Flux<citasDTOReactiva> findByFechaReservaCitaAndHoraReservaCita(LocalDate fecha, String hora);
}

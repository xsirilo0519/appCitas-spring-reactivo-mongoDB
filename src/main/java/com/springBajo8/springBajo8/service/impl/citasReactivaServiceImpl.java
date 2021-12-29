package com.springBajo8.springBajo8.service.impl;

//import com.yoandypv.reactivestack.messages.domain.Message;
//import com.yoandypv.reactivestack.messages.repository.MessageRepository;
//import com.yoandypv.reactivestack.messages.service.MessageService;
import com.springBajo8.springBajo8.Utils.FiltradoFechayHora;
import com.springBajo8.springBajo8.domain.citasDTOReactiva;
import com.springBajo8.springBajo8.repository.IcitasReactivaRepository;
import com.springBajo8.springBajo8.service.IcitasReactivaService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.Date;

@Service
public class citasReactivaServiceImpl implements IcitasReactivaService {

    @Autowired
    private IcitasReactivaRepository IcitasReactivaRepository;

    @Override
    public Mono<citasDTOReactiva> save(citasDTOReactiva citasDTOReactiva) {
        return this.IcitasReactivaRepository.save(citasDTOReactiva);
    }

    @Override
    public Mono<citasDTOReactiva> delete(String id) {
        return this.IcitasReactivaRepository
                .findById(id)
                .flatMap(p -> this.IcitasReactivaRepository.deleteById(p.getId()).thenReturn(p));

    }

    @Override
    public Mono<citasDTOReactiva> update(String id, citasDTOReactiva citasDTOReactiva) {
        return this.IcitasReactivaRepository.findById(id)
                .flatMap(citasDTOReactiva1 -> {
                    citasDTOReactiva.setId(id);
                    return save(citasDTOReactiva);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<citasDTOReactiva> findByIdPaciente(String idPaciente) {
        return this.IcitasReactivaRepository.findByIdPaciente(idPaciente);
    }


    @Override
    public Flux<citasDTOReactiva> findAll() {
        return this.IcitasReactivaRepository.findAll();
    }

    @Override
    public Mono<citasDTOReactiva> findById(String id) {
        return this.IcitasReactivaRepository.findById(id);
    }

    @Override
    public Flux<citasDTOReactiva> findByFechaReservaCitaAndHoraReservaCita(LocalDate fecha, String hora) {
        return this.IcitasReactivaRepository.findByFechaReservaCitaAndHoraReservaCita(fecha,hora);
    }

    @Override
    public Mono<citasDTOReactiva> canceleCita(String id) {
        return this.IcitasReactivaRepository.findById(id)
                .filter(cita->cita.getEstadoReservaCita().equals(true))
                .flatMap(citasDTOReactiva1 -> {
                    citasDTOReactiva1.setId(id);
                    citasDTOReactiva1.setEstadoReservaCita(false);
                    return save(citasDTOReactiva1);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public String findNombreMedico(String citaId){
        citasDTOReactiva cita =findById(citaId).block();
        return cita!=null?"Su medico es: "+cita.getNombreMedico()+" "+cita.getApellidosMedico():"No se encontró la cita";

    }


}

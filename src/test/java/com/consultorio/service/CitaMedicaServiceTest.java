package com.consultorio.service;

import com.consultorio.model.CitaMedica;
import com.consultorio.model.Paciente;
import com.consultorio.repository.CitaMedicaRepository;
import com.consultorio.repository.PacienteRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CitaMedicaServiceTest {

    @Test
    void noDebeRegistrarCitaSiPacienteNoExiste() {

        PacienteRepository pacienteRepository = mock(PacienteRepository.class);
        CitaMedicaRepository citaRepository = mock(CitaMedicaRepository.class);

        CitaMedicaService service = new CitaMedicaService(citaRepository, pacienteRepository);

        Paciente paciente = new Paciente();
        paciente.setId(1L);

        CitaMedica cita = new CitaMedica();
        cita.setFecha(LocalDate.now());
        cita.setHora(LocalTime.now());
        cita.setMotivo("Chequeo");
        cita.setPaciente(paciente);

        when(pacienteRepository.findById(1L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            service.registrarCita(cita);
        });

        assertEquals("El paciente no existe", exception.getMessage());
    }

    @Test
    void debeRegistrarCitaCorrectamente() {

        PacienteRepository pacienteRepository = mock(PacienteRepository.class);
        CitaMedicaRepository citaRepository = mock(CitaMedicaRepository.class);

        CitaMedicaService service = new CitaMedicaService(citaRepository, pacienteRepository);

        Paciente paciente = new Paciente();
        paciente.setId(1L);

        CitaMedica cita = new CitaMedica();
        cita.setFecha(LocalDate.now());
        cita.setHora(LocalTime.now());
        cita.setMotivo("Chequeo");
        cita.setPaciente(paciente);

        when(pacienteRepository.findById(1L)).thenReturn(Optional.of(paciente));
        when(citaRepository.save(cita)).thenReturn(cita);

        CitaMedica resultado = service.registrarCita(cita);

        assertNotNull(resultado);
    }
}
package com.consultorio.service;

import com.consultorio.model.Paciente;
import com.consultorio.repository.PacienteRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PacienteServiceTest {

    @Test
    void debeBuscarPacientePorId() {

        PacienteRepository repository = mock(PacienteRepository.class);
        PacienteService service = new PacienteService(repository);

        Paciente paciente = new Paciente();
        paciente.setId(1L);
        paciente.setNombre("Moxi");

        when(repository.findById(1L)).thenReturn(Optional.of(paciente));

        Optional<Paciente> resultado = service.buscarPorId(1L);

        assertTrue(resultado.isPresent());
        assertEquals("Moxi", resultado.get().getNombre());
    }
}
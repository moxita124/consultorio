package com.consultorio.service;

import com.consultorio.model.CitaMedica;
import com.consultorio.model.Paciente;
import com.consultorio.repository.CitaMedicaRepository;
import com.consultorio.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitaMedicaService {

    private final CitaMedicaRepository citaMedicaRepository;
    private final PacienteRepository pacienteRepository;

    public CitaMedicaService(CitaMedicaRepository citaMedicaRepository, PacienteRepository pacienteRepository) {
        this.citaMedicaRepository = citaMedicaRepository;
        this.pacienteRepository = pacienteRepository;
    }

    public List<CitaMedica> listarCitas() {
        return citaMedicaRepository.findAll();
    }

    public Optional<CitaMedica> buscarPorId(Long id) {
        return citaMedicaRepository.findById(id);
    }

    public CitaMedica registrarCita(CitaMedica citaMedica) {
        Long pacienteId = citaMedica.getPaciente().getId();

        Paciente paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new RuntimeException("El paciente no existe"));

        citaMedica.setPaciente(paciente);
        return citaMedicaRepository.save(citaMedica);
    }

    public Optional<CitaMedica> actualizarCita(Long id, CitaMedica datosCita) {
        return citaMedicaRepository.findById(id).map(cita -> {
            cita.setFecha(datosCita.getFecha());
            cita.setHora(datosCita.getHora());
            cita.setMotivo(datosCita.getMotivo());
            return citaMedicaRepository.save(cita);
        });
    }

    public boolean eliminarCita(Long id) {
        if (citaMedicaRepository.existsById(id)) {
            citaMedicaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
package com.consultorio.service;

import com.consultorio.model.Paciente;
import com.consultorio.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> buscarPorId(Long id) {
        return pacienteRepository.findById(id);
    }

    public Paciente registrarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Optional<Paciente> actualizarPaciente(Long id, Paciente datosPaciente) {
        return pacienteRepository.findById(id).map(paciente -> {
            paciente.setNombre(datosPaciente.getNombre());
            paciente.setApellido(datosPaciente.getApellido());
            paciente.setDni(datosPaciente.getDni());
            paciente.setTelefono(datosPaciente.getTelefono());
            return pacienteRepository.save(paciente);
        });
    }

    public boolean eliminarPaciente(Long id) {
        if (pacienteRepository.existsById(id)) {
            pacienteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
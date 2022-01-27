package com.example.testeyoux.service;

import com.example.testeyoux.helper.Helper;
import com.example.testeyoux.model.Paciente;
import com.example.testeyoux.repositorio.PacienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PacienteService {

    private final PacienteRepositorio pacienteRepositorio;
    private Helper helper;

    @Autowired
    public PacienteService (PacienteRepositorio pacienteRepositorio){
        this.pacienteRepositorio = pacienteRepositorio;
    }

    public List<Paciente> listarTodosPacientes() {

        return pacienteRepositorio.findAll();
    }

    public void adicionarPaciente(Paciente paciente){
        String cpfEncriptado = helper.criptografiaBase64Encoder(paciente.getCpf());
        validarCpfExistente(cpfEncriptado);
        paciente.setCpf(cpfEncriptado);
        pacienteRepositorio.save(paciente);
    }

    private void validarCpfExistente(String cpf) {
        Optional<Paciente> consultarCpfExistente = pacienteRepositorio.findPacienteByCpf(cpf);
        if (consultarCpfExistente.isPresent()) {
            throw new IllegalStateException("Esse cpf ja existe no banco de dados");
        }
    }
}

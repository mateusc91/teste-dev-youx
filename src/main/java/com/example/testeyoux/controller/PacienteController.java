package com.example.testeyoux.controller;

import com.example.testeyoux.model.Paciente;
import com.example.testeyoux.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/v1/paciente")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PacienteController {

    private final PacienteService pacienteService;

    @Autowired
    public PacienteController (PacienteService pacienteService){
        this.pacienteService = pacienteService;
    }

    @GetMapping("/listar")
    public List<Paciente> listarPacientes() {
        return pacienteService.listarTodosPacientes();
    }

    @PostMapping("/cadastrar")
    public void cadastrarNovoPaciente(@Valid @RequestBody Paciente paciente){
        pacienteService.adicionarPaciente(paciente);
    }



}

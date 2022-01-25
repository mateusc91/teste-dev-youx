package com.example.testeyoux.helper;

import com.example.testeyoux.model.Paciente;
import com.example.testeyoux.repositorio.PacienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Base64;
import java.util.Optional;

public class Helper {

    private final  PacienteRepositorio pacienteRepositorio;

    @Autowired
    public Helper(PacienteRepositorio pacienteRepositorio) {
        this.pacienteRepositorio = pacienteRepositorio;
    }

    public static String criptografiaBase64Encoder(String pValor) {
        return Base64.getEncoder().encodeToString(pValor.getBytes());
    }

}

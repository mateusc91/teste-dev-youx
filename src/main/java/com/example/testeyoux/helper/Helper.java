package com.example.testeyoux.helper;

import com.example.testeyoux.repositorio.PacienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

public class Helper {

    private final  PacienteRepositorio pacienteRepositorio;
    public final static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter
            .ofPattern("dd/MM/yyyy");

    @Autowired
    public Helper(PacienteRepositorio pacienteRepositorio) {
        this.pacienteRepositorio = pacienteRepositorio;
    }

    public static String criptografiaBase64Encoder(String pValor) {
        return Base64.getEncoder().encodeToString(pValor.getBytes());
    }

}

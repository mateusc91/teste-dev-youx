package com.example.testeyoux;

import com.example.testeyoux.model.Paciente;
import com.example.testeyoux.repositorio.PacienteRepositorio;
import com.example.testeyoux.repositorio.UsuarioRepositorio;
import com.example.testeyoux.service.PacienteService;
import com.example.testeyoux.service.UserDetailsImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
class TesteYouxApplicationTests {

    @Mock
    UsuarioRepositorio usuarioRepositorio;

    @Mock
    PacienteRepositorio pacienteRepositorio;

    @InjectMocks
    PacienteService pacienteService;

    @InjectMocks
    UserDetailsImpl userDetails;


    /**
     Outros testes seriam criado nesse mesmo padrao, por conta do tempo apenas criei um. O cenario ideal seria
     ter um teste para cada validacao feita dentro dos services.
     */


    @Nested
    @DisplayName("Com campus nulos")
    class ComChaveInformada {

        @Test
        @DisplayName("Deve lançar uma exception quando o paciente tiver campos nulos nulos")
        public void deveLancarExceptionSeFindByNomeNaoEncontrar() {
            Paciente paciente = new Paciente();

            assertThrows(NullPointerException.class,
                    () -> pacienteService.adicionarPaciente(paciente));

        }

    }

}

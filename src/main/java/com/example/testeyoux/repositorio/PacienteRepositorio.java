package com.example.testeyoux.repositorio;

//import com.example.testeyoux.model.Medico;
import com.example.testeyoux.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepositorio extends JpaRepository<Paciente, Long> {
    Optional<Paciente> findPacienteByCpf(String cpf);

}

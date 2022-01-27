package com.example.testeyoux;

import com.example.testeyoux.repositorio.PacienteRepositorio;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = PacienteRepositorio.class)
public class TesteYouxApplication {

    public static void main(String[] args) {
        SpringApplication.run(TesteYouxApplication.class, args);
    }

}

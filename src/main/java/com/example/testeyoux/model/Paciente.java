package com.example.testeyoux.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@Entity(name = "Paciente")
@Table(name="paciente")
public class Paciente {
    @Id
    @SequenceGenerator(
            name = "paciente_sequencia",
            sequenceName = "paciente_sequencia",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "paciente_sequencia"
    )
    @Column(name = "id",updatable = false)
    private Long id;

    //@Column(name = "nome",nullable = false)
    @NotBlank(message = "O campo NOME não pode ser nulo")
    private String nome;

    //@Column(name = "cpf",nullable = false)
    @NotBlank(message = "O campo CPF não pode ser nulo")
    private String cpf;

    LocalDate dob;

    private String peso;

    private String altura;

    //@Column(name = "uf",nullable = false)
    @NotBlank(message = "O campo UF não pode ser nulo")
    private String uf;

}

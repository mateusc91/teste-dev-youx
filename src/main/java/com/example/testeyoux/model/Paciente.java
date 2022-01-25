package com.example.testeyoux.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
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
    @NotNull
    private String nome;

    @Column(name = "cpf",nullable = false)
    @NotNull
    private String cpf;

    LocalDate dob;

    private String peso;

    private String altura;

    @Column(name = "uf",nullable = false)
    @NotNull
    private String uf;

}

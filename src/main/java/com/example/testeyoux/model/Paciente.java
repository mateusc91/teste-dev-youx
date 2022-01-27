package com.example.testeyoux.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Entity(name = "Paciente")
@Table(name="paciente",
        uniqueConstraints = { @UniqueConstraint(columnNames = "cpf")})
@AllArgsConstructor
@NoArgsConstructor
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

    @NotBlank(message = "O campo NOME não pode ser nulo")
    private String nome;

    @NotBlank(message = "O campo CPF não pode ser nulo")
    private String cpf;

    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate dob;

    private double peso;

    private double altura;

    @NotBlank(message = "O campo UF não pode ser nulo")
    @Size(max=2)
    private String uf;

    public Paciente(String nome, String cpf, LocalDate dob, double peso, double altura, String uf) {
        this.nome = nome;
        this.cpf = cpf;
        this.dob = dob;
        this.peso = peso;
        this.altura = altura;
        this.uf = uf;
    }
}

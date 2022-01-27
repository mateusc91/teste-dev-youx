package com.example.testeyoux.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(	name = "usuarios",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "nome"),
                @UniqueConstraint(columnNames = "cpf")
        })
public class UsuarioLogin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String nome;

    @NotBlank
    @Size(max = 11)
    @Email
    private String cpf;

    @NotBlank
    @Size(max = 120)
    private String senha;

    @NotBlank
    private String funcao;

    @NotBlank
    private String email;

    public UsuarioLogin(String nome, String cpf, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }
}

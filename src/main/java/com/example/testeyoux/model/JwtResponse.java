package com.example.testeyoux.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {
    private String jwt;
    private Long id;
    private String nome;
    private String cpf;
    private String funcao;
    private String email;

}

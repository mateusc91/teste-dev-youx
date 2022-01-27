package com.example.testeyoux.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginRequest {

    private String username;
    private String cpf;
    private String password;

}

package com.example.testeyoux.controller;

import com.example.testeyoux.helper.EFuncoes;
import com.example.testeyoux.model.JwtResponse;
import com.example.testeyoux.model.LoginRequest;
import com.example.testeyoux.repositorio.UsuarioRepositorio;
import com.example.testeyoux.security.jwt.JwtUtils;
import com.example.testeyoux.service.UserDetailsImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    private final String MEDICO = "medico";

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        if(!userDetails.getFuncao().equals(EFuncoes.MEDICO.getDescricao())){
            log.error(("Usuario nao é um medico, somente medicos podem logar no gerenciamento"));
            return ResponseEntity.badRequest()
                    .body("Usuario nao é um medico");

        } else {
            return ResponseEntity.ok(new JwtResponse(jwt,
                    userDetails.getId(),
                    userDetails.getUsername(),
                    userDetails.getCpf(),
                    userDetails.getFuncao(),
                    userDetails.getEmail()));
        }

    }
}

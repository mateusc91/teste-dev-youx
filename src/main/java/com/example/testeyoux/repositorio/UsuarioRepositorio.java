package com.example.testeyoux.repositorio;

import java.util.Optional;

import com.example.testeyoux.model.UsuarioLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<UsuarioLogin, Long> {
    Optional<UsuarioLogin> findByNome(String username);

    Optional<UsuarioLogin> findByFuncao(String funcao);

    Boolean existsByNome(String username);

    Boolean existsByCpf (String cpf);

}

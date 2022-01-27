package com.example.testeyoux.service;

import com.example.testeyoux.model.UsuarioLogin;
import com.example.testeyoux.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioLogin usuarioLogin = usuarioRepositorio.findByNome(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario nao encontrado: " + username));

        return UserDetailsImpl.build(usuarioLogin);
    }

}

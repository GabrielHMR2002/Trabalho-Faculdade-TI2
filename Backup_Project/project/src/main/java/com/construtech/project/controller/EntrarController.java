package com.construtech.project.controller;

import com.construtech.project.models.Entrar;
import com.construtech.project.services.EntrarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/autenticacao")
public class EntrarController {

    private final EntrarService entrarService;

    @Autowired
    public EntrarController(EntrarService entrarService) {
        this.entrarService = entrarService;
    }

    @PostMapping("/login")
    public ResponseEntity<Entrar> autenticarUsuario(@RequestBody Entrar entrar) {
        Entrar usuarioAutenticado = entrarService.autenticarUsuario(entrar.getEmail(), entrar.getSenha());

        if (usuarioAutenticado != null) {
            return ResponseEntity.ok(usuarioAutenticado);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}

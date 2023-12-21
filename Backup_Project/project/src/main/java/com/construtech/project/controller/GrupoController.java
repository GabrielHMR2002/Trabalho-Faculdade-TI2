package com.construtech.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.construtech.project.models.Grupo;
import com.construtech.project.services.GrupoService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/grupos")
public class GrupoController {

    private final GrupoService grupoService;

    @Autowired
    public GrupoController(GrupoService grupoService) {
        this.grupoService = grupoService;
    }

    @GetMapping
    public List<Grupo> listarGrupos() {
        return grupoService.listarGrupos();
    }

    @GetMapping("/{id}")
    public Optional<Grupo> buscarPorId(@PathVariable Long id) {
        return grupoService.buscarPorId(id);
    }

    @PostMapping
    public Grupo criarGrupo(@RequestBody Grupo grupo) {
        return grupoService.salvarGrupo(grupo);
    }

    @DeleteMapping("/{id}")
    public void excluirGrupo(@PathVariable Long id) {
        grupoService.excluirGrupo(id);
    }
}

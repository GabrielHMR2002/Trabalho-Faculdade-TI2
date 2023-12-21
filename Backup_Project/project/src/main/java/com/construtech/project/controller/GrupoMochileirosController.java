// GrupoMochileirosController.java

package com.construtech.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.construtech.project.models.GrupoMochileiros;
import com.construtech.project.services.GrupoMochileirosService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/grupos-mochileiros")
public class GrupoMochileirosController {

    private final GrupoMochileirosService grupoService;

    @Autowired
    public GrupoMochileirosController(GrupoMochileirosService grupoService) {
        this.grupoService = grupoService;
    }

    @GetMapping
    public List<GrupoMochileiros> getAllGrupos() {
        return grupoService.getAllGrupos();
    }

    @GetMapping("/{id}")
    public GrupoMochileiros getGrupoById(@PathVariable Long id) {
        return grupoService.getGrupoById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar o grupo com ID: " + id));
    }

    @PostMapping
    public GrupoMochileiros createGrupo(@RequestBody GrupoMochileiros grupo) {
        return grupoService.saveGrupo(grupo);
    }

    // Endpoint para adicionar participante ao grupo
    @PostMapping("/{grupoId}/adicionar-participante")
    public GrupoMochileiros adicionarParticipante(@PathVariable Long grupoId, @RequestBody String nomeUsuario) {
        return grupoService.adicionarParticipante(grupoId, nomeUsuario);
    }
    // Outros métodos conforme necessário
}

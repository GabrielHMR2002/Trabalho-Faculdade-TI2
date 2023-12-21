package com.construtech.project.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.construtech.project.models.Denuncia;
import com.construtech.project.services.DenunciaService; // Adicionado a importação

@RestController
@RequestMapping("/denuncia")
@Validated
@CrossOrigin("*")
public class DenunciaController {
    
    @Autowired
    private DenunciaService denunciaService;

    @GetMapping("/{id}")
    public ResponseEntity<Denuncia> findById(@PathVariable Long id){
        Denuncia obj = this.denunciaService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    
    @PostMapping
    public ResponseEntity<Void> criarDenuncia(@RequestBody Denuncia obj){
        this.denunciaService.criarDenuncia(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).build();    
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody Denuncia obj, @PathVariable Long id){
        obj.setId(id);
        this.denunciaService.atualizarDenuncia(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.denunciaService.deletarDenuncia(id);
        return ResponseEntity.noContent().build();
    }
}

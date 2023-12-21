package com.construtech.project.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.construtech.project.models.Grupo;
import com.construtech.project.repositories.GrupoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GrupoService {

    private final GrupoRepository grupoRepository;

    @Autowired
    public GrupoService(GrupoRepository grupoRepository) {
        this.grupoRepository = grupoRepository;
    }

    // Operações básicas CRUD

    public List<Grupo> listarGrupos() {
        return grupoRepository.findAll();
    }

    public Optional<Grupo> buscarPorId(Long id) {
        return grupoRepository.findById(id);
    }

    public Grupo salvarGrupo(Grupo grupo) {
        return grupoRepository.save(grupo);
    }

    public void excluirGrupo(Long id) {
        grupoRepository.deleteById(id);
    }

    
}
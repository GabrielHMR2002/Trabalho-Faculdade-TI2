// GrupoMochileirosService.java
package com.construtech.project.services;

import org.springframework.stereotype.Service;

import com.construtech.project.models.GrupoMochileiros;
import com.construtech.project.repositories.GrupoMochileirosRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GrupoMochileirosService {

    private final GrupoMochileirosRepository grupoRepository;

    public GrupoMochileirosService(GrupoMochileirosRepository grupoRepository) {
        this.grupoRepository = grupoRepository;
    }

    public List<GrupoMochileiros> getAllGrupos() {
        return grupoRepository.findAll();
    }

    public Optional<GrupoMochileiros> getGrupoById(Long id) {
        return grupoRepository.findById(id);
    }

    public GrupoMochileiros saveGrupo(GrupoMochileiros grupo) {
        // Adicione verificações adicionais, se necessário, antes de salvar o grupo
        // Exemplo: Validar campos obrigatórios, lógica de negócios, etc.
        return grupoRepository.save(grupo);
    }

    public GrupoMochileiros adicionarParticipante(Long grupoId, String nomeUsuario) {
        Optional<GrupoMochileiros> optionalGrupo = grupoRepository.findById(grupoId);
        if (optionalGrupo.isPresent()) {
            GrupoMochileiros grupo = optionalGrupo.get();
            
            // Adicione verificações adicionais, se necessário, antes de adicionar o participante
            // Exemplo: Verificar se o participante já está no grupo, limites de participantes, etc.
            
            grupo.adicionarParticipante(nomeUsuario);
            
            return grupoRepository.save(grupo);
        } else {
            throw new RuntimeException("Não foi possível encontrar o grupo com ID: " + grupoId);
        }
    }
    // Outros métodos conforme necessário
}



package com.construtech.project.services;

import com.construtech.project.models.Avaliacao;
import com.construtech.project.repositories.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {

    private final AvaliacaoRepository avaliacaoRepository;

    @Autowired
    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public List<Avaliacao> listarAvaliacoes() {
        return avaliacaoRepository.findAll();
    }

    public Avaliacao buscarAvaliacaoPorCpf(String cpf) {
        return avaliacaoRepository.findById(cpf).orElse(null);
    }

    public Avaliacao criarAvaliacao(Avaliacao avaliacao) {
        return avaliacaoRepository.save(avaliacao);
    }

    public void excluirAvaliacao(String cpf) {
        avaliacaoRepository.deleteById(cpf);
    }
}

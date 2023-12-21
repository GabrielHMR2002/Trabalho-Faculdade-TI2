package com.construtech.project.services;

import com.construtech.project.models.Cadastro;
import com.construtech.project.repositories.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroService {
    private final CadastroRepository cadastroRepository;

    @Autowired
    public CadastroService(CadastroRepository cadastroRepository) {
        this.cadastroRepository = cadastroRepository;
    }

    public List<Cadastro> listarTodosCadastros() {
        return cadastroRepository.findAll();
    }

    public Optional<Cadastro> encontrarCadastroPorId(Long id) {
        return cadastroRepository.findById(id);
    }

    public Cadastro salvarCadastro(Cadastro cadastro) {
        return cadastroRepository.save(cadastro);
    }

    public void excluirCadastro(Long id) {
        cadastroRepository.deleteById(id);
    }
    public long countCadastros() {
        return cadastroRepository.count();
    }
    
}

package com.construtech.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.construtech.project.models.CadastroFornecedor;
import com.construtech.project.repositories.CadastroFornecedorRepository;

@Service
public class CadastroFornecedorService {

    private final CadastroFornecedorRepository cadastroFornecedorRepository;

    @Autowired
    public CadastroFornecedorService(CadastroFornecedorRepository cadastroFornecedorRepository) {
        this.cadastroFornecedorRepository = cadastroFornecedorRepository;
    }

 

    public List<CadastroFornecedor> listarTodosCadastroFornecedores() {
        return cadastroFornecedorRepository.findAll();
    }

    public CadastroFornecedor salvarCadastroFornecedor(CadastroFornecedor cadastroFornecedor) {
        return cadastroFornecedorRepository.save(cadastroFornecedor);
    }

    public CadastroFornecedor encontrarCadastroFornecedorPorId(Long id) {
        return cadastroFornecedorRepository.findById(id).orElse(null);
    }

    public void deletarCadastroFornecedor(Long id) {
        cadastroFornecedorRepository.deleteById(id);
    }

  

}

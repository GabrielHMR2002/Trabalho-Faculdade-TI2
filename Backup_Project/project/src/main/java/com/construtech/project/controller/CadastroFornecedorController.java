package com.construtech.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.construtech.project.models.CadastroFornecedor;
import com.construtech.project.services.CadastroFornecedorService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/cadastrofornecedor")
public class CadastroFornecedorController {

    private final CadastroFornecedorService cadastroFornecedorService;

    @Autowired
    public CadastroFornecedorController(CadastroFornecedorService cadastroFornecedorService) {
        this.cadastroFornecedorService = cadastroFornecedorService;
    }

    @GetMapping("/listar")
    public List<CadastroFornecedor> listarTodosCadastroFornecedores() {
        return cadastroFornecedorService.listarTodosCadastroFornecedores();
    }

    @GetMapping("/{id}")
    public CadastroFornecedor encontrarCadastroFornecedorPorId(@PathVariable Long id) {
        return cadastroFornecedorService.encontrarCadastroFornecedorPorId(id);
    }

  /*   @PostMapping("/salvar")
    public CadastroFornecedor salvarCadastroFornecedor(@RequestBody CadastroFornecedor cadastroFornecedor) {
        return cadastroFornecedorService.salvarCadastroFornecedor(cadastroFornecedor);
    }
*/
@PostMapping("/salvar")
public ResponseEntity<CadastroFornecedor> salvarCadastroFornecedor(@RequestBody CadastroFornecedor cadastroFornecedor) {
    CadastroFornecedor novoCadastroFornecedor = cadastroFornecedorService.salvarCadastroFornecedor(cadastroFornecedor);
    return ResponseEntity.status(HttpStatus.CREATED).body(novoCadastroFornecedor);
}
    @DeleteMapping("/{id}")
    public void deletarCadastroFornecedor(@PathVariable Long id) {
        cadastroFornecedorService.deletarCadastroFornecedor(id);
    }
}

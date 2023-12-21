package com.construtech.project.controller;

import com.construtech.project.models.Cadastro;
import com.construtech.project.services.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/cadastros")
public class CadastroController {

    private final CadastroService cadastroService;

    @Autowired
    public CadastroController(CadastroService cadastroService) {
        this.cadastroService = cadastroService;
    }

    @GetMapping
    public List<Cadastro> listarCadastros() {
        return cadastroService.listarTodosCadastros();
    }

    @GetMapping("/{id}")
    public Optional<Cadastro> encontrarCadastroPorId(@PathVariable Long id) {
        return cadastroService.encontrarCadastroPorId(id);
    }

    
      @PostMapping
      public Cadastro criarCadastro(@RequestBody Cadastro cadastro) {
      return cadastroService.salvarCadastro(cadastro);
      }
     

     /* 
    @PostMapping
    public ResponseEntity<Cadastro> criarCadastro(@RequestBody Cadastro cadastro) {
        Cadastro novoCadastro = cadastroService.salvarCadastro(cadastro);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCadastro);
    }*/

    @PutMapping("/{id}")
    public Cadastro atualizarCadastro(@PathVariable Long id, @RequestBody Cadastro cadastro) {
        if (cadastroService.encontrarCadastroPorId(id).isPresent()) {
            cadastro.setId(id);
            return cadastroService.salvarCadastro(cadastro);
        } else {
            throw new RuntimeException("Cadastro não encontrado com ID: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public void excluirCadastro(@PathVariable Long id) {
        cadastroService.excluirCadastro(id);
    }

    @GetMapping("/count")
    public long countCadastros() {
        return cadastroService.countCadastros();
    }

}

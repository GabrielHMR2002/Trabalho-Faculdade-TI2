package com.construtech.project.controller;

import com.construtech.project.models.Cadastro;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


import org.springframework.test.context.junit4.SpringRunner; 

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CadastroControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCadastroBemSucedido() {
 
        Cadastro novoCadastro = new Cadastro("gabrielTestandoMetodo", "123456789", "Nome do Usuário", "Estado", "Senha");


        ResponseEntity<Cadastro> response = restTemplate.postForEntity("/cadastros", novoCadastro, Cadastro.class);

  
        assertEquals(201, response.getStatusCodeValue());

      
        ResponseEntity<Cadastro> cadastroResponse = restTemplate.getForEntity("/cadastros/" + response.getBody().getId(), Cadastro.class);

  
        //para veririfar se o cadastro foi criado certo
        assertEquals(novoCadastro.getEmail(), cadastroResponse.getBody().getEmail());
        assertEquals(novoCadastro.getCpf(), cadastroResponse.getBody().getCpf());
        assertEquals(novoCadastro.getNome(), cadastroResponse.getBody().getNome());
        assertEquals(novoCadastro.getEstado(), cadastroResponse.getBody().getEstado());
        assertEquals(novoCadastro.getSenha(), cadastroResponse.getBody().getSenha());
    }
}

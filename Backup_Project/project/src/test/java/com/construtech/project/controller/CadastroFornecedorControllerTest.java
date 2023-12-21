package com.construtech.project.controller;

import com.construtech.project.models.CadastroFornecedor;
import com.construtech.project.services.CadastroFornecedorService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CadastroFornecedorControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testSalvarCadastroFornecedor() {

        CadastroFornecedor novoCadastroFornecedor = new CadastroFornecedor(
            "Nome do Evento", "Descrição do Evento", "Data do Evento", "Hora do Evento",
            "Local do Evento", "Tipo do Evento", "Nome da Empresa", "Contato",
            "email@example.com", "Local da Empresa", "Serviço Oferecido", null, null
        );

   
        ResponseEntity<CadastroFornecedor> response = restTemplate.postForEntity("/cadastrofornecedor/salvar", novoCadastroFornecedor, CadastroFornecedor.class);

      
        assertEquals(201, response.getStatusCodeValue());

      
        ResponseEntity<CadastroFornecedor> cadastroResponse = restTemplate.getForEntity("/cadastrofornecedor/" + response.getBody().getId(), CadastroFornecedor.class);

        // Verifique se o cadastro foi criado corretamente
        assertNotNull(cadastroResponse.getBody());
        assertEquals(novoCadastroFornecedor.getNomeEvento(), cadastroResponse.getBody().getNomeEvento());
        assertEquals(novoCadastroFornecedor.getDescricaoEvento(), cadastroResponse.getBody().getDescricaoEvento());
    
    }
}

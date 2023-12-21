package com.construtech.project.services;

import com.construtech.project.models.Entrar;
import com.construtech.project.repositories.EntrarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;



@Service
public class EntrarService {
    private final EntrarRepository entrarRepository;

    @Autowired
    public EntrarService(EntrarRepository entrarRepository) {
        this.entrarRepository = entrarRepository;
    }

    public Entrar autenticarUsuario(String email, String senha) {
        Entrar usuario = entrarRepository.findByEmail(email);

        if (usuario != null && verificarSenha(senha, usuario.getSenha(), usuario.getSalt())) {
            return usuario;
        }

        return null;
    }

    private boolean verificarSenha(String senhaDigitada, String senhaArmazenada, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt.getBytes());
            byte[] hashedPassword = md.digest(senhaDigitada.getBytes());

            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : hashedPassword) {
                stringBuilder.append(String.format("%02x", b));
            }

            String senhaHash = stringBuilder.toString();

            return senhaHash.equals(senhaArmazenada);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }
}

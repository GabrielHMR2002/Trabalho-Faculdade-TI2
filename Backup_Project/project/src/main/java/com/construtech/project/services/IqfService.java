package com.construtech.project.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.construtech.project.repositories.Iqf;
import com.construtech.project.repositories.IqfRepository;

@Service
public class IqfService {

    @Autowired
    private IqfRepository iqfRepository;
    
    public Optional<Iqf> findById(Long id) {
        return iqfRepository.findById(id);
    }

    public Iterable<Iqf> findAll() {
        return iqfRepository.findAll();
    }

    public void saveIqf(Iqf iqf) {
        iqfRepository.save(iqf);
    }

    public void deleteById(Long id) {
        iqfRepository.deleteById(id);
    }

    // Outros métodos relacionados ao serviço podem ser adicionados aqui

    // Novo método para buscar por CNPJ
    public Optional<Iqf> findByCnpj(String cnpj) {
        return Optional.ofNullable(iqfRepository.findByCnpj(cnpj));
    }
}

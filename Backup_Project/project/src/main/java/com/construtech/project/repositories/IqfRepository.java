package com.construtech.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IqfRepository extends JpaRepository<Iqf, Long> {
    
    // Método personalizado para buscar por CNPJ
    Iqf findByCnpj(String cnpj);

}

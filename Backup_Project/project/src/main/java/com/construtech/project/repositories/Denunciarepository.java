package com.construtech.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.construtech.project.models.Denuncia;

@Repository
public interface Denunciarepository extends JpaRepository<Denuncia, Long> {
    
}

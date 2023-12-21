package com.construtech.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.construtech.project.models.Grupo;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long> {
 
}

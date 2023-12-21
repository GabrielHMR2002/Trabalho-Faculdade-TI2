package com.construtech.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.construtech.project.models.Entrar;

@Repository
public interface EntrarRepository extends JpaRepository<Entrar, Long> {
    Entrar findByEmail(String email);
}

package com.construtech.project.repositories;

import com.construtech.project.models.GrupoMochileiros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoMochileirosRepository extends JpaRepository<GrupoMochileiros, Long> {

}

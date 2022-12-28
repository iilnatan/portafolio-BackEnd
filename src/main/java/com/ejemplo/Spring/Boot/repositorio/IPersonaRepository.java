package com.ejemplo.Spring.Boot.repositorio;

import com.ejemplo.Spring.Boot.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author marco
 */
@Repository
public interface IPersonaRepository extends JpaRepository<Persona,Long> {
    
}
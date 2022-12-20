package com.ejemplo.Spring.Boot.repositorio;

import com.ejemplo.Spring.Boot.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author marco
 */
@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{
    public void deleteAllById(Long id);
    public Object findAllById(Long id);
    
}

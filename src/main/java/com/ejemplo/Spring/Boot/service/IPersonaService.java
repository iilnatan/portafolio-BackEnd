package com.ejemplo.Spring.Boot.service;

import com.ejemplo.Spring.Boot.model.Persona;
import java.util.List;

/**
 *
 * @author marco
 */
public interface IPersonaService {
    public List<Persona> verPersonas ();
    public void crearPersona (Persona per);
    public void borrarPersona (Long id);
    public Persona buscarPersona(Long id);
}

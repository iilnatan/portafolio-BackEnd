package com.ejemplo.Spring.Boot.service;

import com.ejemplo.Spring.Boot.model.Persona;
import java.util.List;

/**
 *
 * @author marco
 */
public interface IPersonaService {
    //Traer una lista de personas
    public List<Persona> getPersona();
    
    //Guardar un objeto de tipo Persona
    public void savePersona(Persona persona);
    
    //Eliminar un objeto pero lo buscamos por ID
    public void deletePersona(Long id);
    
    //Buscar una persona por ID
    public Persona findPersona(Long id);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.Spring.Boot.Controller;

import com.ejemplo.Spring.Boot.model.Persona;
import com.ejemplo.Spring.Boot.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author marco
 */
@CrossOrigin(origins="http://localhost:4200",maxAge=3600)

@RestController
public class Controller {
    
    @Autowired
    private IPersonaService persoServ;
    
    @PostMapping ("/personas/new")
    public void agregarPersona (@RequestBody Persona pers){
        persoServ.crearPersona(pers);
    }
    @GetMapping ("/personas/ver")
    @ResponseBody
    public List<Persona> verPersonas(){
            return persoServ.verPersonas();
    }
    @DeleteMapping ("/personas/delete/{id}")
    public void borrarPersona (@PathVariable Long id){
        persoServ.borrarPersona(id);
    }
    @PutMapping ("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("apellido") String nuevoApellido,
                               @RequestParam("img") String nuevoImg){
        Persona persona = persoServ.buscarPersona(id);
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);
        persoServ.crearPersona(persona);
        return persona;
    }
    @GetMapping("/personas/traer/perfil")
    public Persona buscarPersona(){
        return persoServ.buscarPersona((long)3);
    }
}

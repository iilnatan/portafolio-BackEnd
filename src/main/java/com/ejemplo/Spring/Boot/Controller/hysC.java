package com.ejemplo.Spring.Boot.Controller;

import com.ejemplo.Spring.Boot.Dto.hysDto;
import com.ejemplo.Spring.Boot.Security.Controller.Mensaje;
import com.ejemplo.Spring.Boot.model.hys;
import com.ejemplo.Spring.Boot.service.hysS;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author marco
 */
@RestController
@CrossOrigin(origins = {"https://natanbuffaport.web.app","http://localhost:4200"})
@RequestMapping("/hys")
public class hysC {
    @Autowired

    hysS hyss;

    @GetMapping("/lista")
    public ResponseEntity<List<hys>> list(){
        List<hys> list = hyss.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<hys> getById(@PathVariable("id") int id){
        if(!hyss.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        hys hYs = hyss.getOne(id).get();
        return new ResponseEntity(hYs, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!hyss.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        hyss.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody hysDto hysdto){      
        if(StringUtils.isBlank(hysdto.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(hyss.existsByNombre(hysdto.getNombre()))
            return new ResponseEntity(new Mensaje("Esa skill existe"), HttpStatus.BAD_REQUEST);

        hys hYs= new hys(hysdto.getNombre(), hysdto.getPorcentaje());
        hyss.save(hYs);

        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody hysDto hysdto){
        //Validamos is
        if(!hyss.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(hyss.existsByNombre(hysdto.getNombre()) && hyss.getByNombre(hysdto.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(hysdto.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        hys hYs = hyss.getOne(id).get();
        hYs.setNombre(hysdto.getNombre());
        hYs.setPorcentaje((hysdto.getPorcentaje()));

        hyss.save(hYs);
        return new ResponseEntity(new Mensaje("actualizado :)"), HttpStatus.OK);

    }
}
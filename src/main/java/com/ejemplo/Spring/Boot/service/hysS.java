/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.Spring.Boot.service;

import com.ejemplo.Spring.Boot.model.hys;
import com.ejemplo.Spring.Boot.repositorio.hysR;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author marco
 */
@Transactional
@Service
public class hysS {
    @Autowired

    hysR hysr;

    public List<hys> list(){
        return hysr.findAll();
    }

    public Optional<hys> getOne(int id){
        return hysr.findById(id);
    }

    public Optional<hys> getByNombre(String nombre){
        return hysr.findByNombre(nombre);
    }

    public void save(hys skill){
        hysr.save(skill);
    }

    public void delete(int id){
        hysr.deleteById(id);
    }

    public boolean existsById(int id){
        return hysr.existsById(id);
    }

    public boolean existsByNombre(String nombre){
        return hysr.existsByNombre(nombre);
    }
}

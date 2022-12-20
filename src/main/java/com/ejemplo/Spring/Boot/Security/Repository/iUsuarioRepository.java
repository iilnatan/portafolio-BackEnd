    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.Spring.Boot.Security.Repository;

import com.ejemplo.Spring.Boot.Security.Entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author marco
 */
@Repository
public interface iUsuarioRepository extends JpaRepository<?, Integer>{
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
   
    boolean existByNombreUsuario(String nombreUsuario);
    boolean existByEmail(String email);
}

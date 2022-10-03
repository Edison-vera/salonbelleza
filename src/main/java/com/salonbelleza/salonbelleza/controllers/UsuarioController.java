package com.salonbelleza.salonbelleza.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.salonbelleza.salonbelleza.models.UsuarioModel;
import com.salonbelleza.salonbelleza.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    //Obtener Usuarios
    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }
    
    //Crear usuarios
    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }

    //Obtener usuarios por id
    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Integer id){
        return this.usuarioService.obtenerPorId(id);
    }
    //Obtener usuario por email
    @GetMapping("/email")
    public ArrayList <UsuarioModel> obtenerUsuarioPorEmail(@RequestParam("email") String email){
        return this.usuarioService.obtenerPorEmail(email);
    }

    //Eliminar usuario por id
    @DeleteMapping (path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Integer id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if(ok){
            return "Se elimino el usuario con id: " + id;
        }else{
            return "No se pudo eliminar el usuario con id: " + id;
        }
    }
}

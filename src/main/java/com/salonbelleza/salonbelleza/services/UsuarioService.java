package com.salonbelleza.salonbelleza.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salonbelleza.salonbelleza.models.UsuarioModel;
import com.salonbelleza.salonbelleza.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    //Obtener usuarios 
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return(ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }
    
    //Guardar usuario
    public UsuarioModel guardarUsuario(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    //Obtener usuarios por id
    public Optional <UsuarioModel> obtenerPorId(Integer id){
        return usuarioRepository.findById(id);
    }

    //Obtener usuarios por correo
    public ArrayList<UsuarioModel> obtenerPorEmail(String email){
        return usuarioRepository.findByEmail(email);
    }

    //Eliminar usuario por id
    public boolean eliminarUsuario(Integer id){
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}

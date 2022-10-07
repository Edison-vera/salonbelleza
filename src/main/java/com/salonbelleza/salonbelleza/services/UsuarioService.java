package com.salonbelleza.salonbelleza.services;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.salonbelleza.salonbelleza.models.UsuarioModel;
import com.salonbelleza.salonbelleza.repositories.UsuarioRepository;

@Service
@Primary
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    // Obtener usuarios
    public ArrayList<UsuarioModel> obtenerUsuarios() {
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    // Guardar usuario
    public String guardarUsuario(UsuarioModel usuario) {
        String message = "";
        try {
            if (usuarioRepository.existsByEmail(usuario.getEmail())) {
                throw new Exception("Email ya se encuentra registrado");
            }
            // Recuperamos el password en texto plano
            String pwdPlano = usuario.getPassword();
            // Encriptamos el pwd BCryptPasswordEncoder
            String pwdEncriptado = passwordEncoder.encode(pwdPlano);
            // Hacemos un set al atributo password (ya viene encriptado)
            usuario.setPassword(pwdEncriptado);
            usuarioRepository.save(usuario);
            message = "Usuario creado con exito";
        } catch (Exception e) {
            message = e.getMessage();
        }
        return message;
    }

    // Obtener usuarios por id
    public Optional<UsuarioModel> obtenerPorId(Integer id) {
        return usuarioRepository.findById(id);
    }

    // Obtener usuarios por correo
    public ArrayList<UsuarioModel> obtenerPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    // Eliminar usuario por id
    public boolean eliminarUsuario(Integer id) {
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}

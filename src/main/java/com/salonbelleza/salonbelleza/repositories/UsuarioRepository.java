package com.salonbelleza.salonbelleza.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.salonbelleza.salonbelleza.models.UsuarioModel;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Integer> {
    public abstract ArrayList<UsuarioModel> findByEmail(String email);
    Boolean existsByEmail(String email);
    
}

package com.salonbelleza.salonbelleza.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "usuarios")
public class UsuarioModel {

    // Atributos
    @Id
    private int id;
    @NotBlank(message = "Primer Nombre es requerido")
    private String primer_nombre;
    /// @NotBlank(message = "Segundo Nombre es requerido")
    private String segundo_nombre;
    @NotBlank(message = "Primer Apellido es requerido")
    private String primer_apellido;
    /// @NotBlank(message = "Segundo Apellido es requerido")
    private String segundo_apellido;
    
    @NotEmpty(message = "Email invalido")
    @Email
    private String email;
    @NotBlank(message = "Password requerida")
    private String password;
    @NotBlank(message = "Numero de contacto es requerido")
    private String celular;
    private int admin;
    private int confirmado;
    private String token;

    public UsuarioModel() {
    }

    public UsuarioModel(int id, String primer_nombre, String segundo_nombre, String primer_apellido,
            String segundo_apellido, String email, String password, String celular, int admin, int confirmado,
            String token) {
        this.id = id;
        this.primer_nombre = primer_nombre;
        this.segundo_nombre = segundo_nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.email = email;
        this.password = password;
        this.celular = celular;
        this.admin = admin;
        this.confirmado = confirmado;
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrimer_nombre() {
        return primer_nombre;
    }

    public void setPrimer_nombre(String primer_nombre) {
        this.primer_nombre = primer_nombre;
    }

    public String getSegundo_nombre() {
        return segundo_nombre;
    }

    public void setSegundo_nombre(String segundo_nombre) {
        this.segundo_nombre = segundo_nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public int getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(int confirmado) {
        this.confirmado = confirmado;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}

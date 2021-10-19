/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.proyectoplantillas.dato;

import com.mycompany.pruebawebwar.service.EstudianteService;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.*;

/**
 * 
 *
 * @author ASUS
 */
public class Usuario implements Serializable {

    @NotNull(message = "Error con el id")
    @Size(min = 1, max = 3, message = "Ingrese valores de entre 1 y 3 caracteres")
    private String id;
    @NotNull(message = "Es necesario ingresar un nombre")
    @Size(min = 3, max = 10, message = "Ingrese valores de entre 3 y 10 caracteres")
    private String nombre;
    @Size(min = 3, max = 10, message = "Ingrese valores de entre 3 y 10 caracteres")
    private String nombreSecundario;
    @NotNull(message = "Es necesario ingresar un apellido")
    @Size(min = 3, max = 10, message = "Ingrese valores de entre 3 y 10 caracteres")
    private String apellido;
    @NotNull(message = "Es necesario ingresar la cedula")
    @Size(min = 5, max = 10, message = "Ingrese valores de entre 5 y 10 caracteres")
    private String cedula;
    @NotNull(message = "Es necesario ingresar una contraseña")
    @Size(min = 6, max = 10, message = "Ingrese valores de entre 6 y 10 caracteres")
    private String contrasena;

    /*@NotNull(message = "Es necesario ingresar un correo")
    @Pattern(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$",
            message = "Es necesario que el correo contenga el siguiente formato xxxx@correo.xxx")
    private String correo;
    @Size(min = 9, max = 10)
    private String celular;
    @NotNull(message = "Es necesario ingresar la fecha de nacimiento para verificar tu edad")
    @Past(message = "La fecha debe ser una fecha valida")
    private Date fechaDeNacimiento;*/

    public Usuario() {
    }

    public Usuario(String id, String nombre, String nombreSecundario, String apellido, String cedula, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.nombreSecundario = nombreSecundario;
        this.apellido = apellido;
        this.cedula = cedula;
        this.contrasena = contrasena;
        //this.fechaDeNacimiento = fechaDeNacimiento;
    }

    /**
     * @return the nombre
     */
    public String getId() {
        return id;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the nombreSecundario
     */
    public String getNombreSecundario() {
        return nombreSecundario;
    }

    /**
     * @param nombreSecundario the nombre to set
     */
    public void setNombreSecundario(String nombreSecundario) {
        this.nombreSecundario = nombreSecundario;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the contraseña
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * @param contrasena the contraseña to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    
    /**
     * Metodo que envia la intancia para validar si tiene alguna violación
     *
     * @return
     *
     * */
    public Set<ConstraintViolation<Usuario>> validar() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        return validator.validate(this);
    }
}

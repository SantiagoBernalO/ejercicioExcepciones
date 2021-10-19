/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pruebawebwar.service;

import com.unicundi.proyectoplantillas.dato.Usuario;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashMap;
import javax.validation.ConstraintViolation;

/**
 *
 * @author ASUS
 */
public class EstudianteService {

    /**
     *
     * @throws ArrayIndexOutOfBoundsException, BussinessException
     */
    public void mostrar(ArrayList<Usuario> LUsuario) {

        try {
            if (LUsuario.isEmpty()) {
                throw new EmptyStackException();//204 NO CONTENT
            }

        } catch (EmptyStackException ex) {
            throw ex;
        }
    }

    /**
     *
     * @throws ArrayIndexOutOfBoundsException, BussinessException
     */
    public void insertar(ArrayList<Usuario> LUsuario, Usuario estudiante) {
        Boolean existencia = true;

        try {

            HashMap<String, String> errores = new HashMap();

            for (ConstraintViolation error : estudiante.validar()) {
                errores.put(error.getPropertyPath().toString(), error.getMessage());
            }

            if (errores.size() > 0) {
                throw new IllegalArgumentException(errores.toString());//400

            } else {
                if (LUsuario.isEmpty()) {
                    existencia = false;
                } else {
                    for (Usuario LU : LUsuario) {
                        if (LU.getCedula().equals(estudiante.getCedula())) {
                            existencia = true;
                        } else {
                            existencia = false;
                        }
                    }
                }

                if (existencia == true) {
                    throw new RuntimeException("Esta cedula ya existe");//409 CONFLICT
                } else if (existencia == false) {
                    LUsuario.add(estudiante);
                }
            }

        } catch (IllegalArgumentException ex) {
            throw ex;
        }
    }

    /**
     *
     * @throws ArrayIndexOutOfBoundsException, BussinessException
     */
    public Usuario obtenerPorId(ArrayList<Usuario> LUsuario, String id) {

        Usuario U = new Usuario();
        try {
            for (Usuario LU : LUsuario) {
                if (LU.getId().equals(id)) {

                    U.setApellido(LU.getApellido());
                    U.setCedula(LU.getCedula());
                    U.setContrasena(LU.getContrasena());
                    U.setId(LU.getId());
                    U.setNombre(LU.getNombre());
                    U.setNombreSecundario(LU.getNombreSecundario());

                    return U;
                }
            }
            throw new NullPointerException("No existe este identificador");//404 not found

        } catch (NullPointerException e) {
            throw e;
        }
    }

    /**
     *
     * @throws ArrayIndexOutOfBoundsException, BussinessException
     */
    public void editar(ArrayList<Usuario> LUsuario, Usuario estudiante) {
        boolean bandera = false;
        try {
            if (LUsuario.isEmpty()) {
                throw new EmptyStackException();//204 NO CONTENT
            } else {
                for (Usuario LU : LUsuario) {
                    if (LU.getId().equals(estudiante.getId())) {
                        bandera = false;
                        if (LU.getCedula().equals(estudiante.getCedula())) {
                            int indice = LUsuario.indexOf(LU);
                            LUsuario.set(indice, estudiante);
                            break;
                        } else {
                            throw new RuntimeException("No se puede modificar la cedula");//409 CONFLICT
                        }
                    } else {
                        bandera = true;
                    }
                }
                if (bandera == true) {
                    throw new NullPointerException("No existe este identificador");//404 not found
                }
            }

        } catch (NullPointerException | IllegalArgumentException e) {
            throw e;
        }

    }

    /**
     *
     * @throws ArrayIndexOutOfBoundsException, BussinessException
     */
    public void elminarPorId(ArrayList<Usuario> LUsuario, String id) {
        boolean bandera = false;
        if (LUsuario.isEmpty()) {
            throw new EmptyStackException();//204 NO CONTENT
        } else {
            try {

                for (Usuario LU : LUsuario) {
                    if (LU.getId().equals(id)) {
                        bandera = false;
                        LUsuario.remove(LU);
                        break;
                    } else {
                        bandera = true;
                    }
                }
                if (bandera == true) {
                    throw new NullPointerException("No existe este identificador");//404 not found
                }
            } catch (NullPointerException e) {
                throw e;
            }
        }
    }

}

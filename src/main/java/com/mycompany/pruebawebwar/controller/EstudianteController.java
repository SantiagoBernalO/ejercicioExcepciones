/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pruebawebwar.controller;

import com.unicundi.proyectoplantillas.dato.Usuario;
import com.unicundi.proyectoplantillas.exception.BussinessException;
import com.unicundi.proyectoplantillas.exception.ExcepionWrraper;
import com.mycompany.pruebawebwar.service.EstudianteService;
import com.sun.org.apache.bcel.internal.generic.IUSHR;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.EmptyStackException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Controllador para recibir las peticiones de todo lo que tiene que ver con
 * estudiantes
 *
 * @authors Andres Bernal, David Quintero
 * @version 1.0
 */
@Stateless
@Path("/estudiantes")
public class EstudianteController {

    /**
     * Atributo tipo lista que guarda lo elementos Mientras es el tiempo de
     * ejecución
     */
    private static ArrayList<Usuario> LUsuario = new ArrayList<>();
    Usuario primero = new Usuario("1", "Santiago", "Andres", "Bernal", "112254", "7777");

    /**
     *
     */
    @POST
    @Path("/insertarPrimero")
    public void insertarPrimero() {
        LUsuario.add(primero);
        System.out.println("ok");
    }

    /**
     * Servicio que obtiene inserta el estidante nuevo
     *
     * @return Devuelve la respuesta que este en segun las excepciones o el
     * resultado de la ejecucion
     */
    @POST
    @Path("/insertar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertar(@Valid Usuario estudiante) throws Exception {
        EstudianteService s = new EstudianteService();
        s.insertar(LUsuario, estudiante);
        return Response.status(Response.Status.OK).build();
    }

    /**
     * Servicio que obtiene todos los estudiantes
     *
     * @return Devuelve una lista con todos los estudiantes en la lista
     */
    @GET
    @Path("/mostrar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response mostrar() throws BussinessException, ArrayIndexOutOfBoundsException, Exception {
        EstudianteService s = new EstudianteService();
        s.mostrar(LUsuario);
        return Response.status(Response.Status.OK).entity(LUsuario).build();
        //create 201
        //204
    }

    /**
     * @param id recibe el id que se desea borrar de la lista
     * @return Devuelve el resultado de la ejecucion y con este el estudiante
     * encontrado
     */
    @GET
    @Path("/obtenerPorId/{id}")
    @Valid
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerPorId(@Valid @Size(min = 1, max = 4) @PathParam("id") String id)
            throws BussinessException, BadRequestException {

        EstudianteService s = new EstudianteService();
        Usuario U = new Usuario();
        U = s.obtenerPorId(LUsuario, id);
        return Response.status(Response.Status.OK).entity(U).build();
    }

    /**
     *
     * @param estudiante recibe el estudiante para que actualice los atributos
     * @return devuelve la respuesta según la ejecución realizada
     */
    @PUT
    @Path("/editar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response editar(@Valid Usuario estudiante) {
        EstudianteService s = new EstudianteService();
        s.editar(LUsuario, estudiante);
        return Response.status(Response.Status.OK).build();
    }

    /**
     *
     * @param id recibe el id que se desea eliminar
     * @return devuelve la respuesta segun la ejecución realizada ya sea un ok o
     * que alguna excepción se disparo
     */
    @DELETE
    @Path("/eliminarPorId/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response elminarPorId(@PathParam("id") String id) {
        EstudianteService s = new EstudianteService();
        s.elminarPorId(LUsuario, id);
        return Response.status(Response.Status.OK).build();

    }

}

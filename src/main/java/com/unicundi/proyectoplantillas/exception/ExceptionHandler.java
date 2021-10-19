/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.proyectoplantillas.exception;

import java.nio.file.Paths;
import java.util.EmptyStackException;
import javax.el.PropertyNotFoundException;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotAllowedException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author ASUS
 */
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class ExceptionHandler implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception ex) {
        ex.printStackTrace();
        ExcepionWrraper wrraper;

        System.out.println(ex);
        String[] error;
        /*String errorNumero;
        String errorTipo ="";
        String[] error; 
        error = ex.getMessage().split(" ");
        for (int i = 0; i < error.length; i++) {
            if(i==1){
                errorNumero=error[i];
            }else if(i>1){
                errorTipo +=errorTipo +error[i];
            }
        }*/
        
        if (ex instanceof NotAllowedException) {
            wrraper = new ExcepionWrraper("405", "METHOD_NOT_ALLOWED", "Metodo no reconocido",
                    "estudiantes/");
            return Response.status(Response.Status.METHOD_NOT_ALLOWED).entity(wrraper).build();
        } else if (ex instanceof EmptyStackException) {
            wrraper = new ExcepionWrraper("204", "NO_CONTENT", "No existe contenido",
                    "estudiantes/");
            return Response.status(Response.Status.NO_CONTENT).entity(wrraper).build();

        } else if (ex instanceof IllegalArgumentException) {
            wrraper = new ExcepionWrraper("400", "BAD_REQUEST", ex.getMessage(),
            "estudiantes/");
            return Response.status(Response.Status.BAD_REQUEST).entity(wrraper).build();
        } else if (ex instanceof RuntimeException) {
            wrraper = new ExcepionWrraper("409", "CONFLICT", ex.getMessage(),
                    "/estudiantes");
            return Response.status(Response.Status.CONFLICT).entity(wrraper).build();
        } else if (ex instanceof NullPointerException) {
            wrraper = new ExcepionWrraper("404", "NOT_FOUND", ex.getMessage(),
                    "/estudiantes");
            return Response.status(Response.Status.NOT_FOUND).entity(wrraper).build();

        } else {
            wrraper = new ExcepionWrraper("500", "INTERNAL_SERVER_ERROR", "",
                    "/estudiantes");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(wrraper).build();
        }
    }
}

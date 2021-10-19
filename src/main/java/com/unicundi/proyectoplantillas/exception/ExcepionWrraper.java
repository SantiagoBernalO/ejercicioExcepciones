/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.proyectoplantillas.exception;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Andres Bernal, David Quintero
 */
public class ExcepionWrraper implements Serializable {
    
    private String codigo;
    
    private String error;
    
    private String fecha;
    
    private String mensaje;
    
    private String ulr;

    public ExcepionWrraper() {
    }
    
    public ExcepionWrraper(String codigo, String error, String mensaje, String ulr) {
        this.codigo = codigo;
        this.error = error;
        this.fecha = new Date().toString();
        this.mensaje = mensaje;
        this.ulr = ulr;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the error
     */
    public String getError() {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the ulr
     */
    public String getUlr() {
        return ulr;
    }

    /**
     * @param ulr the ulr to set
     */
    public void setUlr(String ulr) {
        this.ulr = ulr;
    }

    
    
}

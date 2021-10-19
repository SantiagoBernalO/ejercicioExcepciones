/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.proyectoplantillas.exception;

import java.io.Serializable;

/**
 *
 * @author asantibo
 */
public class ExcepcionOk implements Serializable {

    String id;
    String Nombre;
    String HyperLink1;
    String HyperLink2;
    String HyperLink3;

    public ExcepcionOk() {
    }

    public ExcepcionOk(String id, String Nombre, String HyperLink1, String HyperLink2, String HyperLink3) {
        this.id = id;
        this.Nombre = Nombre;
        this.HyperLink1 = HyperLink1;
        this.HyperLink2 = HyperLink2;
        this.HyperLink3 = HyperLink3;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getHyperLink1() {
        return HyperLink1;
    }

    public void setHyperLink1(String HyperLink1) {
        this.HyperLink1 = HyperLink1;
    }

    public String getHyperLink2() {
        return HyperLink2;
    }

    public void setHyperLink2(String HyperLink2) {
        this.HyperLink2 = HyperLink2;
    }

    public String getHyperLink3() {
        return HyperLink3;
    }

    public void setHyperLink3(String HyperLink3) {
        this.HyperLink3 = HyperLink3;
    }

}

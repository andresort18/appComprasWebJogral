/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guatex.datos;

/**
 *
 * @author Arsyi
 */
public class datosusuario {
    private String idusuario;
    private String coduser;
    private String nombre;
    private String apellido;
    private String estado;


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public String getCoduser() {
        return coduser;
    }

    public String getNombre() {
        return nombre;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guatex.Bean;

import com.guatex.datos.datoproveedor;
import java.util.LinkedList;
import java.util.List;
import org.primefaces.context.RequestContext;
import com.guatex.datos.consultausuario;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author danni
 */
public class BeanListaProveedor {

    /**
     * Creates a new instance of BeanListaProveedor
     */
    private datoproveedor a;
    private List<datoproveedor> b;
    private String nombre;
    private String nomprove;
    private String telefono;
    private String direccion;
    private String representante;
    private String correo;

    public String getNomprove() {
        return nomprove;
    }

    public void setNomprove(String nomprove) {
        this.nomprove = nomprove;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public datoproveedor getA() {
        return a;
    }

    public void setA(datoproveedor a) {
        this.a = a;
    }

    public List<datoproveedor> getB() {
        return b;
    }

    public void setB(List<datoproveedor> b) {
        this.b = b;
    }

    public void cargar() {
        b = new LinkedList<datoproveedor>();
        consultausuario c2 = new consultausuario();

        b = c2.listaproveedor(nombre);
        System.out.println(b.size());
    }

    public void insertadatos() {

        consultausuario c2 = new consultausuario();
        int respuesta = 0;
        System.out.println("el nombre es : " + nomprove);
        respuesta = c2.insertarproveedor(nomprove, telefono, direccion, representante, correo);
        System.out.println("la respuesta" + respuesta);
        if (respuesta != 0) {
            nomprove = " ";
            telefono = " ";
            direccion = " ";
            representante = " ";
            correo = " ";
            RequestContext contextoRequest = RequestContext.getCurrentInstance();
            contextoRequest.update("prov:nombre");
            contextoRequest.update("prov:telefono");
            contextoRequest.update("prov:direccion");
            contextoRequest.update("prov:representante");
            contextoRequest.update("prov:correo");

            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ingreso correctamente", null);

            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } else {
            nomprove = " ";
            telefono = " ";
            direccion = " ";
            representante = " ";
            correo = " ";
            RequestContext contextoRequest = RequestContext.getCurrentInstance();
            contextoRequest.update("prov:nombre");
            contextoRequest.update("prov:telefono");
            contextoRequest.update("prov:direccion");
            contextoRequest.update("prov:representante");
            contextoRequest.update("prov:correo");

            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ocurrio un error", null);

            FacesContext.getCurrentInstance().addMessage(null, facesMsg);

        }

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guatex.Bean;

import com.guatex.datos.consultausuario;
import com.guatex.datos.datosusuario;
import java.util.LinkedList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.context.RequestContext;


/**
 *
 * @author Arsyi
 */
public class BeanListaUsuarios {

    /**
     * Creates a new instance of BeanListaUsuarios
     */
       
    public BeanListaUsuarios(){
     
    }
    
    private datosusuario d1;
    private String idusr;
    private String codusr;
    private String stsusr;

    public String getIdusr() {
        return idusr;
    }

    public void setIdusr(String idusr) {
        this.idusr = idusr;
    }

    public String getCodusr() {
        return codusr;
    }

    public void setCodusr(String codusr) {
        this.codusr = codusr;
    }

    public String getStsusr() {
        return stsusr;
    }

    public void setStsusr(String stsusr) {
        this.stsusr = stsusr;
    }
    
    
    public datosusuario getD1() {
        return d1;
    }

    public void setD1(datosusuario d1) {
        this.d1 = d1;
        if (d1!=null) {
            idusr=d1.getIdusuario();
            codusr=d1.getCoduser();
            stsusr=d1.getEstado();
            
            RequestContext contextoRequest = RequestContext.getCurrentInstance();
            contextoRequest.update("users:txtidusr");
            contextoRequest.update("users:txtcodusr");
            contextoRequest.update("users:txtestado");
            contextoRequest.execute("PF('updateuser').show()");
        }
    }
    
    
    private List<datosusuario> l1;

    public List<datosusuario> getL1() {
        return l1;
    }
    
    public void setL1(List<datosusuario> l1) {
        this.l1 = l1;
    }
    
    public void cargar(){
        l1 = new LinkedList<datosusuario>();
        consultausuario c1 = new consultausuario();
        
        l1 = c1.listausuarios();
        System.out.println(l1.size());
    }
}

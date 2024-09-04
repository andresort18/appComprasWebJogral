/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guatex.Bean;

import com.guatex.datos.consultausuario;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Computer
 */
public class Beanlogin {

    /**
     * Creates a new instance of Beanlogin
     */
    private String usuario;
    private String password;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Beanlogin() {
    }
    
    public void carga(){
        consultausuario s = new consultausuario();
        
        System.out.println("hola");
        System.out.println("el usuario es : " + usuario);
        System.out.println("el password es : " + password);
        
        int valor=0;
        valor = s.consultausuario(usuario, password);
        System.out.println(valor);
        if (valor==1) {
        try{
           HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        FacesContext.getCurrentInstance().getExternalContext().redirect("faces/menu.xhtml");   
        }catch(Exception e){
            
        }    
        }
        else {
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario o contraseña incorrecto", null);

            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }
        /*este metodo nos sirve para mandar a llamar otras paginas puede servir para el menu.*/
        
    }
}

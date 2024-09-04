/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrimeraConex;

import StringConn.JvConexion;
import StringConn.ProductosVar;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Admin
 */
public class BeanAcceso {

    /**
     * Creates a new instance of BeanAcceso
     */
    public BeanAcceso() {
        
        
    }
    private String Usuario;
    private String Password;
    private String Componentes;
    private String IpServidor;
    private String qEmpresa;
    private String qClave;

    public String getqEmpresa() {
        return qEmpresa;
    }

    public String getqClave() {
        return qClave;
    }

    public void setqClave(String qClave) {
        this.qClave = qClave;
    }

    public void setqEmpresa(String qEmpresa) {
        this.qEmpresa = qEmpresa;
    }

    public String getIpServidor() {
        return IpServidor;
    }

    public void setIpServidor(String IpServidor) {
        this.IpServidor = IpServidor;
    }
    
    public String getComponentes() {
        return Componentes;
    }

    public void setComponentes(String Componentes) {
        this.Componentes = Componentes;
    }
    
    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    public void validarUsuario(){
        if (Componentes.equals("1")){
            IpServidor = "10.2.0.5";
            qEmpresa = "1";
            qClave = "OEM02panorama";
        } else if (Componentes.equals("2")){
            IpServidor = "10.1.0.4";
            qEmpresa = "9";
            qClave = "OEM02panorama";
        } else if(Componentes.equals("3")){
            IpServidor = "DESKTOP-C5DBUJV";
            qEmpresa = "9";
            qClave = "thinkpad";
        }
        JvConexion encontrar = new JvConexion();
        String respuesta = " ";
        respuesta = encontrar.ValidaUs(Usuario, Password,IpServidor,qClave);
        if (respuesta.equals("True")){
                    try{
           HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        FacesContext.getCurrentInstance().getExternalContext().redirect("faces/MenuPrin.xhtml");   
        ProductosVar capturausuario = new ProductosVar();
        capturausuario.setUsuario(Usuario);
        
        }catch(Exception e){
            
        }    
        }else{
            System.out.println("Acceso Denegado");
        }
        
                
    }
    

     
    
    
    
    
}

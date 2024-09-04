/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StringConn;

/**
 *
 * @author Admin
 */
public class ProductosVar {
    private String Codigo;
    private String Descrip;
    private String umedida;
    private String usuario;
    public String getCodigo() {
        return Codigo;
    }

   
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getDescrip() {
        return Descrip;
    }

    public void setDescrip(String Descrip) {
        this.Descrip = Descrip;
    }

    public String getUmedida() {
        return umedida;
    }

    public void setUmedida(String umedida) {
        this.umedida = umedida;
    }
    
}

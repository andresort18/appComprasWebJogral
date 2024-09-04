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
public class PrecioVar {
    private String Codigo;
    
    private String umedidaid;
    private String Descripcion;
    private String precio;
    public String getCodigo(String Codigo) {
        return Codigo;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }
/*
    public String getProductoid() {
        return productoid;
    }

    public void setProductoid(String productoid) {
        this.productoid = productoid;
    }
      */
    public String getUmedidaid() {
        return umedidaid;
    }

    public void setUmedidaid(String umedidaid) {
        this.umedidaid = umedidaid;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
    
}

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
public class PedidoVar {
    private String productoid;
    private String umedidaid;
    private String Descripcion;
    private String cantidad;
    private String precio;
    private String total;

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    
    public String getProductoid() {
        return productoid;
    }

    public void setProductoid(String productoid) {
        this.productoid = productoid;
    }

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

    
}

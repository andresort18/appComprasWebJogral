/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrimeraConex;

import StringConn.ListadoDetOc;
import StringConn.ProductosDetOc;
import java.util.List;

/**
 *
 * @author Admin
 */
public class BeanDetalleOc {

    /**
     * Creates a new instance of BeanDetalleOc
     */
    private List<ProductosDetOc> DetOc;

    public List<ProductosDetOc> getDetOc() {
        return DetOc;
    }

    public void setDetOc(List<ProductosDetOc> DetOc) {
        this.DetOc = DetOc;
    }

    public BeanDetalleOc() {
        ListadoDetOc listado = new ListadoDetOc();
        System.out.println("la lsita es " + listado.listaDetoc);
        DetOc = listado.listaDetoc; /*Este Bean es el encargado de llenar la lista en la pagina */
                                    /*Donde va el detalle de las ordenes de compra*/
    }

}

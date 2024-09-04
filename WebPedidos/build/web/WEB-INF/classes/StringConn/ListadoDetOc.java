/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StringConn;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ListadoDetOc {

 public static List<ProductosDetOc> listaDetoc = new LinkedList<ProductosDetOc>(); /*Aqui se esta declarando la lista para que sea*/
                                                                                    /*global y se pueda ejecutar en diferentes paginas*/
                                                                                     /*Para este tipo de listas se crea una nueva clase*/
                                                                                     /*la que creamos fue ListadoDetOc*/

    public static List<ProductosDetOc> getListaDetoc() {
        return listaDetoc;
    }

    public static void setListaDetoc(List<ProductosDetOc> listaDetoc) {
        ListadoDetOc.listaDetoc = listaDetoc;
    }
 
 
 
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guatex.Bean;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Computer
 */
public class Beanreporte {

    /**
     * Creates a new instance of Beanreporte
     */
    private String codigoact;

    public String getCodigoact() {
        return codigoact;
    }

    public void setCodigoact(String codigoact) {
        this.codigoact = codigoact;
    }

    public Beanreporte() {
    }

    public void reportempleadopdf() {
        String contenido = "hola a todos";
        Document documento = new Document();
        String file = " ";
        String ruta = System.getProperty("user.home");
        try {
            // System.out.println("el tamano de la list " + info.size());
            file = ruta + "/Desktop/reporte_empleado.pdf";
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/reporte_empleado.pdf"));
          
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("© Guatex 2020. Todos Los Derechos Reservados \n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma",18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte De Empleado \n\n");
            documento.open();
            documento.add(parrafo);
            
            PdfPTable tabla = new PdfPTable(6);

            tabla.addCell("Nombre");
            tabla.addCell("Apellido");
            tabla.addCell("Telefono");
            tabla.addCell("Estado");
            tabla.addCell("F.Ingreso");
            tabla.addCell("F.Baja");
            try {

                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/analisis", "root", "12345");
                PreparedStatement pst = cn.prepareStatement("select nombres,apellidos,telefono,estado,fecha_contratacion,fecha_baja from empleado");

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (DocumentException | SQLException e) {

            }
            documento.close();

        } catch (DocumentException | FileNotFoundException e) {

            System.out.println("ocurrio un error" + e);
        } 
        try {
            Process p = Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " + file);
        } catch (Exception e) {
            System.out.println("Error al abrir el archivo " + e);
        }

    }

    public void reporteordenpdf() {
        String contenido = "hola a todos";
        Document documento = new Document();
        String file = " ";
        String ruta = System.getProperty("user.home");
        try {
            // System.out.println("el tamano de la list " + info.size());
            file = ruta + "/Desktop/reporte_orden.pdf";
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/reporte_orden.pdf"));
             Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("© Guatex 2020. Todos Los Derechos Reservados \n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma",18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte De Orden \n\n");
            
            documento.open();
            documento.add(parrafo);
            PdfPTable tabla = new PdfPTable(7);

            tabla.addCell("No.Orden");
            tabla.addCell("Creacion");
            tabla.addCell("Asignado");
            tabla.addCell("Cantidad");
            tabla.addCell("Activo");
            tabla.addCell("U.Entrega");
            tabla.addCell("U.Recibe");
            try {

                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/analisis", "root", "12345");
                PreparedStatement pst = cn.prepareStatement("SELECT o.ord_orden, o.fecha_creacion, o.fecha_asignacion, dor.cantidad, a.descripcion, o.usuario_entrega, concat(e.nombres,' ',e.apellidos)"
                        + " FROM orden_asignacion o, detalle_de_orden_de_asignacion dor, activo a, expediente_empleado ex, empleado e"
                        + "  WHERE e.emp_empleado=ex.empleado_emp_empleado  AND ex.exp_expediente = o.expediente_empleado_exp_expediente "
                        + "  AND a.act_activo = dor.activo_act_activo  AND dor.det_orden = o.ord_orden");

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                        tabla.addCell(rs.getString(7));
                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (DocumentException | SQLException e) {

            }
            documento.close();

        } catch (DocumentException | FileNotFoundException e) {

            System.out.println("ocurrio un error" + e);
        }
        try {
            Process p = Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " + file);
        } catch (Exception e) {
            System.out.println("Error al abrir el archivo " + e);
        }

    }

    public void reporteactivo() {
        String contenido = "hola a todos";
        Document documento = new Document();
        String file = " ";
        String ruta = System.getProperty("user.home");
        try {
            // System.out.println("el tamano de la list " + info.size());
            file = ruta + "/Desktop/reporte_activo.pdf";
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/reporte_activo.pdf"));
            
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("© Guatex 2020. Todos Los Derechos Reservados \n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma",18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte De Activo \n\n");
           
            documento.open();
            documento.add(parrafo);
            
            PdfPTable tabla = new PdfPTable(6);

            tabla.addCell("Descripcion");
            tabla.addCell("Factura");
            tabla.addCell("F.Ingreso");
            tabla.addCell("Tip.Activo");
            tabla.addCell("Num.Serie");
            tabla.addCell("Estado");
            try {

                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/analisis", "root", "12345");
                PreparedStatement pst = cn.prepareStatement("select descripcion,factura,fecha_ingreso,tipo_activo,num_serie,estado from activo");

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (DocumentException | SQLException e) {

            }
            documento.close();

        } catch (DocumentException | FileNotFoundException e) {

            System.out.println("ocurrio un error" + e);
        }
        try {
            Process p = Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " + file);
        } catch (Exception e) {
            System.out.println("Error al abrir el archivo " + e);
        }

    }

    public void reportehistorial() {
        System.out.println("la variabl es : " + codigoact);
        String contenido = "hola a todos";
        Document documento = new Document();
        String file = " ";
        String ruta = System.getProperty("user.home");
        try {
            // System.out.println("el tamano de la list " + info.size());
            file = ruta + "/Desktop/reporte_historial.pdf";
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/reporte_historial.pdf"));
            
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("© Guatex 2020. Todos Los Derechos Reservados \n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma",18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte De Historial Activo \n\n"); 
            
            documento.open();
            documento.add(parrafo);
            
            PdfPTable tabla = new PdfPTable(9);

            tabla.addCell("Cod.Activo");
            tabla.addCell("Descripcion");
            tabla.addCell("Tip.falla");
            tabla.addCell("Ant.estado");
            tabla.addCell("N.Estado");
            tabla.addCell("F.Cambio");
            tabla.addCell("Sintoma");
            tabla.addCell("Diagnostico");
            tabla.addCell("Solucion");
            try {

                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/analisis", "root", "12345");
                PreparedStatement pst = cn.prepareStatement("SELECT a.act_activo, a.descripcion, trae_lval('CLASFALLA',ha.clasificacion), trae_lval('ESTHA',ha.antiguo_estado), trae_lval('ESTHA',ha.nuevo_estado), ha.fecha_situacion, ha.sintoma, ha.diagnostico, ha.solucion "
                        + "  FROM activo a, historial_activo ha  WHERE a.act_activo = ha.activo_act_activo AND ha.activo_act_activo ='" + codigoact + "' ORDER BY FECHA_SITUACION DESC ");

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                        tabla.addCell(rs.getString(7));
                        tabla.addCell(rs.getString(8));
                        tabla.addCell(rs.getString(9));
                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (DocumentException | SQLException e) {

            }
            documento.close();

        } catch (DocumentException | FileNotFoundException e) {

            System.out.println("ocurrio un error" + e);
        }

        try {
            Process p = Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " + file);
        } catch (Exception e) {
            System.out.println("Error al abrir el archivo " + e);
        }

    }
    
    public void reportecompra(){
        
          System.out.println("la variabl es : " + codigoact);
        String contenido = "hola a todos";
        Document documento = new Document();
        String file = " ";
        String ruta = System.getProperty("user.home");
        try {
            // System.out.println("el tamano de la list " + info.size());
            file = ruta + "/Desktop/reporte_compra.pdf";
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/reporte_compra.pdf"));
            
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("© Guatex 2020. Todos Los Derechos Reservados \n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma",18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte De Compra Activo \n\n"); 
            
            documento.open();
            documento.add(parrafo);
            
            PdfPTable tabla = new PdfPTable(5);

            tabla.addCell("Nombre");
            tabla.addCell("Descripcion");
            tabla.addCell("Cantidad");
            tabla.addCell("Precio Unitario");
            tabla.addCell("Fecha");
   
            try {

                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/analisis", "root", "12345");
                PreparedStatement pst = cn.prepareStatement("SELECT prov.nombre,act.descripcion,ing.cantidad,ing.precio_unitario , ing.fecha  "
                        + "    FROM ingreso_activo ing , activo act,proveedor prov  "
                        + "    WHERE ing.activo_act_activo = act.act_activo AND  ing.proveedor_prov_proveedor= prov.prov_proveedor;");

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));

                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (DocumentException | SQLException e) {

            }
            documento.close();

        } catch (DocumentException | FileNotFoundException e) {

            System.out.println("ocurrio un error" + e);
        }

        try {
            Process p = Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " + file);
        } catch (Exception e) {
            System.out.println("Error al abrir el archivo " + e);
        }
        
        
        
    }
    
    

}

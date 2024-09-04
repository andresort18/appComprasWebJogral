/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guatex.Bean;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.lowagie.text.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Computer
 */
public class Beansolicitud {

    /**
     * Creates a new instance of Beansolicitud
     */
    private String descripcion;
    private String cantidad;
    private String empleado;
    private Date fechacreacion = new Date();
    private String departamento;
    private String areadepatamento;
    private List<String> producto = new LinkedList<String>();
    private List<String> listado2;

    public List<String> getProducto() {
        return producto;
    }

    public void setProducto(List<String> producto) {
        this.producto = producto;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getAreadepatamento() {
        return areadepatamento;
    }

    public void setAreadepatamento(String areadepatamento) {
        this.areadepatamento = areadepatamento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public Beansolicitud() {
    }

    public void agregarinfo() {
        listado2 = new LinkedList<String>();
              String fecha;
        DateFormat fechaFormato = new SimpleDateFormat("yyyyMMdd");
        fecha = fechaFormato.format(fechacreacion);

        producto.add(descripcion + "            " + cantidad + "              " + empleado + "             " + fecha + "             " + departamento + "           " + areadepatamento);
        listado2.addAll(producto);

        descripcion = " ";
        cantidad = " ";
        empleado = " ";
        fechacreacion = new Date();
        departamento = " ";
        areadepatamento = "   ";
        RequestContext contextoRequest = RequestContext.getCurrentInstance();
        contextoRequest.update("soli:descrip");
        contextoRequest.update("soli:cantida");
        contextoRequest.update("soli:emple");
        contextoRequest.update("soli:buttonfecha");
        contextoRequest.update("soli:depar");
        contextoRequest.update("soli:areadepart");
        System.out.println("el tamamno de la lista es : " + producto.size());

    }

    public void reportsolicitudpdf() {
        String res = " ";
        for (int i = 0; i < listado2.size(); i++) {
            System.out.println(" d" + listado2.get(i));
            res = res + listado2.get(i) + "\n\n";
        }

        String contenido = "hola a todos";
        Document documento = new Document();
        String file = " ";

        String ruta = System.getProperty("user.home");
        try {
            // System.out.println("el tamano de la list " + info.size());
            file = ruta + "/Desktop/reporte_solicitud.pdf";
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/reporte_solicitud.pdf"));

            Paragraph parrafo1 = new Paragraph();
            parrafo1.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo1.add("© Guatex 2020. Todos Los Derechos Reservados \n\n");
            parrafo1.setFont(FontFactory.getFont("Tahoma", 18, com.itextpdf.text.Font.BOLD, BaseColor.DARK_GRAY));
            parrafo1.add("Hoja de solicitud de activos \n\n");

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_JUSTIFIED);
            parrafo.add(res + "\n\n");

            parrafo.setFont(FontFactory.getFont("Tahoma", 12, Font.NORMAL, BaseColor.DARK_GRAY));

            documento.open();
            documento.add(parrafo1);
            documento.add(parrafo);

            documento.close();

        } catch (DocumentException | FileNotFoundException e) {

            System.out.println("ocurrio un error" + e);
        }

        producto.clear();
        listado2.clear();
        try {
            Process p = Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " + file);
        } catch (Exception e) {
            System.out.println("Error al abrir el archivo " + e);
        }

    }

}

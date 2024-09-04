/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guatex.Bean;

import com.guatex.datos.consultausuario;
import com.guatex.datos.datoactivo;
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
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author danni
 */
public class BeanListaActivo {

    private List<datoactivo> a;
    private String serie;
    private String descripcion;
    private String num_serie;
    private String codigo_barra;
    private String observaciones;
    private String fecha_ingreso;
    private String factura;
    private String categoria_activo;
    private String estado;
    private String fecha_estado;
    private String tipo_activo;
    private List<datoactivo> info;

    public List<datoactivo> getInfo() {
        return info;
    }

    public void setInfo(List<datoactivo> info) {
        this.info = info;
    }

    public List<datoactivo> getA() {
        return a;
    }

    public void setA(List<datoactivo> a) {
        this.a = a;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNum_serie() {
        return num_serie;
    }

    public void setNum_serie(String num_serie) {
        this.num_serie = num_serie;
    }

    public String getCodigo_barra() {
        return codigo_barra;
    }

    public void setCodigo_barra(String codigo_barra) {
        this.codigo_barra = codigo_barra;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public String getCategoria_activo() {
        return categoria_activo;
    }

    public void setCategoria_activo(String categoria_activo) {
        this.categoria_activo = categoria_activo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha_estado() {
        return fecha_estado;
    }

    public void setFecha_estado(String fecha_estado) {
        this.fecha_estado = fecha_estado;
    }

    public String getTipo_activo() {
        return tipo_activo;
    }

    public void setTipo_activo(String tipo_activo) {
        this.tipo_activo = tipo_activo;
    }

   

    public void cargar() {
        a = new LinkedList<datoactivo>();
        consultausuario c2 = new consultausuario();

        a = c2.listaactivo(serie);
        info = c2.listaactivo(serie);
        System.out.println(a.size());
        System.out.println(info.size());
    }

    public void insertadatos() {

        consultausuario c2 = new consultausuario();
        int respuesta = 0;
        System.out.println("el nombre es : " + descripcion);
        respuesta = c2.insertaractivo(descripcion, num_serie, codigo_barra, observaciones, fecha_ingreso, factura, categoria_activo, estado, fecha_estado, tipo_activo);
        System.out.println("la respuesta" + respuesta);
        if (respuesta != 0) {
            descripcion = " ";
            num_serie = " ";
            codigo_barra = " ";
            observaciones = " ";
            fecha_ingreso = " ";
            factura = " ";
            categoria_activo = " ";
            estado = " ";
            fecha_estado = " ";
            tipo_activo = " ";
            RequestContext contextoRequest = RequestContext.getCurrentInstance();
            contextoRequest.update("act:descripcion");
            contextoRequest.update("act:num_serie");
            contextoRequest.update("act:codigo_barra");
            contextoRequest.update("act:observaciones");
            contextoRequest.update("act:fecha_ingreso");
            contextoRequest.update("act:factura");
            contextoRequest.update("act:categoria_activo");
            contextoRequest.update("act:estado");
            contextoRequest.update("act:fecha_estado");
            contextoRequest.update("act:tipo_activo");

            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ingreso correctamente", null);

            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } else {
            descripcion = " ";
            num_serie = " ";
            codigo_barra = " ";
            observaciones = " ";
            fecha_ingreso = " ";
            factura = " ";
            categoria_activo = " ";
            estado = " ";
            fecha_estado = " ";
            tipo_activo = " ";
            RequestContext contextoRequest = RequestContext.getCurrentInstance();
            contextoRequest.update("act:descripcion");
            contextoRequest.update("act:num_serie");
            contextoRequest.update("act:codigo_barra");
            contextoRequest.update("act:observaciones");
            contextoRequest.update("act:fecha_ingreso");
            contextoRequest.update("act:factura");
            contextoRequest.update("act:categoria_activo");
            contextoRequest.update("act:estado");
            contextoRequest.update("act:fecha_estado");
            contextoRequest.update("act:tipo_activo");

            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ocurrio un error", null);

            FacesContext.getCurrentInstance().addMessage(null, facesMsg);

        }

    }

}

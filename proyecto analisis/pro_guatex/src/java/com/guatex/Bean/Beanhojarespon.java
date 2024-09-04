/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guatex.Bean;

import com.guatex.datos.consultausuario;
import com.guatex.datos.datohoja;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.lowagie.text.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Computer
 */
public class Beanhojarespon {

    /**
     * Creates a new instance of Beanhojarespon
     */
    private String empleado;
    private String activo;
    private String departamento;
    private List<datohoja> nombre;
    private List<datohoja> act;
    private List<datohoja> dept;

    public List<datohoja> getNombre() {
        return nombre;
    }

    public void setNombre(List<datohoja> nombre) {
        this.nombre = nombre;
    }

    public List<datohoja> getAct() {
        return act;
    }

    public void setAct(List<datohoja> act) {
        this.act = act;
    }

    public List<datohoja> getDept() {
        return dept;
    }

    public void setDept(List<datohoja> dept) {
        this.dept = dept;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Beanhojarespon() {
        nombre = new LinkedList<datohoja>();
        act = new LinkedList<datohoja>();
        dept = new LinkedList<datohoja>();
        consultausuario s = new consultausuario();
        nombre = s.listaemple();
        act = s.listaacti();
        dept = s.listadepto();
    }
    
    public void generacionhoja(){
         String res = " ";
     
        String contenido = "hola a todos";
        Document documento = new Document();
        String file = " ";

        String ruta = System.getProperty("user.home");
        try {
            // System.out.println("el tamano de la list " + info.size());
            file = ruta + "/Desktop/hoja_responsabilidad.pdf";
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/hoja_responsabilidad.pdf"));

            Paragraph parrafo1 = new Paragraph();
            parrafo1.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo1.add("© Guatex 2020. Todos Los Derechos Reservados \n\n");
            parrafo1.setFont(FontFactory.getFont("Tahoma", 18, com.itextpdf.text.Font.BOLD, BaseColor.DARK_GRAY));
            parrafo1.add("Hoja de responsabilidad \n\n");

//                private String empleado;
//    private String activo;
//    private String departamento;
            
            
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_JUSTIFIED);
            parrafo.add("Nombre del empleado       " + "   Depatamento-Area " + "                                         Activo Asignado  " +"\n\n");
            parrafo.add(  empleado + "             " + departamento+"        "+ activo+"            " + "\n\n");
            

            parrafo.setFont(FontFactory.getFont("Tahoma", 12, Font.NORMAL, BaseColor.DARK_GRAY));

            documento.open();
            documento.add(parrafo1);
            documento.add(parrafo);

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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guatex.datos;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Arsyi
 */
public class consultausuario {
    
    public int consultausuario(String us, String pas) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        int respuesta = 0;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/analisis", "root", "12345");
            String query = "SELECT CONFIRMA_USUARIO('" + us + "','" + pas + "') from dual";
            System.out.println(query);
            st = (PreparedStatement) con.prepareStatement(query);
            rs = st.executeQuery();
            if (rs.next()) {
                if (rs.getString(1) != null) {
                    respuesta = 1;
                }
            }
            
        } catch (Exception ex) {
            System.out.println("ocurrio un error" + ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    
                }
                rs = null;
            }
            
            if (st != null) {
                try {
                    st.close();
                } catch (Exception e) {
                    
                }
                st = null;
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    
                }
                con = null;
            }
            
        }
        
        return respuesta;
    }
    
    public List<datosusuario> listausuarios() {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        LinkedList<datosusuario> respuesta = new LinkedList<datosusuario>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/analisis", "root", "12345");
            String query = "SELECT u.us_usuario, u.username,TRAE_LVAL('ESTUSER',u.estado), e.nombres, e.apellidos FROM usuario u, empleado e WHERE e.emp_empleado = u.emp_empleado";
            st = (PreparedStatement) con.prepareStatement(query);
            rs = st.executeQuery();
            System.out.println("el query es : " + query);
            while (rs.next()) {
                datosusuario s1 = new datosusuario();
                s1.setIdusuario(rs.getString(1));
                s1.setCoduser(rs.getString(2));
                s1.setEstado(rs.getString(3));
                s1.setNombre(rs.getString(4));
                s1.setApellido(rs.getString(5));
                respuesta.add(s1);
            }
            
        } catch (Exception ex) {
            System.out.println("ocurrio un error" + ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    
                }
                rs = null;
            }
            
            if (st != null) {
                try {
                    st.close();
                } catch (Exception e) {
                    
                }
                st = null;
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    
                }
                con = null;
            }
            
        }
        
        return respuesta;
    }
    
    public List<datoproveedor> listaproveedor(String nombre) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        LinkedList<datoproveedor> respuesta = new LinkedList<datoproveedor>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/analisis", "root", "12345");
            String query;
            if (nombre.isEmpty()) {
                query = "Select nombre,telefono,direccion,representante,correo from proveedor";
            } else {
                query = "Select nombre,telefono,direccion,representante,correo from proveedor where nombre ='" + nombre + "'";
            }
            
            st = (PreparedStatement) con.prepareStatement(query);
            rs = st.executeQuery();
            
            while (rs.next()) {
                datoproveedor s2 = new datoproveedor();
                s2.setNombre(rs.getString(1));
                s2.setTelefono(rs.getString(2));
                s2.setDireccion(rs.getString(3));
                s2.setRepresentante(rs.getString(4));
                s2.setCorreo(rs.getString(5));
                respuesta.add(s2);
            }
            
        } catch (Exception ex) {
            System.out.println("ocurrio un error" + ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    
                }
                rs = null;
            }
            
            if (st != null) {
                try {
                    st.close();
                } catch (Exception e) {
                    
                }
                st = null;
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    
                }
                con = null;
            }
            
        }
        
        return respuesta;
    }
    
    public int insertarproveedor(String nombre, String telefono, String direccion, String representante, String correo) {
        int respuesta = 0;
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/analisis", "root", "12345");
            String query = "INSERT INTO proveedor (nombre,telefono,direccion,representante,correo) values(?,?,?,?,?)";
            st = (PreparedStatement) con.prepareStatement(query);
            st.setString(1, nombre);
            st.setString(2, telefono);
            st.setString(3, direccion);
            st.setString(4, representante);
            st.setString(5, correo);
            
            int r = st.executeUpdate();
            
            if (r != 0) {
                respuesta = 1;
            }
            
        } catch (SQLException ex) {
            System.out.println("ocurrio un error" + ex);
            
        } catch (Exception ex) {
            System.out.println("ocurrio un error" + ex);
            
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    
                }
                rs = null;
            }
            
            if (st != null) {
                try {
                    st.close();
                } catch (Exception e) {
                    
                }
                st = null;
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    
                }
                con = null;
            }
            
        }
        
        return respuesta;
    }
    
    public List<datoactivo> listaactivo(String serie) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        LinkedList<datoactivo> respuesta = new LinkedList<datoactivo>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/analisis", "root", "12345");
            String query;
            if (serie.isEmpty()) {
                query = "Select descripcion,num_serie,codigo_barra,observaciones,fecha_ingreso,factura,categoria_activo,estado,fecha_estado,tipo_activo from activo";
            } else {
                query = "Select descripcion,num_serie,codigo_barra,observaciones,fecha_ingreso,factura,categoria_activo,estado,fecha_estado,tipo_activo from activo where num_serie ='" + serie + "'";
            }
            
            st = (PreparedStatement) con.prepareStatement(query);
            rs = st.executeQuery();
            
            while (rs.next()) {
                datoactivo s3 = new datoactivo();
                s3.setDescripcion(quitaNulo(rs.getString(1)));
                s3.setNum_serie(quitaNulo(rs.getString(2)));
                s3.setCodigo_barra(quitaNulo(rs.getString(3)));
                s3.setObservaciones(quitaNulo(rs.getString(4)));
                s3.setFecha_ingreso(quitaNulo(rs.getString(5)));
                s3.setFactura(quitaNulo(rs.getString(6)));
                s3.setCategoria_activo(quitaNulo(rs.getString(7)));
                s3.setEstado(quitaNulo(rs.getString(8)));
                s3.setFecha_estado(quitaNulo(rs.getString(9)));
                s3.setTipo_activo(quitaNulo(rs.getString(10)));
                
                respuesta.add(s3);
            }
            
        } catch (Exception ex) {
            System.out.println("ocurrio un error" + ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    
                }
                rs = null;
            }
            
            if (st != null) {
                try {
                    st.close();
                } catch (Exception e) {
                    
                }
                st = null;
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    
                }
                con = null;
            }
            
        }
        
        return respuesta;
    }
    
    public int insertaractivo(String descripcion, String num_serie, String codigo_barra, String observaciones, String fecha_ingreso, String factura, String categoria_activo, String estado, String fecha_estado, String tipo_activo) {
        int respuesta = 0;
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/analisis", "root", "12345");
            String query = "INSERT INTO activo (descripcion,num_serie,codigo_barra,observaciones,fecha_ingreso,factura,categoria_activo,estado,fecha_estado,tipo_activo) values(?,?,?,?,?,?,?,?,?,?)";
            st = (PreparedStatement) con.prepareStatement(query);
            st.setString(1, descripcion);
            st.setString(2, num_serie);
            st.setString(3, codigo_barra);
            st.setString(4, observaciones);
            st.setString(5, fecha_ingreso);
            st.setString(6, factura);
            st.setString(7, categoria_activo);
            st.setString(8, estado);
            st.setString(9, fecha_estado);
            st.setString(10, tipo_activo);
            
            int r = st.executeUpdate();
            
            if (r != 0) {
                respuesta = 1;
            }
            
        } catch (SQLException ex) {
            System.out.println("ocurrio un error" + ex);
            
        } catch (Exception ex) {
            System.out.println("ocurrio un error" + ex);
            
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    
                }
                rs = null;
            }
            
            if (st != null) {
                try {
                    st.close();
                } catch (Exception e) {
                    
                }
                st = null;
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    
                }
                con = null;
            }
            
        }
        
        return respuesta;
    }
    
    public List<datohoja> listaemple() {
        List<datohoja> respuesta = new LinkedList<datohoja>();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/analisis", "root", "12345");
            String query = "SELECT nombres,apellidos FROM empleado;";
            st = (PreparedStatement) con.prepareStatement(query);
            rs = st.executeQuery();
            
            while (rs.next()) {
                datohoja s = new datohoja();
                s.setNombre((quitaNulo(rs.getString(1))) + "-" + (quitaNulo(rs.getString(2))));
                respuesta.add(s);
                
            }
            
        } catch (SQLException ex) {
            System.out.println("ocurrio un error" + ex);
            
        } catch (Exception ex) {
            System.out.println("ocurrio un error" + ex);
            
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    
                }
                rs = null;
            }
            
            if (st != null) {
                try {
                    st.close();
                } catch (Exception e) {
                    
                }
                st = null;
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    
                }
                con = null;
            }
            
        }
        
        return respuesta;
        
    }

    public List<datohoja> listaacti() {
        List<datohoja> respuesta = new LinkedList<datohoja>();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/analisis", "root", "12345");
            String query = "SELECT descripcion FROM activo;";
            st = (PreparedStatement) con.prepareStatement(query);
            rs = st.executeQuery();
            
            while (rs.next()) {
                datohoja s = new datohoja();
                s.setActivo(quitaNulo(rs.getString(1)));
                respuesta.add(s);
                
            }
            
        } catch (SQLException ex) {
            System.out.println("ocurrio un error" + ex);
            
        } catch (Exception ex) {
            System.out.println("ocurrio un error" + ex);
            
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    
                }
                rs = null;
            }
            
            if (st != null) {
                try {
                    st.close();
                } catch (Exception e) {
                    
                }
                st = null;
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    
                }
                con = null;
            }
            
        }
        
        return respuesta;
        
    }
    
       public List<datohoja> listadepto() {
        List<datohoja> respuesta = new LinkedList<datohoja>();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/analisis", "root", "12345");
            String query = "SELECT dept.descripcion, are.descripcion FROM departamento dept , area_departamento are WHERE are.departamento_dep_departamento= dept.dep_departamento;";
            st = (PreparedStatement) con.prepareStatement(query);
            rs = st.executeQuery();
            
            while (rs.next()) {
                datohoja s = new datohoja();
                s.setDepartamento((quitaNulo(rs.getString(1))) + "-" + (quitaNulo(rs.getString(2))));
                respuesta.add(s);
                
            }
            
        } catch (SQLException ex) {
            System.out.println("ocurrio un error" + ex);
            
        } catch (Exception ex) {
            System.out.println("ocurrio un error" + ex);
            
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    
                }
                rs = null;
            }
            
            if (st != null) {
                try {
                    st.close();
                } catch (Exception e) {
                    
                }
                st = null;
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    
                }
                con = null;
            }
            
        }
        
        return respuesta;
        
    }

    
    
    
    public String quitaNulo(String var) {
        String res = "";
        if (var != null && var.trim().length() > 0) {
            res = var.trim();
        } else {
            res = "";
        }
        return res;
    }
    
}

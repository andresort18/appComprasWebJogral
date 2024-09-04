/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StringConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class JvConexion {
private String qusuario;
private String codusuario;

    public String getCodusuario() {
        return codusuario;
    }

    public void setCodusuario(String codusuario) {
        this.codusuario = codusuario;
    }

    public String getQusuario() {
        return qusuario;
    }

    public void setQusuario(String qusuario) {
        this.qusuario = qusuario;
    }
//este metodo conecta para mostrar los productos cuando se hace una consulta
    public List<ProductosVar> consultamaestros(String qDescrip,String IpServidor,String Empresa,String Clave) {
//		String respuesta = " ";
        List<ProductosVar> respuesta = new LinkedList<ProductosVar>();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://" +  IpServidor + ";databaseName=PCINVJes;user=sa;password= " + Clave + ";";
            con = DriverManager.getConnection(url);

            String query = "select ProductoId,DescripcionLarga,UMedidaVenta   from INVProducto Where Empresaid = " + Empresa +  " and DescripcionLarga Like '%" + qDescrip + "%'";

            st = con.prepareStatement(query);
            rs = st.executeQuery();
            while (rs.next()) {
//                               String Prueba = rs.getString(1);
                ProductosVar s = new ProductosVar();
                s.setCodigo(rs.getString(1));
                s.setDescrip(rs.getString(2));
                s.setUmedida(rs.getString(3));
                respuesta.add(s);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
                rs = null;
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                }
                st = null;
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
                con = null;
            }
        }

        return respuesta;

    }
//este metodo hace la conexion para ir a traer las ordenes de compra
//este metodo conecta para mostrar los productos cuando se hace una consulta
    public List<ProductosOc> consultaoc(String qDescrip,String IpServidor,String Empresa,String Clave) {
//		String respuesta = " ";
        List<ProductosOc> respuesta = new LinkedList<ProductosOc>();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://" +  IpServidor + ";databaseName=PCINVJes;user=sa;password= " + Clave + ";";
            con = DriverManager.getConnection(url);

            String query = "select a.PreOrdenId,a.DescProveedor,a.Fecha,a.Observaciones,b.Nombre,a.FechaEntrega,a.Autorizado,a.Denegado,a.Anulado,a.Duplicada,a.Finalizada , " + 
                    "a.PreordenId,a.NitId,a.DescProveedor,a.Fecha,a.Observaciones,a.CompradorId,a.MarcaId,c.Descripcion,a.Sede, " +
                    "a.StatusId,a.SubTotal,a.DescuentoFinCosto,a.DescuentoFinNoCosto,a.DescuentoSaldos,a.MontoDescFinCosto,a.MontoDescFinNOCosto, " +
                    "a.MontoDescSaldos,a.TotalIva,a.TotalBono,a.MontoBono,a.TotalCostoSinBono,a.TotalCostoSinIvaSinBono,a.TotalSinIva,a.Total, " +
                    "a.TotalFactura,a.TotalFaltantes " +
                    " from COMPreOrden  a, INVXComprador b, INVXMarca c Where a.EmpresaId = b.EmpresaId and a.CompradorId = b.CompradoId and  " +
                    " c.Empresaid = a.EmpresaId and c.MarcaId = a.MarcaId  and "
                    + "a.Empresaid = " + Empresa +  " and a.Autorizado = 0 and finalizada = 0" ;

            st = con.prepareStatement(query);
            rs = st.executeQuery();
            while (rs.next()) {
//                               String Prueba = rs.getString(1);
                ProductosOc s = new ProductosOc();
                s.setCodigo(rs.getString(1));
                s.setDescriprov(rs.getString(2));
                s.setFecha(rs.getString(3));
                s.setObservaciones(rs.getString(4));
                s.setNombre(rs.getString(5));
                s.setFechaEnt(rs.getString(6));
                s.setAutorizado(rs.getBoolean(7));
                s.setDenegado(rs.getBoolean(8));
                s.setAnulado(rs.getBoolean(9));
                s.setDuplicada(rs.getBoolean(10));
                s.setFinalizada(rs.getBoolean(11));
                s.setqPreorde(rs.getString(12));
                s.setQnitid(rs.getString(13));
                s.setqDescProve(rs.getString(14));
                s.setqFecha(rs.getString(15));
                s.setqObserva(rs.getString(16));
                s.setqComprador(rs.getString(17));
                s.setqMarca(rs.getString(18));
                s.setqDescripcion(rs.getString(19));
                s.setqSede(rs.getString(20));
                s.setqStatusId(rs.getString(21));
                s.setqSubTotal(rs.getDouble(22));
                s.setqDescuentoFinCosto(rs.getDouble(23));
                s.setqDescuentoFinNoCosto(rs.getDouble(24));
                s.setqDescuentoSaldos(rs.getDouble(25));
                s.setqMontoDescFinCosto(rs.getDouble(26));
                s.setqMontoDescFinNOCosto(rs.getDouble(27));
                s.setqMontoDescSaldos(rs.getDouble(28));
                s.setqTotalIva(rs.getDouble(29));
                s.setqTotalBono(rs.getDouble(30));
                s.setqMontoBono(rs.getDouble(31));
                s.setqTotalCostoSinBono(rs.getDouble(32));
                s.setqTotalCostoSinIvaSinBono(rs.getDouble(33));
                s.setqTotalSinIva(rs.getDouble(34));
                s.setqTotal(rs.getDouble(35));
                s.setqTotalFactura(rs.getDouble(36));
                s.setqTotalFaltantes(rs.getDouble(37));
                respuesta.add(s);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
                rs = null;
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                }
                st = null;
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
                con = null;
            }
        }

        return respuesta;

    }    
    
    
    
    
    
    
    
    public String ValidaUs(String Usuario, String Password, String IpServidor,String Clave) {
        String respuesta = " ";
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://"  + IpServidor + ";databaseName=PCINVJes;user=sa;password=" + Clave + ";";
            con = DriverManager.getConnection(url);

            String query = "select UsuarioId,Password   from ERPUsuarios where usuarioId = '" + Usuario + "' and Password = '" + Password + "'";

            st = con.prepareStatement(query);
            rs = st.executeQuery();
            if (rs.next()) {
                qusuario = rs.getString(1);
                respuesta = "True";
            }
//			while (rs.next()) {
////                               String Prueba = rs.getString(1);
//				ProductosVar s = new ProductosVar();
//				s.setCodigo(rs.getString(1));
//				s.setDescrip(rs.getString(2));
//				s.setUmedida(rs.getString(3));
//				respuesta.add(s);
//			}

        } catch (SQLException ex) {
            ex.printStackTrace();

            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
                rs = null;
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                }
                st = null;
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
                con = null;
            }
        }
        return respuesta;

    }

    public int GuardaProducto(String Usuario, String Producto, String DescProd, String Medida, int Cant,String IpServidor, String Clave) {
        int respuesta = 0;
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://" + IpServidor + " ;databaseName=PCINVJes;user=sa;password= " + Clave + ";";
            con = DriverManager.getConnection(url);

            String query = "Insert FACPedDetweb(UsuarioId,ProductoId,Descripcion,UMedidaId,Cantidad) Values (?,?,?,?,?)";

            st = con.prepareStatement(query);
            st.setString(1, Usuario);
            st.setString(2, Producto);
            st.setString(3, DescProd);
            st.setString(4, Medida);
            st.setInt(5, Cant);
            int r = st.executeUpdate();
            if (r != 0) {
                respuesta = 1;
            }

//			while (rs.next()) {
////                               String Prueba = rs.getString(1);
//				ProductosVar s = new ProductosVar();
//				s.setCodigo(rs.getString(1));
//				s.setDescrip(rs.getString(2));
//				s.setUmedida(rs.getString(3));
//				respuesta.add(s);
//			}
        } catch (SQLException ex) {
            ex.printStackTrace();
            respuesta = 0;
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            respuesta = 0;
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
                rs = null;
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                }
                st = null;
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
                con = null;
            }
        }
        return respuesta;

    }
    public List<PedidoVar> consultapedidos( String qusuario,String IpServidor, String Clave) {
//		String respuesta = " ";
        List<PedidoVar> respuesta = new LinkedList<PedidoVar>();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver:// " + IpServidor + ";databaseName=PCINVJes;user=sa;password= " + Clave + ";";
            con = DriverManager.getConnection(url);

            String query = "select ProductoId,Descripcion,UMedidaId,Cantidad,PrecioVenta,PrecioTotal from FACPedDetweb Where UsuarioId ='" + qusuario + "'";
            System.out.println("el query es : " + query);
            st = con.prepareStatement(query);
            rs = st.executeQuery();
            while (rs.next()) {
//                               String Prueba = rs.getString(1);
                PedidoVar s = new PedidoVar();
                s.setProductoid(quitaNulo(rs.getString(1)));
                s.setDescripcion(quitaNulo(rs.getString(2)));
                s.setUmedidaid(quitaNulo(rs.getString(3)));
                s.setCantidad(quitaNulo(rs.getString(4)));
                s.setPrecio(quitaNulo(rs.getString(5)));
                s.setTotal(quitaNulo(rs.getString(6)));
                respuesta.add(s);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
                rs = null;
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                }
                st = null;
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
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
  
//  envia pedido
   public String enviapedido(String codusuario,String IpServidor,String Clave) {
        String respuesta = " ";
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://" + IpServidor + ";databaseName=PCINVJes;user=sa;password= " + Clave + ";";
            con = DriverManager.getConnection(url);

            String query = "Execute  InsertaPedWeb '" + codusuario + "'";

            st = con.prepareStatement(query);
            rs = st.executeQuery();
//            if (rs.next()) {
//                qusuario = rs.getString(1);
//                respuesta = "True";
//            }
//			while (rs.next()) {
////                               String Prueba = rs.getString(1);
//				ProductosVar s = new ProductosVar();
//				s.setCodigo(rs.getString(1));
//				s.setDescrip(rs.getString(2));
//				s.setUmedida(rs.getString(3));
//				respuesta.add(s);
//			}

        } catch (SQLException ex) {
            ex.printStackTrace();

            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
                rs = null;
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                }
                st = null;
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
                con = null;
            }
        }
        return respuesta;

    }
    /*este es el modelo para la consulta de precios de los productos al darles click al lapicito en xhtml */
       public List<PrecioVar> consultaPrecios( String qcodigo,String IpServidor, String Empresa, String Clave) {
//		String respuesta = " ";
        List<PrecioVar> respuesta = new LinkedList<PrecioVar>();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://" +  IpServidor + ";databaseName=PCINVJes;user=sa;password= " + Clave + ";";
            con = DriverManager.getConnection(url);

            String query = "select a.productoid,a.UMedidaId ,b.Descripcion,a.PrecioVenta as precio    from INVProductoPrecio a inner join " +
                            "INVXTipoPrecio b on a.EmpresaId = b.EmpresaId and a.TipoPrecioId = b.TipoPrecioId  " +
                            "where a.Empresaid = " + Empresa +  " and  a.ProductoId = ?  ";
            System.out.println("el query es : " + query);
            st = con.prepareStatement(query); 
            st.setString(1, qcodigo); /*esta linea la utilizamos para no poner escrito el parametro sino que cada signo de interrogacion es un parametro y se va a llenar con la variable que mandamos desde Bean*/
            rs = st.executeQuery();
            while (rs.next()) {
//                               String Prueba = rs.getString(1);
                PrecioVar s = new PrecioVar();
                s.setCodigo(quitaNulo(rs.getString(1)));
                s.setUmedidaid(quitaNulo(rs.getString(2)));
                s.setDescripcion(quitaNulo(rs.getString(3)));
                s.setPrecio(quitaNulo(rs.getString(4)));
                respuesta.add(s);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
                rs = null;
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                }
                st = null;
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
                con = null;
            }
        }

        return respuesta;

    }        
/*este es el modelo para la consulta del detalle de la orden de compra*/        
    /*este es el modelo para la consulta de precios de los productos al darles click al lapicito en xhtml */
       public List<ProductosDetOc> ListaDetOc( String qcodigo,String IpServidor, String Empresa, String Clave) {
//		String respuesta = " ";
        List<ProductosDetOc> respuesta = new LinkedList<ProductosDetOc>();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://" +  IpServidor + ";databaseName=PCINVJes;user=sa;password= " + Clave + ";";
            con = DriverManager.getConnection(url);

            String query = "select productoid,Descripcion,DescUMedida,AfectoIva,Precio,Cantidad,CantidadBono,Descuento1," +
                    "Descuento2,Descuento3,CobraIvaBon,ACostoIvaBon,BonoDocumento,BonoEfectivo,CostoConBon,SubTDesc1," + 
                    "SubTDesc2,SubTDesc3,CostoConIvaBon,TotalLineaConIva,TotalSinIva,TotalLineaSinIva " +
                    " from COMPreOrdenDet where Empresaid = " + Empresa + " and PreOrdenId = ?";
            System.out.println("el query es : " + query);
            st = con.prepareStatement(query); 
            st.setString(1, qcodigo); /*esta linea la utilizamos para no poner escrito el parametro sino que cada signo de interrogacion es un parametro y se va a llenar con la variable que mandamos desde Bean*/
            rs = st.executeQuery();
            while (rs.next()) {
//                               String Prueba = rs.getString(1);
                 ProductosDetOc s = new ProductosDetOc();
               
                s.setProductoid(quitaNulo(rs.getString(1)));
                s.setDescripcion(quitaNulo(rs.getString(2)));
                s.setDescUMedida(quitaNulo(rs.getString(3)));
                s.setAfectoIva(quitaNulo(rs.getString(4)));
                s.setPrecio(rs.getDouble(5));
                s.setCantidad(rs.getDouble(6));
                s.setCantidadBono(rs.getDouble(7));
                s.setDescuento1(rs.getDouble(8));
                s.setDescuento2(rs.getDouble(9));
                s.setDescuento3(rs.getDouble(10));
                s.setCobraIvaBon(rs.getDouble(11));
                s.setAcostoIvaBon(rs.getDouble(12));
                s.setBonoDocumento(rs.getDouble(13));
                s.setBonoEfectivo(rs.getDouble(14));                
                s.setCostoConBon(rs.getDouble(15));
                s.setSubTDesc1(rs.getDouble(16));
                s.setSubTDesc2(rs.getDouble(17));
                s.setSubTDesc3(rs.getDouble(18));
                s.setCostoConIvaBon(rs.getDouble(19));
                s.setTotalLineaConIva(rs.getDouble(20));
                s.setTotalSinIva(rs.getDouble(21));
                s.setTotalLineaSinIva(rs.getDouble(22));                
                respuesta.add(s);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
                rs = null;
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                }
                st = null;
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
                con = null;
            }
        }

        return respuesta;

    }                
       
       
       
       
       
       
       
       
/*este es el modelo para la consulta de Existencias de los productos al darles click al lapicito en xhtml */

        public List<ProductosExi> consultaExist( String qcodigo,String IpServidor, String Empresa, String Clave) {
//		String respuesta = " ";
        List<ProductosExi> respuesta = new LinkedList<ProductosExi>();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://" +  IpServidor + ";databaseName=PCINVJes;user=sa;password= " + Clave + ";";
            con = DriverManager.getConnection(url);

            String query = "select productoid,bodegaid,DescUMedidaId,TotalEntradas,TotalSalidas,Reserva,SaldoActual " +
                            " from INVProductoBodega   " +
                            " where Empresaid = " + Empresa +  " and  ProductoId = ?  ";
            System.out.println("el query es : " + query);
            st = con.prepareStatement(query); 
            st.setString(1, qcodigo); /*esta linea la utilizamos para no poner escrito el parametro sino que cada signo de interrogacion es un parametro y se va a llenar con la variable que mandamos desde Bean*/
            rs = st.executeQuery();
            while (rs.next()) {
//                               String Prueba = rs.getString(1);
                ProductosExi s = new ProductosExi();
                s.setCodigo(quitaNulo(rs.getString(1)));
                s.setBodegaId(quitaNulo(rs.getString(2)));
                s.setDescUmedidaId(quitaNulo(rs.getString(3)));
                s.setTotEntradas(quitaNulo(rs.getString(4)));
                s.setTotSalidas(quitaNulo(rs.getString(5)));
                s.setReserva(quitaNulo(rs.getString(6)));
                s.setSaldoActual(quitaNulo(rs.getString(7)));
                respuesta.add(s);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
                rs = null;
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                }
                st = null;
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
                con = null;
            }
        }        
//Fin de modelo de consulta existencicas        
        
        
        
        return respuesta;

    }
   
  /*este es el modelo para llenar el Dashboard de vendedores  */

        public List<VentasxVende> consultaVtas( String qcodigo,String IpServidor, String Empresa, String Clave) {
//		String respuesta = " ";
        List<VentasxVende> respuesta = new LinkedList<VentasxVende>();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://" +  IpServidor + ";databaseName=PCINVJes;user=sa;password= " + Clave + ";";
            con = DriverManager.getConnection(url);

            String query = "select Ano,Vendedorid,Nombre,Total " +
                            " from INVRepWEBVentasVendedorAnual   " +
                            " where  Empresaid = " + Empresa ;
            System.out.println("el query es : " + query);
            st = con.prepareStatement(query); 
            /*st.setString(1, qcodigo);*/ /*esta linea la utilizamos para no poner escrito el parametro sino que cada signo de interrogacion es un parametro y se va a llenar con la variable que mandamos desde Bean*/
            rs = st.executeQuery();
            while (rs.next()) {
//                               String Prueba = rs.getString(1);
                VentasxVende s = new VentasxVende();
                s.setAno(quitaNulo(rs.getString(1)));
                s.setVendedor(quitaNulo(rs.getString(2)));
                s.setNombre(quitaNulo(rs.getString(3)));
                s.setTotal(rs.getDouble(4));
                respuesta.add(s);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
                rs = null;
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                }
                st = null;
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
                con = null;
            }
        }        
//Fin de modelo de consulta existencicas        
        
        
        
        return respuesta;

    }
    
   
   public String autorizaordenc(String codusuario,String IpServidor,String Clave,String codigopro,String Empresa) {
        String respuesta = " ";
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://" + IpServidor + ";databaseName=PCINVJes;user=sa;password= " + Clave + ";";
            con = DriverManager.getConnection(url);

            String query = "create table #userConect(usuarioid varchar(20), Empresaid int, moduloid varchar(10), pantalla varchar(30), Pasadas int )" +
                            " insert #userConect(usuarioid, Empresaid, moduloid, pantalla, Pasadas) " +
                             "values('" + codusuario + "', 1, 'COM', 'SQL', 0) " 
                    + " Update COMPreOrden set autorizado = 1 where  EmpresaId = " + Empresa + " and PreOrdenId = '" + codigopro + "'";

            st = con.prepareStatement(query);
            rs = st.executeQuery();
//            if (rs.next()) {
//                qusuario = rs.getString(1);
//                respuesta = "True";
//            }
//			while (rs.next()) {
////                               String Prueba = rs.getString(1);
//				ProductosVar s = new ProductosVar();
//				s.setCodigo(rs.getString(1));
//				s.setDescrip(rs.getString(2));
//				s.setUmedida(rs.getString(3));
//				respuesta.add(s);
//			}

        } catch (SQLException ex) {
            ex.printStackTrace();

            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
                rs = null;
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                }
                st = null;
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
                con = null;
            }
        }
        return respuesta;

    }
        
        
        
        
        
}

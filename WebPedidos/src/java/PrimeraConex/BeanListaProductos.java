/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrimeraConex;

import StringConn.ProductosExi;
import StringConn.VentasxVende;
import StringConn.JvConexion;
import StringConn.ListadoDetOc;
import StringConn.PedidoVar;
import StringConn.ProductosVar;
import StringConn.ProductosOc;
import StringConn.PrecioVar;
import StringConn.ProductosDetOc;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.context.RequestContext;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Admin
 */
public class BeanListaProductos {

    /**
     * Creates a new instance of BeanListaProductos
     */
    private String IpServer;
    private String qClave;
    private String ordenco;
    private String nitid;
    private String DescProve;
    private String FechaOc;
    private String Observa;
    private String Comprador;
    private String Marca;
    private String Descripcion;
    private String Sede;
    private String StatusId;
    private double SubTotal;
    private double DescuentoFinCosto;
    private double DescuentoFinNoCosto;
    private double DescuentoSaldos;
    private double MontoDescFinCosto;
    private double MontoDescFinNOCosto;
    private double MontoDescSaldos;
    private double TotalIva;
    private double TotalBono;
    private double MontoBono;
    private double TotalCostoSinBono;
    private double TotalCostoSinIvaSinBono;
    private double TotalSinIva;
    private double Total;
    private double TotalFactura;
    private double TotalFaltantes;
    
    
    
    

    public String getOrdenco() {
        return ordenco;
    }

    public void setOrdenco(String ordenco) {
        this.ordenco = ordenco;
    }
    
    public String getNitid() {
        return nitid;
    }

    public void setNitid(String nitid) {
        this.nitid = nitid;
    }

    public String getDescProve() {
        return DescProve;
    }

    public void setDescProve(String DescProve) {
        this.DescProve = DescProve;
    }

    public String getFechaOc() {
        return FechaOc;
    }

    public void setFechaOc(String FechaOc) {
        this.FechaOc = FechaOc;
    }

    public String getObserva() {
        return Observa;
    }

    public void setObserva(String Observa) {
        this.Observa = Observa;
    }

    public String getComprador() {
        return Comprador;
    }

    public void setComprador(String Comprador) {
        this.Comprador = Comprador;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getSede() {
        return Sede;
    }

    public void setSede(String Sede) {
        this.Sede = Sede;
    }

    public String getStatusId() {
        return StatusId;
    }

    public void setStatusId(String StatusId) {
        this.StatusId = StatusId;
    }

    public double getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(double SubTotal) {
        this.SubTotal = SubTotal;
    }

    public double getDescuentoFinCosto() {
        return DescuentoFinCosto;
    }

    public void setDescuentoFinCosto(double DescuentoFinCosto) {
        this.DescuentoFinCosto = DescuentoFinCosto;
    }

    public double getDescuentoFinNoCosto() {
        return DescuentoFinNoCosto;
    }

    public void setDescuentoFinNoCosto(double DescuentoFinNoCosto) {
        this.DescuentoFinNoCosto = DescuentoFinNoCosto;
    }

    public double getDescuentoSaldos() {
        return DescuentoSaldos;
    }

    public void setDescuentoSaldos(double DescuentoSaldos) {
        this.DescuentoSaldos = DescuentoSaldos;
    }

    public double getMontoDescFinCosto() {
        return MontoDescFinCosto;
    }

    public void setMontoDescFinCosto(double MontoDescFinCosto) {
        this.MontoDescFinCosto = MontoDescFinCosto;
    }

    public double getMontoDescFinNOCosto() {
        return MontoDescFinNOCosto;
    }

    public void setMontoDescFinNOCosto(double MontoDescFinNOCosto) {
        this.MontoDescFinNOCosto = MontoDescFinNOCosto;
    }

    public double getMontoDescSaldos() {
        return MontoDescSaldos;
    }

    public void setMontoDescSaldos(double MontoDescSaldos) {
        this.MontoDescSaldos = MontoDescSaldos;
    }

    public double getTotalIva() {
        return TotalIva;
    }

    public void setTotalIva(double TotalIva) {
        this.TotalIva = TotalIva;
    }

    public double getTotalBono() {
        return TotalBono;
    }

    public void setTotalBono(double TotalBono) {
        this.TotalBono = TotalBono;
    }

    public double getMontoBono() {
        return MontoBono;
    }

    public void setMontoBono(double MontoBono) {
        this.MontoBono = MontoBono;
    }

    public double getTotalCostoSinBono() {
        return TotalCostoSinBono;
    }

    public void setTotalCostoSinBono(double TotalCostoSinBono) {
        this.TotalCostoSinBono = TotalCostoSinBono;
    }

    public double getTotalCostoSinIvaSinBono() {
        return TotalCostoSinIvaSinBono;
    }

    public void setTotalCostoSinIvaSinBono(double TotalCostoSinIvaSinBono) {
        this.TotalCostoSinIvaSinBono = TotalCostoSinIvaSinBono;
    }

    public double getTotalSinIva() {
        return TotalSinIva;
    }

    public void setTotalSinIva(double TotalSinIva) {
        this.TotalSinIva = TotalSinIva;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public double getTotalFactura() {
        return TotalFactura;
    }

    public void setTotalFactura(double TotalFactura) {
        this.TotalFactura = TotalFactura;
    }

    public double getTotalFaltantes() {
        return TotalFaltantes;
    }

    public void setTotalFaltantes(double TotalFaltantes) {
        this.TotalFaltantes = TotalFaltantes;
    }
    
    

    public String getqEmpresa() {
        return qEmpresa;
    }

    public String getqClave() {
        return qClave;
    }

    public void setqClave(String qClave) {
        this.qClave = qClave;
    }

    public void setqEmpresa(String qEmpresa) {
        this.qEmpresa = qEmpresa;
    }
    private String qEmpresa;

    public String getIpServer() {
        return IpServer;
    }

    public void setIpServer(String IpServer) {
        this.IpServer = IpServer;
    }

    private String EmpresSelec;

    public String getEmpresSelec() {
        return EmpresSelec;
    }

    public void setEmpresSelec(String EmpresSelec) {
        this.EmpresSelec = EmpresSelec;
    }

    public BeanListaProductos() {
        FacesContext context = FacesContext.getCurrentInstance(); //estas 4 lineas de codigo me permiten capturar el valor ingresado en el combobox de empresas del Bean BeanAcceso
        BeanAcceso objLogin = (BeanAcceso) context.getExternalContext().getSessionMap().get("beanAcceso");
        System.out.println("El valor es:" + objLogin.getComponentes());
        EmpresSelec = objLogin.getComponentes();  //con estas cuatro lineas el objeto objLogin nos permite acceder a todas las variables que pertenecn
        //al Bean BeanAcceso
        if (EmpresSelec.equals("1")) {
            IpServer = "10.2.0.5";
            qEmpresa = "1";
            qClave = "OEM02panorama";
        } else if (EmpresSelec.equals("2")) {
            IpServer = "10.1.0.4";
            qEmpresa = "9";
            qClave = "OEM02panorama";
        } else if (EmpresSelec.equals("3")) {
            IpServer = "DESKTOP-C5DBUJV";
            qEmpresa = "9";
            qClave = "thinkpad";
        }
    }

    private List<ProductosVar> ListaProd;
    private List<ProductosOc> ListaOc;
    private List<ProductosExi> ListaExis;
    private List<VentasxVende> ListaVtas;
    private ProductosOc selectcompra;

    public ProductosOc getSelectcompra() {
        return selectcompra;
    }

    public void setSelectcompra(ProductosOc selectcompra) {
        this.selectcompra = selectcompra;
        
        System.out.println("la compra es " + selectcompra.getCodigo());
        ListaDet = new LinkedList<ProductosDetOc>();
        System.out.println("Entre al llenado de list");

        if (selectcompra != null) {
            qcodigo = selectcompra.getCodigo();
            System.out.println("El Codigo Es" + qcodigo);
            System.out.println("el nit id es " + selectcompra.getQnitid());
            nitid= selectcompra.getQnitid();
            ordenco = selectcompra.getCodigo();
            DescProve=selectcompra.getqDescProve();
            FechaOc=selectcompra.getqFecha();
            Observa=selectcompra.getqObserva();
            Comprador=selectcompra.getqComprador();
            Marca=selectcompra.getqMarca();
            Descripcion=selectcompra.getqDescripcion();
            Sede = selectcompra.getqSede();
            StatusId=selectcompra.getqStatusId();
            SubTotal=selectcompra.getqSubTotal();
            DescuentoFinCosto=selectcompra.getqDescuentoFinCosto();
            DescuentoFinNoCosto=selectcompra.getqDescuentoFinNoCosto();
            DescuentoSaldos=selectcompra.getqDescuentoSaldos();
            MontoDescFinCosto=selectcompra.getqMontoDescFinCosto();
            MontoDescFinNOCosto=selectcompra.getqMontoDescFinNOCosto();
            MontoDescSaldos=selectcompra.getqMontoDescSaldos();
            TotalIva=selectcompra.getqTotalIva();
            TotalBono=selectcompra.getqTotalBono();
            MontoBono=selectcompra.getqMontoBono();
            TotalCostoSinBono=selectcompra.getqTotalCostoSinBono();
            TotalCostoSinIvaSinBono=selectcompra.getqTotalCostoSinIvaSinBono();
            TotalSinIva=selectcompra.getqTotalSinIva();
            Total=selectcompra.getqTotal();
            TotalFactura=selectcompra.getqTotalFactura();
            TotalFaltantes=selectcompra.getqTotalFaltantes();
            
            
            JvConexion ConsulP = new JvConexion(); /*aqui estamos instanciando la clase que contiene todos los metodos*/

            ListaDet = ConsulP.ListaDetOc(qcodigo, IpServer, qEmpresa, qClave);/*aca estamos llenando el listado con el parametro del codigo que es qcodigo*/
           
            ListadoDetOc.setListaDetoc(ListaDet); /*Aqui estoy llenando la lista global con la lista original*/
                                                  /*del detalle de la orden de compra*/
            
            System.out.println("el tama;o es " + ListaDet.size());
  
            /*Rolex*/
            RequestContext contextoRequest = RequestContext.getCurrentInstance();
            contextoRequest.update("TordenesCom:tDetOrden"); /*primerao va el nombre de la forma y luego el Id de la tabla dentro del dialog de html*/
            contextoRequest.update("TordenesCom:txtordenco");
            contextoRequest.update("TordenesCom:txtnitid");
            contextoRequest.update("TordenesCom:txtdescprove");
            contextoRequest.update("TordenesCom:txtfecha");
            contextoRequest.update("TordenesCom:txtobserva");
            contextoRequest.update("TordenesCom:txtcomprador");
            contextoRequest.update("TordenesCom:txtmarca");
            contextoRequest.update("TordenesCom:txtDescrip");
            contextoRequest.update("TordenesCom:txtSede");
            contextoRequest.update("TordenesCom:txtStatusId");
            contextoRequest.update("TordenesCom:txtSubTotal");
            contextoRequest.update("TordenesCom:txtDescuentoFinCosto");
            contextoRequest.update("TordenesCom:txtDescuentoFinNoCosto");
            contextoRequest.update("TordenesCom:txtDescuentoSaldos");
            contextoRequest.update("TordenesCom:txtMontoDescFinCosto");
            contextoRequest.update("TordenesCom:txtMontoDescFinNoCosto");
            contextoRequest.update("TordenesCom:txtMontoDescSaldos");
            contextoRequest.update("TordenesCom:txtTotalIva");
            contextoRequest.update("TordenesCom:txtTotalBono");
            contextoRequest.update("TordenesCom:txtMontoBono");
            contextoRequest.update("TordenesCom:txtTotalCostoSinBono");
            contextoRequest.update("TordenesCom:txtTotalCostoSinIvaSinBono");
            contextoRequest.update("TordenesCom:txtTotalSinIva");
            contextoRequest.update("TordenesCom:txtTotal");
            contextoRequest.update("TordenesCom:txtTotalFactura");
            contextoRequest.update("TordenesCom:txtTotalFaltantes");
            
            contextoRequest.execute("PF('MuestraDet').show()"); /* MuestraExis aca puse el id del dialogo que voy a usar en xhtml */
            
            
            /*Aqui estamos llamando a la otra pagina donde se va a mostrar el detalle de la orden de compra*/
/*
            try {
                HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
                FacesContext.getCurrentInstance().getExternalContext().redirect("faces/DetalleOc.xhtml");
            } catch (Exception e) {
                  System.out.println("error " + e);
            }
*/
        }

    }

    public List<ProductosOc> getListaOc() {
        return ListaOc;
    }

    public void setListaOc(List<ProductosOc> ListaOc) {
        this.ListaOc = ListaOc;
    }
    private List<PedidoVar> ListaPedido;
    private List<PrecioVar> ListaPrecios;/*esto esta bien */

    private List<ProductosDetOc> ListaDet;
    private String resDescrip;
    private ProductosOc SelecOc; /*aca estoy declarando como un objeto el listado de precios que me explico Diego*/


    private ProductosVar SelecProd; /*aca estoy declarando como un objeto el listado de precios que me explico Diego*/

    private ProductosVar selecExistpro;/*aca estoy declarando como un objeto el listado de precios que me explico Diego*/

    private PrecioVar ConsPre;
    private String qcodigo;
    private String qCodigooc;
    private String qdescripcion;
    private String qmedida;
    private int qcantidad;
    //private PieChartModel model;
    //private String usuarioid ;
    private PieChartModel pieModel;
    private BarChartModel barModel;

    public PieChartModel getPieModel() {
        return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }

    public BarChartModel getBarModel() {
        return barModel;
    }

    public void setBarModel(BarChartModel BarModel) {
        this.barModel = BarModel;
    }

    public List<ProductosExi> getListaExis() {
        return ListaExis;
    }

    public void setListaExis(List<ProductosExi> ListaExis) {
        this.ListaExis = ListaExis;
    }

    public List<VentasxVende> getListaVtas() {
        return ListaVtas;
    }

    public void setListaVtas(List<VentasxVende> ListaVtas) {
        this.ListaVtas = ListaVtas;

    }

    public String getqCodigooc() {
        return qCodigooc;
    }

    public void setqCodigooc(String qCodigooc) {
        this.qCodigooc = qCodigooc;
    }

    public void listar() {
        JvConexion dao;
        List<VentasxVende> lista;
        try {
            dao = new JvConexion();
            lista = dao.consultaVtas(qcodigo, IpServer, qEmpresa, qClave);
            graficar(lista);
        } catch (Exception e) {
        } finally {
        }

    }

    public void listarB() {
        JvConexion dao;
        List<VentasxVende> lista;
        try {
            dao = new JvConexion();
            lista = dao.consultaVtas(qcodigo, IpServer, qEmpresa, qClave);
            graficarb(lista);
        } catch (Exception e) {
        } finally {
        }

    }

    private void graficar(List<VentasxVende> lista) {
        pieModel = new PieChartModel();
        for (VentasxVende pro : lista) {
            pieModel.set(pro.getNombre(), pro.getTotal());
        }
        pieModel.setTitle("Ventas");
        pieModel.setLegendPosition("e");
        pieModel.setFill(false);
        pieModel.setShowDataLabels(true);
        pieModel.setDiameter(500);
    }

    private void graficarb(List<VentasxVende> lista) {
        barModel = new BarChartModel();
        for (VentasxVende pro : lista) {
            ChartSeries serie = new BarChartSeries(); //barModel.set(pro.getNombre(),pro.getTotal());
            serie.setLabel(pro.getNombre());
            serie.set(pro.getVendedor(), pro.getTotal());
            barModel.addSeries(serie);
        }
        barModel.setTitle("Ventas");
        barModel.setLegendPosition("e");
        barModel.setAnimate(true);
        pieModel.setDiameter(500);
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Eventos");
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Cantidad Vendida");
        /*yAxis.setMin(50000);
         yAxis.setMax(500000);*/
    }

    public ProductosVar getSelecExistpro() {
        return selecExistpro;
    }

    public void setSelecExistpro(ProductosVar selecExistpro) {  /*el objeto ProductosVar hace referencia a las columnas del grid inicial*/

        ListaExis = new LinkedList<ProductosExi>();
        this.selecExistpro = selecExistpro;
        if (selecExistpro != null) {
            qcodigo = selecExistpro.getCodigo();
            System.out.println("El Codigo Es" + qcodigo);
            JvConexion ConsulP = new JvConexion(); /*aqui estamos instanciando la clase que contiene todos los metodos*/

            ListaExis = ConsulP.consultaExist(qcodigo, IpServer, qEmpresa, qClave);/*aca estamos llenando el listado con el parametro del codigo que es qcodigo*/

            RequestContext contextoRequest = RequestContext.getCurrentInstance();
            contextoRequest.update("Tproductos:tExiste"); /*este Id es de la tabla dentro del dialog de html*/

            contextoRequest.execute("PF('MuestraExis').show()"); /* MuestraExis aca puse el id del dialogo que voy a usar en xhtml */

        }

    }

    public PrecioVar getConsPre() {
        return ConsPre;
    }

    public void setConsPre(PrecioVar ConsPre) {
        // ListaExis= new LinkedList<ProductosExi>();
        this.ConsPre = ConsPre;
        //      if (ConsPre != null) {
        //          qcodigo = SelecProd.getCodigo();
        //          System.out.println("El Codigo Es" + qcodigo);
        //         JvConexion ConsulP = new JvConexion(); /*aqui estamos instanciando la clase que contiene todos los metodos*/
        //         ListaExis = ConsulP.consultaExist(qcodigo,IpServer,qEmpresa,qClave);/*aca estamos llenando el listado con el parametro del codigo que es qcodigo*/
        //          RequestContext contextoRequest = RequestContext.getCurrentInstance();
        //          contextoRequest.update("Tproductos:tPrecios"); /*este Id es de la tabla dentro del dialog de html*/
        //          contextoRequest.execute("PF('MuestraExis').show()"); /* MuestraPrec aca puse el id del dialogo que voy a usar en xhtml */
        //      }

    }

    public ProductosOc getSelecOc() {
        return SelecOc;
    }

    public void setSelecOc(ProductosOc SelecOc) {
        this.SelecOc = SelecOc;
    }

    public List<PrecioVar> getListaPrecios() {
        return (List<PrecioVar>) ListaPrecios;
    }

    public void setListaPrecios(List<PrecioVar> ListaPrecios) {
        this.ListaPrecios = ListaPrecios;
    }

    public List<ProductosDetOc> getListaDet() {
        return ListaDet;
    }

    public void setListaDet(List<ProductosDetOc> ListaDet) {
        this.ListaDet = ListaDet;
    }

    public List<PedidoVar> getListaPedido() {
        return ListaPedido;
    }

    public void setListaPedido(List<PedidoVar> ListaPedido) {
        this.ListaPedido = ListaPedido;
    }

    @ManagedProperty("#{BeanListaUsuarios}")
    private BeanAcceso bean1;

    public BeanAcceso getBean1() {
        return bean1;
    }

    public void setBean1(BeanAcceso bean1) {
        this.bean1 = bean1;
    }

    public int getQcantidad() {
        return qcantidad;
    }

    public void setQcantidad(int qcantidad) {
        this.qcantidad = qcantidad;
    }

    public String getQdescripcion() {
        return qdescripcion;
    }

    public void setQdescripcion(String qdescripcion) {
        this.qdescripcion = qdescripcion;
    }

    public String getQmedida() {
        return qmedida;
    }

    public void setQmedida(String qmedida) {
        this.qmedida = qmedida;
    }

    public String getQcodigo() {
        return qcodigo;
    }

    public void setQcodigo(String qcodigo) {
        this.qcodigo = qcodigo;
    }

    public ProductosVar getSelecProd() {
        return SelecProd;
    }
    /*copiar este codigo de abajo que es donde esta agarrando los valores para la consulta de precios */

    public void setSelecProd(ProductosVar SelecProd) {
        ListaPrecios = new LinkedList<PrecioVar>();
        this.SelecProd = SelecProd;
        if (SelecProd != null) {
            qcodigo = SelecProd.getCodigo();
            System.out.println("El Codigo Es" + qcodigo);
            JvConexion ConsulP = new JvConexion(); /*aqui estamos instanciando la clase que contiene todos los metodos*/

            ListaPrecios = ConsulP.consultaPrecios(qcodigo, IpServer, qEmpresa, qClave);/*aca estamos llenando el listado con el parametro del codigo que es qcodigo*/

            RequestContext contextoRequest = RequestContext.getCurrentInstance();
            contextoRequest.update("Tproductos:tPrecios"); /*este Id es de la tabla dentro del dialog de html*/

            contextoRequest.execute("PF('MuestraPrec').show()"); /* MuestraPrec aca puse el id del dialogo que voy a usar en xhtml */

        }
    }

    /*
     public void setSelecProd(PrecioVar SelecProd) {
     this.SelecProd = SelecProd;
     if (SelecProd != null) {
     qcodigo = SelecProd.getCodigo();
     RequestContext contextoRequest = RequestContext.getCurrentInstance();
     contextoRequest.update("Tproductos:txtcod");
     }
     }    
     */
    public void grabaprod() {
        FacesContext context = FacesContext.getCurrentInstance();
        BeanAcceso objLogin = (BeanAcceso) context.getExternalContext().getSessionMap().get("beanAcceso");
        System.out.println("el usuario es:" + objLogin.getUsuario());
        String usuario = String.valueOf(objLogin.getUsuario());
        int respuesta = 0;
        JvConexion insertatmp = new JvConexion();
        respuesta = insertatmp.GuardaProducto(usuario, qcodigo, resDescrip, qmedida, qcantidad, IpServer, qClave);
        if (respuesta != 0) {
            System.out.println("Se inserto Correctamente");

            RequestContext contextoRequest = RequestContext.getCurrentInstance();

            contextoRequest.execute("PF('guardacant').hide()");

        } else {
            System.out.println("no pudo insertar producto");
        }

    }

    public String getResDescrip() {
        return resDescrip;
    }

    public void setResDescrip(String resDescrip) {
        this.resDescrip = resDescrip;
    }

    public List<ProductosVar> getListaProd() {
        return ListaProd;
    }

    public void setListaProd(List<ProductosVar> ListaProd) {
        this.ListaProd = ListaProd;
    }
//esete metodo carga los productos en la consulta de productos

    public void cargar() {

        ListaProd = new LinkedList<ProductosVar>();
        JvConexion llama = new JvConexion();
        ListaProd = llama.consultamaestros(resDescrip, IpServer, qEmpresa, qClave);
//        System.out.println("el tammaño de la lista " + ListaProd.size());
    }

    //este metodo va a cargar las ordenes de compra pendientes de autorizar
    public void cargaroc() {

        ListaOc = new LinkedList<ProductosOc>();
        JvConexion llama = new JvConexion();
        ListaOc = llama.consultaoc(resDescrip, IpServer, qEmpresa, qClave);
//        System.out.println("el tammaño de la lista " + ListaProd.size());
    }

    public void regresar() {

        RequestContext contextoRequest = RequestContext.getCurrentInstance();

        contextoRequest.execute("PF('guardacant').hide()");

    }

    public void cargarpedido() {
        FacesContext context = FacesContext.getCurrentInstance();
        BeanAcceso objLogin = (BeanAcceso) context.getExternalContext().getSessionMap().get("beanAcceso");
        System.out.println("el usuario es:" + objLogin.getUsuario());
        String usuario = String.valueOf(objLogin.getUsuario());
        ListaPedido = new LinkedList<PedidoVar>();
        JvConexion llama = new JvConexion();
        ListaPedido = llama.consultapedidos(usuario, IpServer, qClave);
        System.out.println("el tamaño de la lista" + ListaPedido.size());
        RequestContext contextoRequest = RequestContext.getCurrentInstance();
        contextoRequest.update("Tproductos:tpedidos");
        contextoRequest.execute("PF('MuestraPed').show()");

    }

    public void enviaped() {
        FacesContext context = FacesContext.getCurrentInstance();
        BeanAcceso objLogin = (BeanAcceso) context.getExternalContext().getSessionMap().get("beanAcceso");
        String codusuario = String.valueOf(objLogin.getUsuario());
        String respuesta = " ";
        JvConexion insertatmp = new JvConexion();
        respuesta = insertatmp.enviapedido(codusuario, IpServer, qClave);
        if (respuesta != " ") {
            System.out.println("Se inserto Correctamente");

//            RequestContext contextoRequest = RequestContext.getCurrentInstance();
//
//            contextoRequest.execute("PF('guardacant').hide()");
        } else {
            System.out.println("no pudo insertar Pedido");
        }

    }

    public void regresarped() {

        RequestContext contextoRequest = RequestContext.getCurrentInstance();

        contextoRequest.execute("PF('MuestraPed').hide()");/*aca va el nombre del dialogo para regresar */

    }
    /*Este metodo fue creado para regresar al listado principal de productos, cuando consulto un Precio y me muestra los precios*/

    public void regresarPrecios() {

        RequestContext contextoRequest = RequestContext.getCurrentInstance();

        contextoRequest.execute("PF('MuestraPrec').hide()"); /*Aca va el nombre del dialogo para que funcione*/

    }
    /*Este metodo lo hicimos con Dieguito para regresar de la consulta de productos a la pagina index*/

    public void regresarinicio() {
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            FacesContext.getCurrentInstance().getExternalContext().redirect("faces/MenuPrin.xhtml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*Este metodo fue creado para regresar al listado principal de Existencias de  productos, cuando consulto un Precio y me muestra los precios*/
    public void regresarExistencias() {

        RequestContext contextoRequest = RequestContext.getCurrentInstance();

        contextoRequest.execute("PF('MuestraExis').hide()"); /*Aca va el nombre del dialogo para que funcione*/

    }
    public void regresarOrden() {
 
        RequestContext contextoRequest = RequestContext.getCurrentInstance();

        contextoRequest.execute("PF('MuestraDet').hide()"); /*Aca va el nombre del dialogo para que funcione*/

        
        
        /* con este codigo regreso a otra pagina web        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            FacesContext.getCurrentInstance().getExternalContext().redirect("faces/autorizaoc.xhtml");
        } catch (Exception e) {
            e.printStackTrace();
        } */
    }

    public void autorzaorden() {
        FacesContext context = FacesContext.getCurrentInstance();
        BeanAcceso objLogin = (BeanAcceso) context.getExternalContext().getSessionMap().get("beanAcceso");
        String codusuario = String.valueOf(objLogin.getUsuario());
        ordenco =  selectcompra.getCodigo();
        
        String respuesta = " ";
        JvConexion insertatmp = new JvConexion();
        respuesta = insertatmp.autorizaordenc(codusuario, IpServer, qClave,ordenco,qEmpresa);
    //    if (respuesta != " ") {
            System.out.println("Se inserto Correctamente");
            RequestContext contextoRequest = RequestContext.getCurrentInstance();
            contextoRequest.execute("PF('MuestraDet').hide()");
            //contextoRequest.execute("PF('TordenesCom').update()"); 
            contextoRequest.execute("PF(TordenesCom').Update()"); /*este Id es de la tabla dentro del dialog de html*/



            
            

//    } else {
    //        System.out.println("no pudo insertar Pedido");
    //    }

    }
    
    
    
}

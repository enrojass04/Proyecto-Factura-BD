package poli.controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import poli.model.Almacen;
import poli.model.Cajero;
import poli.model.Conexion;
import poli.model.Consumidor;
import poli.model.Pago;
import poli.model.Producto;
import poli.tablas.Registros;


public class Controller implements Initializable{

	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	int index = -1;
	
	@FXML
    private Tab usuario;
    @FXML
    private Tab almacen;
    @FXML
    private Tab producto;
    
    ////////  CONSUMIDOR  ////////
    @FXML
    private TableView<Consumidor> tablaConsumidor;
    @FXML
    private TableColumn<Consumidor, String> colDireccion;
    @FXML
    private TableColumn<Consumidor, Integer> colId;
    @FXML
    private TableColumn<Consumidor, String> colNombre;
    @FXML
    private TableColumn<Consumidor, String> colNumeroTarjeta;
    @FXML
    private TableColumn<Consumidor, String> colPuntos;
    @FXML
    private TableColumn<Consumidor, String> colTelefono;


    @FXML
    private TextField nombreUsuario;
    @FXML
    private TextField numeroTarjetaUsuario;
    @FXML
    private TextField puntosUsuario;
    @FXML
    private TextField idUsuario;  
    @FXML
    private TextField direccionUsuario;
    @FXML
    private TextField numeroUsuario;
    
    ////////  CAJERO  ////////
    @FXML
    private TableView<Cajero> tablaCajero;
    @FXML
    private TableColumn<Cajero, String> colCajero1;
    @FXML
    private TableColumn<Cajero, String> colCajero2;
    
    @FXML
    private TextField idCajero;
    @FXML
    private TextField nombreCajero;
    
    ////////  ALMACEN  ////////
    @FXML
    private TableView<Almacen> tablaAlmacen;
    @FXML
    private TableColumn<Almacen, String> colNit;
    @FXML
    private TableColumn<Almacen, String> colNombreAlmacen;
    @FXML
    private TableColumn<Almacen, String> colNombreGerente;
    @FXML
    private TableColumn<Almacen, String> colSucursal;
    @FXML
    private TableColumn<Almacen, String> coldireccionAlmacen;
    @FXML
    private TableColumn<Almacen, String> colTelefonoAlmacen;   
    
    @FXML
    private TextField nit;
    @FXML
    private TextField nombreAlmacen;
    @FXML
    private TextField sucursal;
    @FXML
    private TextField direccionAlmacen;
    @FXML
    private TextField nombreGerente;
    @FXML
    private TextField telefonoAlmacen;
    
    ////////  PAGO  ////////    
    @FXML
    private TableView<Pago> tablaPago;
    @FXML
    private TableColumn<Pago, String> colIdPago;
    @FXML
    private TableColumn<Pago, String> colTipoPago;
    
    @FXML
    private TextField idPago;
    @FXML
    private TextField tipoPago;
    @FXML
    private RadioButton rbCheque;
    @FXML
    private RadioButton rbEfectivo;
    @FXML
    private RadioButton rbTarjeta;   
    
    ////////  PRODUCTO  ////////
    @FXML
    private TableView<Producto> tablaProducto;
    @FXML
    private TableColumn<Producto, String> colTipoProducto;
    @FXML
    private TableColumn<Producto, String> colCodigo;
    @FXML
    private TableColumn<Producto, String> colNombreProducto;
    @FXML
    private TableColumn<Producto, Double> colPrecio;
    
    @FXML
    private TextField tipoProducto;
    @FXML
    private TextField codigo;
    @FXML
    private TextField nombreProducto;
    @FXML
    private TextField precio;
    
    //////TRIGGER
    @FXML
    private TableView<Registros> tablaRegistros;
    @FXML
    private TableColumn<Registros, String> colregistros1;
    @FXML
    private TableColumn<Registros, Integer> colregistros2;
    @FXML
    private TableColumn<Registros, String> colregistros3;
    
    //FACTURA  
    @FXML
    private TableView<Producto> TablaPF;
    @FXML
    private ComboBox<Consumidor> cmbConsumidores;
    @FXML
    private ComboBox<Almacen> cmbAlmacenes;
    @FXML
    private ComboBox<Pago> cmbPagos;
    @FXML
    private ComboBox<Cajero> cmbCajero;
    @FXML
    private ComboBox<Producto> cmbProductos;
    @FXML
    private TableColumn<Producto, String> colC1;
    @FXML
    private TableColumn<Producto, String> colC2;
    @FXML
    private TableColumn<Producto, String> colC3;
    @FXML
    private TableColumn<Producto, Double> colC4;
    
    // Coleccion
 	private ObservableList<Consumidor> listaConsumidor;
 	private ObservableList<Cajero> listaCajero;
 	private ObservableList<Almacen> listaAlmacen;
 	private ObservableList<Pago> listaPago;
 	private ObservableList<Producto> listaProducto;
 	private ObservableList<Registros> listaRegistros;
 	
	//////// Selecccion de datos Consumidor ///////
	@FXML
	void getSelected1(MouseEvent event) {
		index = tablaConsumidor.getSelectionModel().getSelectedIndex();
		if (index <= -1) {

			return;
		}
		nombreUsuario.setText(colNombre.getCellData(index).toString());
		numeroTarjetaUsuario.setText(colNumeroTarjeta.getCellData(index).toString());
		puntosUsuario.setText(colPuntos.getCellData(index).toString());
		idUsuario.setText(colId.getCellData(index).toString());
		direccionUsuario.setText(colDireccion.getCellData(index).toString());
		numeroUsuario.setText(colTelefono.getCellData(index).toString());
	}
	
	////////Actualizar de datos Tabla Consumidor /////// 	
 	public void actualizarTablaConsumidor(){
        colNombre.setCellValueFactory(new PropertyValueFactory<Consumidor,String>("nombreUsuario"));
        colNumeroTarjeta.setCellValueFactory(new PropertyValueFactory<Consumidor,String>("numeroTarjetaUsuario"));
        colPuntos.setCellValueFactory(new PropertyValueFactory<Consumidor,String>("puntosUsuario"));
        colId.setCellValueFactory(new PropertyValueFactory<Consumidor,Integer>("idUsuario"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<Consumidor,String>("direccionUsuario"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<Consumidor,String>("numeroUsuario"));
        
        listaConsumidor = Conexion.getDataConsumidor();
        tablaConsumidor.setItems(listaConsumidor);
    }
 	
 	////////Selecccion de datos Cajero ///////
 	@FXML
	void getSelected2(MouseEvent event) {
 		index = tablaCajero.getSelectionModel().getSelectedIndex();
		if (index <= -1) {

			return;
		}
		idCajero.setText(colCajero1.getCellData(index).toString());
		nombreCajero.setText(colCajero2.getCellData(index).toString());
 	}
 	
	////////Actualizar de datos Tabla Consumidor /////// 	
 	public void actualizarTablaCajero(){
 		colCajero1.setCellValueFactory(new PropertyValueFactory<Cajero,String>("idCajero"));
 		colCajero2.setCellValueFactory(new PropertyValueFactory<Cajero,String>("nombreCajero"));
        
        listaCajero = Conexion.getDataCajero();
        tablaCajero.setItems(listaCajero);
 	}
 	
	////////Selecccion de datos Almacen ///////
	@FXML
	void getSelected3(MouseEvent event) {
		index = tablaAlmacen.getSelectionModel().getSelectedIndex();
		if (index <= -1) {

			return;
		}
		nit.setText(colNit.getCellData(index).toString());
		nombreAlmacen.setText(colNombreAlmacen.getCellData(index).toString());
		sucursal.setText(colSucursal.getCellData(index).toString());
		direccionAlmacen.setText(coldireccionAlmacen.getCellData(index).toString());
		nombreGerente.setText(colNombreGerente.getCellData(index).toString());
		telefonoAlmacen.setText(colTelefonoAlmacen.getCellData(index).toString());
	}
 	
	////////Actualizar de datos Tabla Almacen /////// 	
		public void actualizarTablaAlmacen(){
	    colNit.setCellValueFactory(new PropertyValueFactory<Almacen,String>("nit"));
	    colNombreAlmacen.setCellValueFactory(new PropertyValueFactory<Almacen,String>("nombreAlmacen"));
	    colSucursal.setCellValueFactory(new PropertyValueFactory<Almacen,String>("sucursal"));
	    coldireccionAlmacen.setCellValueFactory(new PropertyValueFactory<Almacen,String>("direccionAlmacen"));
	    colNombreGerente.setCellValueFactory(new PropertyValueFactory<Almacen,String>("nombreGerente"));
	    colTelefonoAlmacen.setCellValueFactory(new PropertyValueFactory<Almacen,String>("telefonoAlmacen"));
	    
	    listaAlmacen = Conexion.getDataAlmacen();
	    tablaAlmacen.setItems(listaAlmacen);
	}
		
		////////Selecccion de datos Pago ///////
	@FXML
	void getSelected4(MouseEvent event) {
		
		index = tablaPago.getSelectionModel().getSelectedIndex();
		if (index <= -1) {

			return;
		}
		idPago.setText(colIdPago.getCellData(index).toString());
		tipoPago.setText(colTipoPago.getCellData(index).toString());
	}
	
	////////Actualizar de datos Tabla Pago /////// 	
	public void actualizarTablaPago(){
		colIdPago.setCellValueFactory(new PropertyValueFactory<Pago,String>("idPago"));
	    colTipoPago.setCellValueFactory(new PropertyValueFactory<Pago,String>("tipoPago"));
		listaPago = Conexion.getDataPago();
	    tablaPago.setItems(listaPago);
				
	}	
 	
	//////// Selecccion de datos Productos ///////
	@FXML
	void getSelected5(MouseEvent event) {
		index = tablaProducto.getSelectionModel().getSelectedIndex();
		if (index <= -1) {

			return;
		}
		tipoProducto.setText(colTipoProducto.getCellData(index).toString());
		codigo.setText(colCodigo.getCellData(index).toString());
		nombreProducto.setText(colNombreProducto.getCellData(index).toString());
		precio.setText(colPrecio.getCellData(index).toString());
	}
	
	////////Actualizar de datos Tabla Producto /////// 	
 	public void actualizarTablaProducto(){
        colTipoProducto.setCellValueFactory(new PropertyValueFactory<Producto,String>("tipoProducto"));
        colCodigo.setCellValueFactory(new PropertyValueFactory<Producto,String>("codigo"));
        colNombreProducto.setCellValueFactory(new PropertyValueFactory<Producto,String>("nombreProducto"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<Producto,Double>("precio"));
        
        listaProducto = Conexion.getDataProducto();
        tablaProducto.setItems(listaProducto);
    }
 	
 	
 	////////Actualizar de datos Tabla Registros /////// 	
	public void actualizarTablaRegistros() {
		
		colregistros1.setCellValueFactory(new PropertyValueFactory<Registros, String>("nombre"));
		colregistros2.setCellValueFactory(new PropertyValueFactory<Registros, Integer>("id"));
		colregistros3.setCellValueFactory(new PropertyValueFactory<Registros, String>("date"));

		listaRegistros = Conexion.getDataRegistros();
		tablaRegistros.setItems(listaRegistros);
	}
	
	////////Actualizar de datos Tabla Productos en Factura /////// 	
	public void actualizarTablaPF() {

	}
		
		/**   QUERYS SQL   */
 	
 	
 	//Insertar
 	public void guardarRegistroConsumidor (){    
 		conn = Conexion.ConnectarDb();
        String sql = "INSERT INTO vistaconsumidor ("
				+ "nombreUsuario, numeroTarjetaUsuario, puntosUsuario, idUsuario, direccionUsuario, numeroUsuario) VALUES"
				+ " (?, ?, ?, ?, ?, ?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, nombreUsuario.getText());
            pst.setString(2, numeroTarjetaUsuario.getText());
            pst.setString(3, puntosUsuario.getText());
            pst.setString(4, idUsuario.getText());
            pst.setString(5, direccionUsuario.getText());
            pst.setString(6, numeroUsuario.getText());
            pst.execute();
            
            mensajeAdd();		
			actualizarTablaConsumidor();
			actualizarTablaRegistros();
            
        } catch (Exception e) {
        	mensajeError();
        }
        
 	}
 	
 	public void guardarRegistroCajero (){ 
 		
 	}
 	
 	public void guardarRegistroAlmacen (){    
        conn = Conexion.ConnectarDb();
        String sql = "INSERT INTO almacen ("
				+ "nit, nombreAlmacen, sucursal, direccionAlmacen, nombreGerente, telefonoAlmacen) VALUES"
				+ " (?, ?, ?, ?, ?, ?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, nit.getText());
            pst.setString(2, nombreAlmacen.getText());
            pst.setString(3, sucursal.getText());
            pst.setString(4, direccionAlmacen.getText());
            pst.setString(5, nombreGerente.getText());
            pst.setString(6, telefonoAlmacen.getText());
            pst.execute();
            
            mensajeAdd();		
			actualizarTablaAlmacen();
            
        } catch (Exception e) {
        	mensajeError();
        }
        
 	}
 	//>>>>>>>>>>>>>>>>>>>>
 	public void guardarRegistroPago (){ 
 		 conn = Conexion.ConnectarDb();
         String sql = "INSERT INTO vistapago ("
 				+ "idPago, tipoPago) VALUES"
 				+ " (?, ?)";
         try {
             pst = conn.prepareStatement(sql);
             pst.setString(1, idPago.getText());
             pst.setString(2, tipoPago.getText());
             pst.execute();
             
             mensajeAdd();		
 			 actualizarTablaPago();
             
         } catch (Exception e) {
         	mensajeError();
         }
 	}
 	
 	public void guardarRegistroProducto (){ 
 		 conn = Conexion.ConnectarDb();
         String sql = "INSERT INTO vistaproducto ("
 				+ "tipoProducto, codigo, nombreProducto, precio) VALUES"
 				+ " (?, ?, ?, ?)";
         try {
             pst = conn.prepareStatement(sql);
             pst.setString(1, tipoProducto.getText());
             pst.setString(2, codigo.getText());
             pst.setString(3, nombreProducto.getText());
             pst.setString(4, precio.getText());
             pst.execute();
             
             mensajeAdd();		
 			 actualizarTablaProducto();
             
         } catch (Exception e) {
         	mensajeError();
         }
 	}
 	//Update
 	public void actualizarRegistroConsumidor() {
		try {
            conn = Conexion.ConnectarDb();
            		String value1 = nombreUsuario.getText();
            		String value2 = numeroTarjetaUsuario.getText();
            		String value3 = puntosUsuario.getText();
            		String value4 = idUsuario.getText();
            		String value5 = direccionUsuario.getText();
            		String value6 = numeroUsuario.getText();

            String sql = "update vistaconsumidor set nombreUsuario= '"+value1+"',numeroTarjetaUsuario= '"+value2+"',puntosUsuario= '"+
                    value3+"',idUsuario= '"+value4+"',direccionUsuario= '"+value5+"',numeroUsuario= '"+value6+"' where idUsuario='"+value4+"' ";
            pst= conn.prepareStatement(sql);
            pst.execute();
            mensajeUpdate();	
			actualizarTablaConsumidor();
            
        } catch (Exception e) {
        	mensajeError(); 
        }
    }
 	
 	public void actualizarRegistroCajero() {
 		
 	}
 	
 	public void actualizarRegistroAlmacen() {
		try {
            conn = Conexion.ConnectarDb();
            		String value1 = nit.getText();
            		String value2 = nombreAlmacen.getText();
            		String value3 = sucursal.getText();
            		String value4 = direccionAlmacen.getText();
            		String value5 = nombreGerente.getText();
            		String value6 = telefonoAlmacen.getText();

            String sql = "update almacen set nit= '"+value1+"',nombreAlmacen= '"+value2+"',sucursal= '"+
                    value3+"',direccionAlmacen= '"+value4+"',nombreGerente= '"+value5+"',telefonoAlmacen= '"+value6+"' where nit='"+value1+"' ";
            pst= conn.prepareStatement(sql);
            pst.execute();
            mensajeUpdate();
			actualizarTablaAlmacen();
            
        } catch (Exception e) {
        	mensajeError();
        }
    

	}
 	//>>>>>>>>>>>>>>>>>>>>
 	public void actualizarRegistroPago() {
 		try {
            conn = Conexion.ConnectarDb();
            		String value1 = idPago.getText();
            		String value2 = tipoPago.getText();
            String sql = "update vistapago set idPago= '"+value1+"',tipoPago= '"+value2+"' where idPago='"+value1+"' ";
            pst= conn.prepareStatement(sql);
            pst.execute();
            mensajeUpdate();
			actualizarTablaPago();
            
        } catch (Exception e) {
        	mensajeError();
        } 		
 	}
 	
 	public void actualizarRegistroProducto (){ 
 		try {
            conn = Conexion.ConnectarDb();
            		String value1 = tipoProducto.getText();
            		String value2 = codigo.getText();
            		String value3 = nombreProducto.getText();
            		String value4 = precio.getText();

            String sql = "update vistaproducto set tipoProducto= '"+value1+"',codigo= '"+value2+"',nombreProducto= '"+
                    value3+"',precio= '"+value4+"'where codigo='"+value2+"' ";
            pst= conn.prepareStatement(sql);
            pst.execute();
            mensajeUpdate();
			actualizarTablaProducto();
            
        } catch (Exception e) {
        	mensajeError();
        }
 	}
 	
 
 	//Delete
 	public void eliminarRegistroConsumidor() {
 		
	}
	
 	public void eliminarRegistroAlmacen() {
		
	}
 	//>>>>>>>>>>>>>>>>>>>>
 	public void eliminarRegistroPago() {
 		
 	}
		
	public void limpiar() {
		//Consumidor
    	nombreUsuario.setText(null);
    	numeroTarjetaUsuario.setText(null);
    	puntosUsuario.setText(null);
    	direccionUsuario.setText(null);
    	numeroUsuario.setText(null);
    	idUsuario.setText(null);
    	//Cajero
    	idCajero.setText(null);
    	nombreCajero.setText(null);
    	//Almacen
    	nit.setText(null);
    	nombreAlmacen.setText(null);
    	sucursal.setText(null);
    	direccionAlmacen.setText(null);
    	nombreGerente.setText(null);
    	telefonoAlmacen.setText(null);
    	//Pago
    	idPago.setText(null);
    	tipoPago.setText(null);
    	//Producto
    	tipoProducto.setText(null);
    	codigo.setText(null);
    	nombreProducto.setText(null);
    	precio.setText(null);
	}
	
	@FXML
	void mostrarTablaConsumidor(ActionEvent event) {
		
		}
	
    @FXML
    void agregarProductoEnFactura(ActionEvent event) {
    	conn = Conexion.ConnectarDb();
    	try {
            String sql = "select p.nombre form vistaproducto p where p.codigo = ?";
            pst= conn.prepareStatement(sql);
            pst.execute();
            mensajeUpdate();
			actualizarTablaPF();
            
        } catch (Exception e) {
        	mensajeError();
        }

    }
		


	@Override
	public void initialize(URL url, ResourceBundle rb) {
		actualizarTablaConsumidor();
		actualizarTablaAlmacen();
		actualizarTablaPago();
		actualizarTablaProducto();
		actualizarTablaCajero();
		actualizarTablaPF();
		actualizarTablaRegistros();
		
		
		cmbConsumidores.setItems(listaConsumidor);
		cmbAlmacenes.setItems(listaAlmacen);
		cmbPagos.setItems(listaPago);
		cmbCajero.setItems(listaCajero);
		cmbProductos.setItems(listaProducto);
	}
	
	public void mensajeAdd(){
		Alert mensaje = new Alert(AlertType.INFORMATION);
		mensaje.setTitle("Resultado");
		mensaje.setHeaderText("Dato registrado");
		mensaje.show();	
	}
	
	public void mensajeUpdate(){
		Alert mensaje = new Alert(AlertType.INFORMATION);
		mensaje.setTitle("Resultado");
		mensaje.setHeaderText("Dato actualizado");
		mensaje.show();	
	}
	
	public void mensajeDelete(){
		Alert mensaje = new Alert(AlertType.INFORMATION);
		mensaje.setTitle("Resultado");
		mensaje.setHeaderText("Dato eliminado");
		mensaje.show();	
	}
	
	public void mensajeError(){
		Alert mensaje = new Alert(AlertType.INFORMATION);
		mensaje.setTitle("Resultado");
		mensaje.setHeaderText("Error al realizar cambio");
		mensaje.show();	
	}
	
}
    

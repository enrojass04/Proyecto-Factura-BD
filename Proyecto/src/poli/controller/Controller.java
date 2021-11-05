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
import poli.model.Conexion;
import poli.model.Consumidor;
import poli.model.Pago;


public class Controller implements Initializable{

	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	@FXML
    private Tab usuario;
    @FXML
    private Tab almacen;
    @FXML
    private Tab pago;
    
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
    private ComboBox<String> tipoPago2;
    
    
 // Coleccion
 	private ObservableList<Consumidor> listaConsumidor;
 	private ObservableList<Almacen> listaAlmacen;
 	private ObservableList<Pago> listaPago;
 	
	//////// Selecccion de datos Consumidor ///////
	@FXML
	void getSelected1(MouseEvent event) {
		int index = -1;
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
 	
	////////Selecccion de datos Almacen ///////
	@FXML
	void getSelected2(MouseEvent event) {
		int index = -1;
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
		
		////////Selecccion de datos Consumidor ///////
	@FXML
	void getSelected3(MouseEvent event) {
		int index = -1;
		index = tablaPago.getSelectionModel().getSelectedIndex();
		if (index <= -1) {

			return;
		}
		idPago.setText(colIdPago.getCellData(index).toString());
		tipoPago.setText(colTipoPago.getCellData(index).toString());
	}
	////////Actualizar de datos Tabla Consumidor /////// 	
	public void actualizarTablaPago(){
		colIdPago.setCellValueFactory(new PropertyValueFactory<Pago,String>("idPago"));
	    colTipoPago.setCellValueFactory(new PropertyValueFactory<Pago,String>("tipoPago"));
		//tipoPago.setValue(new PropertyValueFactory<>("tipoPago"));
	    
	    listaPago = Conexion.getDataPago();
	    tablaPago.setItems(listaPago);
				
	}
		
		////////////   QUERYS SQL   ////////////
 	
 	
 	
 	public void guardarRegistroConsumidor (){    
 		conn = Conexion.ConnectarDb();
        String sql = "INSERT INTO consumidor ("
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
            
            Alert mensaje = new Alert(AlertType.INFORMATION);
			mensaje.setTitle("Resultado");
			mensaje.setHeaderText("Add Consumidor");
			mensaje.show();			
			actualizarTablaConsumidor();
            
        } catch (Exception e) {
        	Alert mensaje = new Alert(AlertType.INFORMATION);
			mensaje.setTitle("Resultado");
			mensaje.setHeaderText("Error Add");
			mensaje.show();
        }
        
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
            
            Alert mensaje = new Alert(AlertType.INFORMATION);
			mensaje.setTitle("Resultado");
			mensaje.setHeaderText("Add Almacen");
			mensaje.show();			
			actualizarTablaAlmacen();
            
        } catch (Exception e) {
        	Alert mensaje = new Alert(AlertType.INFORMATION);
			mensaje.setTitle("Resultado");
			mensaje.setHeaderText("Error Add");
			mensaje.show();
        }
        
 	}
 	
 	public void guardarRegistroPago (){ 
 		
 	}
 	
 	
 	public void actualizarRegistroConsumidor() {
		try {
            conn = Conexion.ConnectarDb();
            		String value1 = nombreUsuario.getText();
            		String value2 = numeroTarjetaUsuario.getText();
            		String value3 = puntosUsuario.getText();
            		String value4 = idUsuario.getText();
            		String value5 = direccionUsuario.getText();
            		String value6 = numeroUsuario.getText();

            String sql = "update consumidor set nombreUsuario= '"+value1+"',numeroTarjetaUsuario= '"+value2+"',puntosUsuario= '"+
                    value3+"',idUsuario= '"+value4+"',direccionUsuario= '"+value5+"',numeroUsuario= '"+value6+"' where idUsuario='"+value4+"' ";
            pst= conn.prepareStatement(sql);
            pst.execute();
            Alert mensaje = new Alert(AlertType.INFORMATION);
			mensaje.setTitle("Resultado");
			mensaje.setHeaderText("Consumidor Actualizado");
			mensaje.show();
			actualizarTablaConsumidor();
            
        } catch (Exception e) {
        	Alert mensaje = new Alert(AlertType.INFORMATION);
			mensaje.setTitle("Resultado");
			mensaje.setHeaderText("Error Update");
			mensaje.show();  
        }
        

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
            Alert mensaje = new Alert(AlertType.INFORMATION);
			mensaje.setTitle("Resultado");
			mensaje.setHeaderText("Almacen Actualizado");
			mensaje.show();
			actualizarTablaAlmacen();
            
        } catch (Exception e) {
        	Alert mensaje = new Alert(AlertType.INFORMATION);
			mensaje.setTitle("Resultado");
			mensaje.setHeaderText("Error Update");
			mensaje.show();  
        }
    

	}
 	
 	public void actualizarRegistroPago() {
 		
 	}

 	public void eliminarRegistroConsumidor() {
 		conn = Conexion.ConnectarDb();
		String sql = "delete from consumidor where idUsuario = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, idUsuario.getText());
			pst.execute();
			Alert mensaje = new Alert(AlertType.INFORMATION);
			mensaje.setTitle("Resultado");
			mensaje.setHeaderText("Delete");
			mensaje.show();
			actualizarTablaConsumidor();
			
		} catch (Exception e) {
			Alert mensaje = new Alert(AlertType.INFORMATION);
			mensaje.setTitle("Resultado");
			mensaje.setHeaderText("Error");
			mensaje.show();
		}
		
	}
	
 	public void eliminarRegistroAlmacen() {
		conn = Conexion.ConnectarDb();
		String sql = "delete from almacen where nit = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, nit.getText());
			pst.execute();
			Alert mensaje = new Alert(AlertType.INFORMATION);
			mensaje.setTitle("Resultado");
			mensaje.setHeaderText("Almacen eliminado");
			mensaje.show();
			actualizarTablaAlmacen();
			
		} catch (Exception e) {
			Alert mensaje = new Alert(AlertType.INFORMATION);
			mensaje.setTitle("Resultado");
			mensaje.setHeaderText("Error");
			mensaje.show();
		}
	
	}
 	
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
	}


	@Override
	public void initialize(URL url, ResourceBundle rb) {
		actualizarTablaConsumidor();
		actualizarTablaAlmacen();
		actualizarTablaPago();
		
		tipoPago2.getItems().add("TARJETA");
		tipoPago2.getItems().add("CHEQUE");
		tipoPago2.getItems().add("EFECTIVO");
	}
}
    

package poli.controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import poli.model.Almacen;
import poli.model.Cajero;
import poli.model.Conexion;
import poli.model.Consumidor;
import poli.model.Pago;
import poli.model.Producto;
import poli.tablas.Registros;

public class AgregarPFController implements Initializable {
	
	@FXML
    private TableView<Producto> TablaPF;
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
	@FXML
	private TableColumn<?, ?> colC5;
	@FXML
	private Button salir;
	
	Producto producto;
	
	private ObservableList<Producto> listaProducto;
	
	private ObservableList<Producto> listaProductoF;
	

		@FXML
		void agregarProductos(ActionEvent event) {
		    	
		    	
		
		    }
	
	    @FXML
	    void salir(ActionEvent event) {
	    	
	    	Stage stage = (Stage) this.salir.getScene().getWindow();
	    	stage.close();
	
	    }
	    
	 	public void actualizarTablaProducto(){
	 		
	    }
		
	 	public void atributos(ObservableList<Producto> listaProducto) {
	 		this.producto = producto;
	 		
	 	}


		@Override
		public void initialize(URL url, ResourceBundle rb) {
			
			//listaProductoF = FXCollections.observableArrayList();
			actualizarTablaProducto();
			
			
			//cmbProductos.setItems();
			
		}
		

}

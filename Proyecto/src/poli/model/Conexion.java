package poli.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


/**
 *
 * @author 
 */
public class Conexion {

	Connection conn = null;

	public static Connection ConnectarDb() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/test", "root",
					"Clothe41$");
			System.out.println("Connection Established");
			return conn;
		} catch (Exception e) {
			Alert mensaje = new Alert(AlertType.INFORMATION);
			mensaje.setTitle("Resultado");
			mensaje.setHeaderText("");
			mensaje.show();
			return null;
		}

	}

	public static ObservableList<Consumidor> getDataConsumidor() {
		Connection conn = ConnectarDb();
		ObservableList<Consumidor> list = FXCollections.observableArrayList();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from consumidor");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Consumidor(rs.getString("nombreUsuario"), rs.getString("numeroTarjetaUsuario"),
						rs.getString("puntosUsuario"), rs.getInt("idUsuario"), rs.getString("direccionUsuario"),
						rs.getString("numeroUsuario")));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public static ObservableList<Almacen> getDataAlmacen() {
		Connection conn = ConnectarDb();
		ObservableList<Almacen> list = FXCollections.observableArrayList();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from almacen");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Almacen(rs.getString("nit"), rs.getString("nombreAlmacen"), rs.getString("sucursal"),
						rs.getString("direccionAlmacen"), rs.getString("nombreGerente"),
						rs.getString("telefonoAlmacen")));
			}
		} catch (Exception e) {
		}
		return list;
	}
	
	
	public static ObservableList<Pago> getDataPago() {
		Connection conn = ConnectarDb();
		ObservableList<Pago> list = FXCollections.observableArrayList();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from pago");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Pago(rs.getString("idPago"), rs.getString("tipoPago")));
			}
		} catch (Exception e) {
		}
		return list;
	}

}

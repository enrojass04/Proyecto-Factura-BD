package poli.model;


import javafx.collections.ObservableList;

public class Producto {
	
	private String tipoProducto;

	private String codigo;

	private String nombreProducto;

	private double precio;

	
	public Producto(String tipoProducto, String codigo, String nombreProducto, double precio) {
		this.tipoProducto = tipoProducto;
		this.codigo = codigo;
		this.nombreProducto = nombreProducto;
		this.precio = precio;
	}


	public Producto() {
		
	}
	

	public String getTipoProducto() {
		return tipoProducto;
	}


	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getNombreProducto() {
		return nombreProducto;
	}


	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}
	

	@Override
	public String toString() {
		return tipoProducto +" "+ codigo +" " + nombreProducto +" " + precio ;
	}



}
package poli.model;

import java.util.ArrayList;

public class Factura {
	
	private int numero;
	
	private String fecha;	
	
	private Consumidor consumidor;
	
	private Cajero cajero;
	
	private Almacen almacen;
	
	private Pago pago;
	
	private ArrayList<Producto> productos;

	public Factura(int numero, String fecha, Cajero cajero, Consumidor consumidor, Almacen almacen, Pago pago,
			ArrayList<Producto> productos) {
		this.numero = numero;
		this.fecha = fecha;
		this.cajero = cajero;
		this.consumidor = consumidor;
		this.almacen = almacen;
		this.pago = pago;
		this.productos = productos;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Cajero getCajero() {
		return cajero;
	}

	public void setCajero(Cajero cajero) {
		this.cajero = cajero;
	}

	public Consumidor getConsumidor() {
		return consumidor;
	}

	public void setConsumidor(Consumidor consumidor) {
		this.consumidor = consumidor;
	}

	public Almacen getAlmacen() {
		return almacen;
	}

	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

}

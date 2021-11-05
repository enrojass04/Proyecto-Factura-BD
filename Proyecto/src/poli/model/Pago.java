package poli.model;

public class Pago {
	
	private String idPago;
	
	private String tipoPago;

	public Pago(String idPago, String tipoPago) {
		this.idPago = idPago;
		this.tipoPago = tipoPago;
	}

	public String getIdPago() {
		return idPago;
	}

	public void setIdPago(String idPago) {
		this.idPago = idPago;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}
	
}

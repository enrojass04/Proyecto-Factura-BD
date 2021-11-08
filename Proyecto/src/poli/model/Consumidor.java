package poli.model;

public class Consumidor {

	private String nombreUsuario;

	private String numeroTarjetaUsuario;

	private String puntosUsuario;
	
	private int idUsuario;
	
	private String direccionUsuario;
	
	private String numeroUsuario;
	
	
	public Consumidor(String string, int i, String string2) {
		
	}
	

	public Consumidor(String nombreUsuario, String numeroTarjetaUsuario, String puntosUsuario, int idUsuario,
			String direccionUsuario, String numeroUsuario) {
		this.nombreUsuario = nombreUsuario;
		this.numeroTarjetaUsuario = numeroTarjetaUsuario;
		this.puntosUsuario = puntosUsuario;
		this.idUsuario = idUsuario;
		this.direccionUsuario = direccionUsuario;
		this.numeroUsuario = numeroUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNumeroTarjetaUsuario() {
		return numeroTarjetaUsuario;
	}

	public void setNumeroTarjetaUsuario(String numeroTarjetaUsuario) {
		this.numeroTarjetaUsuario = numeroTarjetaUsuario;
	}

	public String getPuntosUsuario() {
		return puntosUsuario;
	}

	public void setPuntosUsuario(String puntosUsuario) {
		this.puntosUsuario = puntosUsuario;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getDireccionUsuario() {
		return direccionUsuario;
	}

	public void setDireccionUsuario(String direccionUsuario) {
		this.direccionUsuario = direccionUsuario;
	}

	public String getNumeroUsuario() {
		return numeroUsuario;
	}

	public void setNumeroUsuario(String numeroUsuario) {
		this.numeroUsuario = numeroUsuario;
	}


	@Override
	public String toString() {
		return nombreUsuario;
	}

	
}	
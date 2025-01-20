package es.ascender.biblioteca.negocio;

public class Direccion {
	private String dni;
	private String calle;
	private int  numero;
	private int codigopostal;
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getCodigopostal() {
		return codigopostal;
	}
	public void setCodigopostal(int codigopostal) {
		this.codigopostal = codigopostal;
	}
	public Direccion() {
		super();
	}
	public Direccion(String dni, String calle, int numero, int codigopostal) {
		super();
		this.dni = dni;
		this.calle = calle;
		this.numero = numero;
		this.codigopostal = codigopostal;
	}
	public Direccion(String dni, String calle, int numero) {
		super();
		this.dni = dni;
		this.calle = calle;
		this.numero = numero;
	}
	
}

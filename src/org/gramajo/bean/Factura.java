package org.gramajo.bean;

public class Factura {
	private Integer idFactura;
	private String nombre;
	private Integer precio;
	private Game game;
	public Integer getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public Factura() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Factura(Integer idFactura, String nombre, Integer precio, Game game) {
		super();
		this.idFactura = idFactura;
		this.nombre = nombre;
		this.precio = precio;
		this.game = game;
	}
}

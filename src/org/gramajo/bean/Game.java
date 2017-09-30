package org.gramajo.bean;

public class Game {
	private Integer idGame;
	private String nombre;
	private Integer precio;
	private String imagen;
	private String descripcion;
	private Usuario usuario;
	private Categoria categoria;
	public Integer getIdGame() {
		return idGame;
	}
	public void setIdGame(Integer idGame) {
		this.idGame = idGame;
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
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Game() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Game(Integer idGame, String nombre, Integer precio, String imagen,
			String descripcion, Usuario usuario, Categoria categoria) {
		super();
		this.idGame = idGame;
		this.nombre = nombre;
		this.precio = precio;
		this.imagen = imagen;
		this.descripcion = descripcion;
		this.usuario = usuario;
		this.categoria = categoria;
	}
}

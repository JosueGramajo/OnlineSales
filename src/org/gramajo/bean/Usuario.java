package org.gramajo.bean;

public class Usuario {
	private Integer idUsuario;
	private String nombre;
	private String nick;
	private String pass;
	private String email;
	private Rol rol;
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Usuario(Integer idUsuario, String nombre, String nick, String pass,
			String email, Rol rol) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.nick = nick;
		this.pass = pass;
		this.email = email;
		this.rol = rol;
	}
}

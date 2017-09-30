package org.gramajo.servlet.usuario;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.gramajo.bean.Usuario;
import org.gramajo.db.Conexion;

public class ServletLogin extends HttpServlet{
	public void doGet(HttpServletRequest peticion,HttpServletResponse respuesta)throws IOException,ServletException{
		doPost(peticion,respuesta);
	}
	public void doPost(HttpServletRequest peticion,HttpServletResponse respuesta)throws IOException,ServletException{
		RequestDispatcher despachador=null;
		String usuario=peticion.getParameter("txtUsuario");
		String password=peticion.getParameter("txtPassword");
		peticion.setAttribute("nombreUsuario", usuario);
		//try{
		Usuario usr=Conexion.getInstancia().autenticarUsuario(usuario,password);
		if (usr.getIdUsuario()!=-1 && usr.getIdUsuario()!=null){
			HttpSession session=peticion.getSession(true);
			session.setAttribute("listaCategorias", Conexion.getInstancia().hacerConsulta("From Categoria"));
			session.setAttribute("listaRol", Conexion.getInstancia().hacerConsulta("From Rol"));
			session.setAttribute("usuario", usr);
			session.setAttribute("estado", " ");
			peticion.setAttribute("newId",usr.getNick());
			peticion.setAttribute("rolUser", usr.getRol().getIdRol());
			peticion.setAttribute("listaJuegos", Conexion.getInstancia().hacerConsulta("From Game"));
			despachador=peticion.getRequestDispatcher("login.jsp");
		}else{
		//}catch(IndexOutOfBoundsException iobe){
			peticion.setAttribute("estado", "Incorrect User name or password");
			despachador=peticion.getRequestDispatcher("index.jsp");		
		//}
		}
		despachador.forward(peticion,respuesta);
	}
}
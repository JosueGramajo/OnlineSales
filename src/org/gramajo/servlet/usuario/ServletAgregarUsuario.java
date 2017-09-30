package org.gramajo.servlet.usuario;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gramajo.bean.Rol;
import org.gramajo.bean.Usuario;
import org.gramajo.db.Conexion;

public class ServletAgregarUsuario extends HttpServlet{
	public void doGet(HttpServletRequest peticion,HttpServletResponse respuesta)throws IOException,ServletException{
		doPost(peticion,respuesta);
	}
	public void doPost(HttpServletRequest peticion,HttpServletResponse respuesta)throws IOException,ServletException{
		RequestDispatcher despachador=null;
		Usuario usr=(Usuario)peticion.getSession().getAttribute("usuario");
		Rol r=(Rol)Conexion.getInstancia().Buscar(Rol.class,Integer.parseInt(peticion.getParameter("txtIdRol")));
		Usuario newUser=new Usuario(
				0,
				peticion.getParameter("txtName"),
				peticion.getParameter("txtNick"),
				peticion.getParameter("txtPassword"),
				peticion.getParameter("txtEmail"),
				r);
		Conexion.getInstancia().agregar(newUser);
		despachador=peticion.getRequestDispatcher("ServletListarGame.do");
		despachador.forward(peticion,respuesta);
	}
}

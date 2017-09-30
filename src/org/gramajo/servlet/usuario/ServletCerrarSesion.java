package org.gramajo.servlet.usuario;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gramajo.bean.Factura;
import org.gramajo.db.Conexion;

public class ServletCerrarSesion extends HttpServlet{
	public void doGet(HttpServletRequest peticion,HttpServletResponse respuesta)throws IOException,ServletException{
		doPost(peticion,respuesta);
	}
	public void doPost(HttpServletRequest peticion,HttpServletResponse respuesta)throws IOException,ServletException{
		RequestDispatcher despachador=null;
		List <Object> listado=Conexion.getInstancia().hacerConsulta("From Factura");
		for(Object jup: listado){
			Conexion.getInstancia().eliminar(jup);	
		}
		peticion.getSession(false);
		peticion.getSession().invalidate();
		peticion.getSession().removeAttribute("usuario");
		despachador=peticion.getRequestDispatcher("index.jsp");
		despachador.forward(peticion,respuesta);
	}
}

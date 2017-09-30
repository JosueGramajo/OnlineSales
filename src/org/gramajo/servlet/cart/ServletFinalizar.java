package org.gramajo.servlet.cart;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gramajo.bean.Factura;
import org.gramajo.bean.Usuario;
import org.gramajo.db.Conexion;

public class ServletFinalizar extends HttpServlet{
	public void doGet(HttpServletRequest peticion,HttpServletResponse respuesta)throws IOException,ServletException{
		doPost(peticion,respuesta);
	}
	public void doPost(HttpServletRequest peticion,HttpServletResponse respuesta)throws IOException,ServletException{
		RequestDispatcher despachador=null;
		List <Object> listado=Conexion.getInstancia().hacerConsulta("From Factura");
		Usuario usr=(Usuario)	peticion.getSession().getAttribute("usuario");
		if(usr!=null){
			peticion.setAttribute("newId",usr.getNick());
			peticion.setAttribute("rolUser", usr.getRol().getIdRol());
			for(Object jup: listado){
				Conexion.getInstancia().eliminar(jup);	
			}
			despachador=peticion.getRequestDispatcher("FinalizarCompra.jsp");
		}else{
			despachador=peticion.getRequestDispatcher("index.jsp");	
		}
		despachador.forward(peticion,respuesta);
	}
}

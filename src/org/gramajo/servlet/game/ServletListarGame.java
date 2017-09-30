package org.gramajo.servlet.game;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gramajo.bean.Usuario;
import org.gramajo.db.Conexion;

public class ServletListarGame extends HttpServlet{
	public void doGet(HttpServletRequest peticion,HttpServletResponse respuesta)throws IOException,ServletException{
		doPost(peticion,respuesta);
	}
	public void doPost(HttpServletRequest peticion,HttpServletResponse respuesta)throws IOException,ServletException{
		RequestDispatcher despachador=null;
		Usuario usr=(Usuario)	peticion.getSession().getAttribute("usuario");
		if(usr!=null){
			peticion.setAttribute("newId",usr.getNick());
			peticion.setAttribute("rolUser", usr.getRol().getIdRol());
			peticion.setAttribute("listaJuegos", Conexion.getInstancia().hacerConsulta("From Game"));
			despachador=peticion.getRequestDispatcher("login.jsp");
		}else{
			despachador=peticion.getRequestDispatcher("index.jsp");	
		}
		despachador.forward(peticion,respuesta);
	}
}

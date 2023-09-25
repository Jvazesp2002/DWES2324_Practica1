package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Servlet implementation class Controlador
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AccesoBaseDatos accesoBaseDatos;

    /**
     * Default constructor. 
     */
    public Controller() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
        super.init();
      
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       	accesoBaseDatos = new AccesoBaseDatos();
		List<String> nombres =  accesoBaseDatos.devolverNombres();
        
		// Establecer el tipo de contenido a HTML
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        // Escribir la lista de nombres en el cuerpo de la respuesta
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Listado de Nombres</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Listado de Nombres</h1>");
        out.println("<ul>");
        for (String nombre : nombres) {
			out.println("<li>" + nombre + "</li>");
        }
        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
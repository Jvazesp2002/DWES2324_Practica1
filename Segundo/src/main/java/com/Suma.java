package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Suma
 */
public class Suma extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Suma() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String numero1 = request.getParameter("num1");
		String numero2 = request.getParameter("num2");
		Integer num1 = Integer.parseInt(numero1);
		Integer num2 = Integer.parseInt(numero2);
		Integer suma = num1 + num2;
		out.print("<h1>Calculadora</h1>");
		out.print("El resultado es: " + suma);
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String numero1 = request.getParameter("num1");
		String numero2 = request.getParameter("num2");
		Integer num1 = Integer.parseInt(numero1);
		Integer num2 = Integer.parseInt(numero2);
		Integer suma = num1 + num2;
		out.print("<h1>Calculadora</h1>");
		out.print("El resultado es: " + suma);
		out.close();
	}

}

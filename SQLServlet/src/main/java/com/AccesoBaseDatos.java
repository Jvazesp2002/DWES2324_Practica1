package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccesoBaseDatos {
public List<String> nombres = new ArrayList<String>();
	
	public List<String> devolverNombres(){
		String url = "jdbc:mysql://localhost:3306/App";
        String usuario = "root";
        String contraseña = "123";
        
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			  try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
		            String consulta = "SELECT * FROM persona";
		            try (Statement stmt = conexion.createStatement();
		                 ResultSet rs = stmt.executeQuery(consulta)) {
		                
		                while (rs.next()) {
		                    // Suponiendo que tu_tabla tiene dos columnas llamadas 'id' y 'nombre'.
		                    int id = rs.getInt("id");
		                    String nombre = rs.getString("nombre");
		                    String tipo = rs.getString("tipo");
		                    nombres.add(nombre + " "  + tipo);
		                    System.out.printf("ID: %d, Nombre: %s%n", id, nombre);
		                }
		                
		            } catch (Exception e) {
		                e.printStackTrace();
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
				
				return nombres;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nombres;
        
      
	}
}

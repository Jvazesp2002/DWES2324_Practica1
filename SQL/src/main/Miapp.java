package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Miapp {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/App";
		String usuario = "root";
		String contraseña = "123";

		try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
			String consulta = "SELECT * FROM persona";
			try (Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(consulta)) {

				while (rs.next()) {
					// Suponiendo que tu_tabla tiene dos columnas llamadas 'id' y 'nombre'.
					int id = rs.getInt("id");
					String nombre = rs.getString("nombre");
					System.out.printf("ID: %d, Nombre: %s%n", id, nombre);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccesoBaseDatos {
	public List<String> nombres = new ArrayList<String>();

	public List<String> devolverNombres() {
		String url = "jdbc:mysql://localhost:3306/app";
		String usuario = "root";
		String contraseña = "1234";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
				String consulta = "SELECT * FROM Criaturas";
				try (Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(consulta)) {

					while (rs.next()) {
						int id = rs.getInt("id");
						String nombre = rs.getString("nombre");
						String tipo = rs.getString("tipo");
						nombres.add(id + " " + nombre + " " + tipo);
						System.out.printf("ID: %d, Criatura: %s%n", id, nombre);
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

	public boolean CrearCriatura(String nombre, String tipo) {

		String url = "jdbc:mysql://localhost:3306/app";
		String usuario = "root";
		String contraseña = "1234";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
				String consulta = "INSERT INTO animal (`nombre`, `tipo`) VALUES (?, ?)";
				try (PreparedStatement stmt = conexion.prepareStatement(consulta)) {

					stmt.setString(1, nombre);
					stmt.setString(2, tipo);
					stmt.execute();
					return true;

				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();

			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean EliminarCriatura(int id) {

		String url = "jdbc:mysql://localhost:3306/app";
		String usuario = "root";
		String contraseña = "1234";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
				String consulta = "DELETE FROM Criaturas WHERE id = ?";
				try (PreparedStatement stmt = conexion.prepareStatement(consulta)) {
					stmt.setInt(1, id);
					int filasAfectadas = stmt.executeUpdate();
					return filasAfectadas > 0; 
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;

	}

}
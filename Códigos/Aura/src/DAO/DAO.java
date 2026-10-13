package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;





public class DAO {
	// el DAO es el que maneja toda la logica
	// operacional relacionada a la BDD

	String user = "root";
	String psw = "admin";
	                   // host        //Nombre de la BDD
	String path = "jdbc:mysql://localhost:3306/brbrbatapin";
	
	public int agregar() {
		Connection conexion = null;
		String sql = "INSERT INTO `brbrbatapin`.`aura`(`idaura`,`auracool`,`dniaura`,`nombreaura`,`farmeodeaura`) VALUES(6,'aura','7','Thiago67','99');";
		int filas = 0;
		try {
			// Conexion tradicional, hay otro metodo pero no funciona xd
			conexion = DriverManager.getConnection(path, user, psw);
			Statement stmt = conexion.createStatement();
			filas = stmt.executeUpdate(sql);
			System.out.println(filas);
			
			System.out.println("aura");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return filas;
	}
	
	public Connection conectar() {
		Connection conexion = null;

		
		try {
			// Conexion tradicional, hay otro metodo pero no funciona xd
			conexion = DriverManager.getConnection(path, user, psw);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return conexion;
	}

}

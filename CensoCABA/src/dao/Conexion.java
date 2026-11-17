package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Sistema.Barrio;
import Sistema.BarrioComplejosHabitacionales;
import Sistema.Comuna;
import Sistema.BarrioFormal;
import Sistema.BarrioPlanUrbanizacion;

public class Conexion {
	String user = "root";
	String psw = "admin";
	
	//Puerto - BD
	String path = "jdbc:mysql://localhost:3306/censocaba";
	
	public Connection conectar() {
		Connection c = null;
		try {
			//Establece conexión
			c = DriverManager.getConnection(path,user,psw);
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} return c;
		
	}
	
	//************************************
	//*----------- C O M U N A ----------*	
	//************************************
	
	//**************************************************
	//*----------- C A R G A R * C O M U N A ----------*	
	//**************************************************
	public void cargarComuna(Comuna C) {
		Connection conexion = conectar();
		
		String sql = "INSERT INTO comuna(NumSedeComunal,NumeroComuna)VALUES(?,?)";
		
		try {
			PreparedStatement stmt = conexion.prepareStatement(sql);
		
			stmt.setString(1, C.getNombreComuna());
			stmt.setString(2, C.getNumSedeComunal());
			
			stmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				conexion.close();
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//********************************************************
	//*----------- M O D I F I C A R * C O M U N A ----------*	
	//********************************************************
	public void modificarComuna(Comuna comuna, String numeroSedeAntiguo) {
		Connection c = conectar();
		
		String nombre = comuna.getNombreComuna();
		String numeroSede = comuna.getNumSedeComunal();
		
		String sql = "UPDATE comuna" 
				+ "SET nombreComuna = ?"
				+ "		numSedeComunal = ?"
				+ "WHERE numSedeComunal = ?;";
		
		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			
			stmt.setString(1,nombre);
			stmt.setString(2,numeroSede);
			stmt.setString(3,numeroSedeAntiguo);
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//******************************************************
	//*----------- E L I M I N A R * C O M U N A ----------*	
	//******************************************************
	public boolean eliminarComunaSeleccionada(String numSedeComunal) {
		Connection c = conectar();
		String sql = "DELETE FROM comuna WHERE numSedeComunal = ?";
		int filasAfectadas = 0;
		
		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			
			stmt.setString(1,numSedeComunal);
			
			filasAfectadas = stmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		
		} finally {
			try {
				c.close();
			}catch(SQLException e) {
				e.printStackTrace(); 
			}
		}
		
		return filasAfectadas > 0; 
	}
	
	//********************************************************
	//*----------- C O N S E G U I R * C O M U N A ----------*	
	//********************************************************
	public ArrayList<Comuna> conseguirTodasLasComunas(){
		Connection c = conectar();
		
		ArrayList<Comuna> comunas = new ArrayList<>();
		
		String nombre;
		String numeroComuna;
		
		String sql = "SELECT * FROM comuna";
		
		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				nombre = rs.getString("nombreComuna");
				numeroComuna = rs.getString("numSedeComunal");
				
				Comuna comuna = new Comuna(nombre,numeroComuna);
				
				comunas.add(comuna);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return comunas;
	}
	
	//**************************************************
	//*----------- B U S C A R * C O M U N A ----------*	
	//**************************************************

	public Comuna buscarComunaEspecifica(String numSedeComunal) {
		Connection c = conectar();
		Comuna comuna = null;
		
		String nombre;
		String numeroComuna;
		
		String sql = "SQL * FROM comuna WHERE nombreComuna = ?";
		
		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1,numSedeComunal);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				nombre = rs.getString("nombreComuna");
				numeroComuna = rs.getString("numeroComuna");
				
				comuna = new Comuna(nombre,numeroComuna);
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return comuna;
	}
	//**************************************************************
	//*----------- C O N S E G U I R * I D * C O M U N A ----------*	
	//**************************************************************

	public int conseguirIdComuna(String numSedeComunal) {
		Connection c = conectar();
		
		int id = 0;
		
		String sql = "SELECT ID_comuna FROM comuna WHERE numSedeComunal = ?";
		
		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1,numSedeComunal);
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				id = rs.getInt("ID_comuna");
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return id;
	}
	
	//**************************************************************************
	//*----------- A S O C I A R * C O M U N A * C O N * B A R R I O ----------*	
	//**************************************************************************
	
	public ArrayList<Comuna> asociarComunasConBarrios(){
		ArrayList<Comuna> comunas = conseguirTodasLasComunas();
		ArrayList<Barrio> barrios = conseguirTodosLosBarrios();
		
		Connection c = conectar();
		
		String numeroComuna;
		String nombreBarrio;
		
		String sql = "SELECT c.numSedeComunal, b.nombreBarrio"
				+ "FROM comuna c"
				+ "INNER JOIN barrio b"
				+ "		ON c.ID_Comuna = b.Comuna.Comuna_ID_Comuna";
		
		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				numeroComuna = rs.getString("numSedeComunal");
				nombreBarrio = rs.getString("nombreBarrio");
				for (Comuna com : comunas){
					//Hace un ciclo dentro de las comunas para luego ver la base de datos que tiene un barrio asociado.
					if (com.getNumSedeComunal().equals(numeroComuna){
						//Hace un ciclo de todos los barrios
						for (Barrio b: barrios) {
							//Comprueba de solamente añadir el barrio que corresponda con la fila INNER JOIN
							if (b.getNombreBarrio().equals(nombreBarrio)) {
								com.getBarrios().add(b);
								break; // corta el for de busqueda de barrio si ta lo encontró
							}
						}
						
						break; //si ya se a{adió el barrui, corta el for de las comunas para pasar a la siguiente fila
					}
				}
			}
		}catch(SQLException e) {
	        e.printStackTrace();
	    }
		
		return comunas;
	} 
	}
}

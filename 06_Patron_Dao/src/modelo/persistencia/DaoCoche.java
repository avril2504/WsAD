package modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.entidad.Coche;

public class DaoCoche {
	
	private Connection conexion;
	
	public boolean abrirConexion(){
		String url = "jdbc:mysql://localhost:3306/bbdd_coches";
		String usuario = "root";
		String password = "";
		try {
			conexion = DriverManager.getConnection(url,usuario,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean cerrarConexion(){
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean insertar(Coche coche) {
		if(!abrirConexion()){
			return false;
		}
		boolean alta = true;

			String sql = "INSERT INTO coches(marca,modelo,tipo_motor,kilometros) VALUES (?, ?, ?, ?)"; 
			try {

				PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, coche.getMarca());
			ps.setString(2, coche.getModelo());
			ps.setString(3, coche.getTipo_motor());
			ps.setDouble(4, coche.getKilometros());
			
			int afectados = ps.executeUpdate();
			if(afectados == 1) {
				return true;
			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}finally{
			cerrarConexion();
		}
		return false;
	}
	
	
	
	public List<Coche> listar() {
		
		if(!abrirConexion()){
			return null;
		}
		List<Coche> listaCoches = new ArrayList<Coche>();

		String query = "select id, marca, modelo, tipo_motor, kilometros from coches ";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			
			while (rs.next()) {
				Coche coche = new Coche();
				coche.setId(rs.getInt(1));
				coche.setMarca(rs.getString(2));
				coche.setModelo(rs.getString(3));
				coche.setTipo_motor(rs.getString(4)); 
				coche.setKilometros(rs.getDouble(5));
				
				listaCoches.add(coche);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		
		return listaCoches;
	}
	
	
	
	
	public List<Coche> buscarI(int id) {

		if(!abrirConexion()){
			return null;
		}	
		
		List<Coche> listaCoches = new ArrayList<Coche>();
		Coche coche = null;
		String query = "select id, marca, modelo, tipo_motor, kilometros from coches  "
				+ "where id = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				coche = new Coche();
				coche.setId(rs.getInt(1));
				coche.setMarca(rs.getString(2));
				coche.setModelo(rs.getString(3));
				coche.setTipo_motor(rs.getString(4)); 
				coche.setKilometros(rs.getDouble(5));
				
				listaCoches.add(coche);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		
		return listaCoches;
	}
	
	public List<Coche> buscarM(String marca) {
		if(!abrirConexion()){
			return null;
		}	
		List<Coche> listaCoches = new ArrayList<Coche>();
		Coche coche = null;
		String query = "select id, marca, modelo, tipo_motor, kilometros from coches "
				+ "where marca = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, marca);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				coche = new Coche();
				coche.setId(rs.getInt(1));
				coche.setMarca(rs.getString(2));
				coche.setModelo(rs.getString(3));
				coche.setTipo_motor(rs.getString(4)); 
				coche.setKilometros(rs.getDouble(5));
				
				listaCoches.add(coche);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		
		return listaCoches;
	}
	
	public boolean modificar(Coche c) {
		if(!abrirConexion()){
			return false;
		}
		boolean modificado = true;
		String query = "update coches set id=?, marca=?, modelo=?, "
				+ "tipo_motor=?, kilometros=? WHERE ID=?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, c.getId());
			ps.setString(2, c.getMarca());
			ps.setString(3, c.getModelo());
			ps.setString(4, c.getTipo_motor());
			ps.setDouble(5, c.getKilometros());
			
			ps.setInt(6, c.getId());
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0)
				modificado = false;
		} catch (SQLException e) {

			modificado = false;
			e.printStackTrace();
		} finally{
			cerrarConexion();
		}
		
		return modificado;
	}
	
	public boolean baja (int id) {
		if(!abrirConexion()){
			return false;
		}
		
		boolean borrado = true;
		String query = "delete from coches where id = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, id);
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0)
				borrado = false;
		} catch (SQLException e) {
			borrado = false;

			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return borrado; 
	}
}  

   

package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DaoCoche {
	
	public boolean insertar(Coche coche) {
		// Paso 1: Establecemos los parametros de conexiÃ³n con la base de datos
		String cadenaConexion = "jdbc:mysql://localhost:3306/coches";
		String user = "root";
		String pass = "";
		
		// Paso 2: Interactuar con la BD 
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass)){
			//Esta es la manera que hay que hacer si quereis aprobar
			//Â¿porque? De momento ganamos en claridad, es mÃ¡s visual
			String sql = "INSERT INTO coches(marca,modelo,tipo_motor,kilometros) VALUES (?, ?, ?, ?)"; 
			// en vez de poner los valores ponemos interrogantes
			
			System.out.println("Se va a ejecutar la siguiente sentencia SQL:");
			System.out.println(sql);
			
			//NÃ³tese que usamos "PreparedStatement" en vez de "Statement"
			PreparedStatement sentencia;
			sentencia = con.prepareStatement(sql);
			//por un lado mandamos la sql, y por otro mandamos los parametros
			//que la bbdd tiene que sustituir por las "?"
			sentencia.setString(1, coche.getMarca());//decimos que la primera "?" que se encuentre le ponga el nombre
			sentencia.setString(2, coche.getModelo());//
			sentencia.setString(3, coche.getTipo_motor());
			sentencia.setDouble(4, coche.getKilometros());
			
			//Ejecutamos la "query"
			int afectados = sentencia.executeUpdate();
			if(afectados == 1) {
				return true;
			}
			System.out.println("Sentencia SQL ejecutada con exito");
			System.out.println("Registros afectados: "+afectados);
		} catch (SQLException e) {
			System.out.println("Error al añadir una nueva persona");
			System.out.println(e.getMessage());
		}
		return false;
	}

}  
   

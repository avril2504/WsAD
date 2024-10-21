package _01FicherosUsuarioPassword;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Verificar {
	 private String nuevoUsuario;
	 private String nuevaContrasena;
	
	public Verificar(String nuevoUsuario, String nuevaContrasena) {
		super();
		this.nuevoUsuario = nuevoUsuario;
		this.nuevaContrasena = nuevaContrasena;
	}
	

	public Verificar() {
		
	}

	public String getNuevoUsuario() {
		return nuevoUsuario;
	}

	public void setNuevoUsuario(String nuevoUsuario) {
		this.nuevoUsuario = nuevoUsuario;
	}

	public String getNuevaContrasena() {
		return nuevaContrasena;
	}

	public void setNuevaContrasena(String nuevaContrasena) {
		this.nuevaContrasena = nuevaContrasena;
	}


	public void usuarioNuevo(Scanner sc ) {

		System.out.println("Introduzca un usuario");
		nuevoUsuario = sc.nextLine();
		System.out.println("Introduzca un password");
		nuevaContrasena = sc.nextLine();

		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("usuario.dat", true))){
			System.out.println("...");
			writer.newLine();
			writer.write(nuevoUsuario + "/" + nuevaContrasena);
			writer.newLine();
			System.out.println("Se creo un nuevo usuario");
		} catch (Exception e) {
			System.out.println("Error al escribir el archivo");
		}
	}
	
	
	public boolean verificar(String usuario, String contrasena) {
		try (BufferedReader read = new BufferedReader(new FileReader("usuario.dat"))){
			String linea;
			
			while ((linea = read.readLine()) != null) {
				String[] partes = linea.split("/");
				if(partes.length == 2) {
					String usuarioSave = partes[0];
					String passwordSave = partes[1];
					
					if (usuarioSave.equals(usuario) && passwordSave.equals(contrasena)) {
						return true;
					}
				}	
				
			}
			
		} catch (IOException e) {
			System.out.println("Error al leer el archivo");
		}
		return false; //comentar
		
	}

}

package modelo.interfaz.usuario;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import modelo.entidad.Coche;
import modelo.persistencia.DaoCoche;

public class InterfazUsuario {
	
	
	private DaoCoche dao;
	private Scanner scString;
	private Scanner sc;
	
	public static void main(String[] args) {

		
		new InterfazUsuario().menu();

		

	}
	
	public void menu() {
		sc = new Scanner(System.in);
		scString = new Scanner(System.in);
		int opcion = 0;
		do {
			System.out.println("     Menu    ");
			System.out.println("1. Introducir coche");
			System.out.println("2. Dar de baja coche por id");
			System.out.println("3. Modificar coche por id");
			System.out.println("4. Buscar coche por id");
			System.out.println("5. Buscar coches por marca");
			System.out.println("6. Listar todos los coches");
			System.out.println("0. Salir");
			opcion = sc.nextInt();
			
			switch (opcion) {
			case 1: 
				insertarCoche();
				break;
			case 2: 
				DarDeBajaCochePorID();
				break;
			case 3: 
				ModificarCochePoriD();
				break;
			case 4: 
				BuscarCochePorID();
				break;
			case 5: 
				BuscarCochePorMarca();
				break;
			case 6: 
				ListarCoche();
			case 0:
				System.out.println("Salir del programa");
			default:
				break;
			}

			
		} while (opcion != 0);
	}

	private void ListarCoche() {
	dao = new DaoCoche();
	List<Coche> lista = dao.listar();
	
	System.out.println("Lista de coches");
	for(Coche c : lista) {
		System.out.println("Id:" + c.getId());
		System.out.println("Marca:" +c.getMarca());
		System.out.println("Modelo:" +c.getModelo());
		System.out.println("Tipo de motor:" +c.getTipo_motor());
		System.out.println("Kilometros:" +c.getKilometros());
		}
		
	}

	private void BuscarCochePorMarca() {
		dao = new DaoCoche();
		System.out.println("Introduzca la marca");
		String marca = scString.nextLine();
		List<Coche> lista = dao.buscarM(marca);
		
		for(Coche c : lista) {
			System.out.println(c);
			}
	}

	private void BuscarCochePorID() {
		dao = new DaoCoche();
		System.out.println("Ingrese el id");
		int id = sc.nextInt();
		List<Coche> lista = dao.buscarI(id);
		
		for(Coche c : lista) {
			System.out.println(c);
			}
	}

	private void ModificarCochePoriD() {
		dao = new DaoCoche();
		
		Coche coche = new Coche();
		coche.setId(3);
		coche.setMarca("Toyota");
		coche.setModelo("nuevo");
		coche.setTipo_motor("gasolina");
		coche.setKilometros(10000);
		
		boolean modificar = dao.modificar(coche);
		if(modificar){
			System.out.println("El coche se ha modificado");
		}else{
			System.out.println("El coche NO se ha modificado");
		}
		
	}

	private void DarDeBajaCochePorID() {
		dao = new DaoCoche();
		System.out.println("Ingrese el id");
		int id = sc.nextInt();
		dao.baja(id);
	}

	private void insertarCoche() {
		
		dao = new DaoCoche();
		
		System.out.println("Introduzca la marca");
		String marca = scString.nextLine();
		
		System.out.println("Introduzaca el modelo");
		String modelo = scString.nextLine();
		
		System.out.println("Introduza el tipo de motor");
		String tipo_motor = scString.nextLine();
		
		
		System.out.println("Introduzca los kilometros");
		double km = sc.nextDouble();
		
		
		Coche c = new Coche(marca, modelo, tipo_motor, km);
		dao.insertar(c);
		
	}

}

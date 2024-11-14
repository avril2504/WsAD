package test;


import java.util.Scanner;

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
			System.out.println("0. Salir");
			opcion = sc.nextInt();
			
			switch (opcion) {
			case 1: 
				insertarCoche();
			case 0:
				System.out.println("Salir del programa");
			default:
				break;
			}

			
		} while (opcion != 0);
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

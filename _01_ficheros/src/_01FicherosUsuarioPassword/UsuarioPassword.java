package _01FicherosUsuarioPassword;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.crypto.KeyAgreement;

public class UsuarioPassword {

	public static final String NOMBRE_FICHERO = "usuario.dat";
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Verificar v = new Verificar();  
		boolean acceso = false;
		int numeroIntentos = 0;

        while (!acceso && numeroIntentos < 3) {
            System.out.println("Ingrese su nombre de usuario: ");
            String nombreUsuario = sc.nextLine();

            System.out.println("Ingrese su contraseña: ");
            String password = sc.nextLine();

            if (v.verificar(nombreUsuario, password)) {
                acceso = true;
                System.out.println("Acceso concedido. ¡Bienvenido, " + nombreUsuario + "!");
            } else {
                numeroIntentos++;
                System.out.println("Usuario o contraseña incorrectos.");
            }
        }

        if (!acceso) {
            System.out.println("Ha superado el número máximo de intentos. Fin del programa.");
            return;
        }

        menu(sc);
    
}
		    private static void menu(Scanner scanner) {
		        boolean continuar = true;
		        Verificar v2 = new Verificar();
		        while (continuar) {
		            System.out.println("\n--- Menú Principal ---");
		            System.out.println("1. Agregar usuario al registro");
		            System.out.println("2. Fin del programa");
		            System.out.print("Elija una opción: ");
		            String opcion = scanner.nextLine();

		            switch (opcion) {
		                case "1":
		                    v2.usuarioNuevo(scanner);
		                    break;
		                case "2":
		                    System.out.println("Fin del programa.");
		                    continuar = false;
		                    break;
		                default:
		                    System.out.println("Opción no válida. Intente de nuevo.");
		            }
		        }
		    }
	  }


import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
public class Cliente {
	private static final String IP = "localhost"; // Puedes cambiar a localhost
	//private static final String IP = "localhost"; // Puedes cambiar a localhost
	private static final int PUERTO = 1099; //Si cambias aquí el puerto, recuerda cambiarlo en el servidor
	
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(IP, PUERTO);
        Interfaz interfaz = (Interfaz) registry.lookup("Ejemplo"); //Buscar en el registro...
		
		String respuesta;
		String nombre;
		Scanner sc = new Scanner(System.in);
		int eleccion=1;
		do {
				System.out.println("Escribe tu nombre:");
				nombre = sc.nextLine();
				
				respuesta = interfaz.hola(nombre);
	                  

                System.out.println("Respuesta => " + respuesta);
                System.out.println("Presiona ENTER para continuar");
                sc.nextLine();
            
        } while (eleccion != -1);
    }
}
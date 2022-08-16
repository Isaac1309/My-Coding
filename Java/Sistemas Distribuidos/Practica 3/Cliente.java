import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {
	private static final String IP = "localhost";
	private static final int PUERTO = 1099;
	
    public static void main(String[] args) throws RemoteException, NotBoundException{
        Registry registry = LocateRegistry.getRegistry(IP, PUERTO);

        Suma suma = (Suma) registry.lookup("Calculadora");
        Resta resta = (Resta) registry.lookup("CalculadoraR");
        Multiplicacion multiplicacion = (Multiplicacion) registry.lookup("CalculadoraM");
        Division division = (Division) registry.lookup("CalculadoraD");

        Scanner sc = new Scanner(System.in);
        int eleccion;
        float numero1, numero2, resultado = 0;
        String menu = "\n\n------------------\n\n[-1] => Salir\n[0] => Sumar\n[1] => Restar\n[2] => Multiplicar\n[3] => Dividir\nElige: ";
		
	do {
            System.out.println(menu);
            try {
                eleccion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                eleccion = -1;
            }

            if(eleccion != -1){
            	System.out.println("Ingresa el número 1: ");
            	try{
                	numero1 = Float.parseFloat(sc.nextLine());
            	}catch(NumberFormatException e){
            		numero1 = 0;
            	}

            	System.out.println("Ingresa el número 2: ");
            	try{
                	numero2 = Float.parseFloat(sc.nextLine());
            	}catch(NumberFormatException e){
            		numero2 = 0;
            	}
                switch (eleccion) {
	                case 0:
	                    resultado = suma.sumar(numero1, numero2);
	                    break;
	                case 1:
	                    resultado = resta.restar(numero1, numero2);
	                    break;
	                case 2:
	                    resultado = multiplicacion.multiplicar(numero1, numero2);
	                    break;
	                case 3:
	                    resultado = division.dividir(numero1, numero2);
	                    break;
	            }

                System.out.println("Resultado => " + String.valueOf(resultado));
                System.out.println("Presiona ENTER para continuar");
                sc.nextLine();
            }
        } while (eleccion != -1);
    }
}
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor {
	private static final int PUERTO = 1099; //Si cambias aquí el puerto, recuerda cambiarlo en el cliente
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {

        Remote remotes = UnicastRemoteObject.exportObject(new Suma() {
            @Override
            public float sumar(float numero1, float numero2) throws RemoteException {
                return numero1 + numero2;
            };
        }, 0);

        Remote remoter = UnicastRemoteObject.exportObject(new Resta() {
            @Override
            public float restar(float numero1, float numero2) throws RemoteException {
                return numero1 - numero2;
            };
        }, 0);

        Remote remotem = UnicastRemoteObject.exportObject(new Multiplicacion() {
            @Override
            public float multiplicar(float numero1, float numero2) throws RemoteException {
                return numero1 * numero2;
            };
        }, 0);

        Remote remoted = UnicastRemoteObject.exportObject(new Division() {
            @Override
            public float dividir(float numero1, float numero2) throws RemoteException {
                return numero1 / numero2;
            };
        }, 0);

        Registry registry = LocateRegistry.createRegistry(PUERTO);
       	System.out.println("Servidor escuchando en el puerto " + String.valueOf(PUERTO));
        registry.bind("Calculadora", remotes);
        registry.bind("CalculadoraR", remoter);
        registry.bind("CalculadoraM", remotem);
        registry.bind("CalculadoraD", remoted);
    }
}
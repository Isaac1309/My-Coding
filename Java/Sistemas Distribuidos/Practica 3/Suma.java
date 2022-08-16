import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Suma extends Remote {
    float sumar(float numero1, float numero2) throws RemoteException;
}
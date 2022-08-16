import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Multiplicacion extends Remote {
    float multiplicar(float numero1, float numero2) throws RemoteException;
}
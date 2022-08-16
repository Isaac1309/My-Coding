import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Division extends Remote {
    float dividir(float numero1, float numero2) throws RemoteException;
}
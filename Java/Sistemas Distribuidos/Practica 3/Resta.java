import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Resta extends Remote {
    float restar(float numero1, float numero2) throws RemoteException;
}
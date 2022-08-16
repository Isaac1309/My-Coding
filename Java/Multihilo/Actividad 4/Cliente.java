import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
/** @author isaac */
public class Cliente extends Thread{
    int tiempo;
    String nombre;
    public Cliente(String nom){
        this.nombre=nom;
    }
    @Override
    public void run(){
        System.out.println("Se inicio el hilo: "+Thread.currentThread().getName()+" "+nombre+".");
        Random random = new Random();
        int numR;
        numR = random.nextInt(5)+1;
        System.out.println("El numero aleatorio es: "+numR+".");
        try {
            tiempo+=numR;
            Thread.sleep(1000*numR);
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Se Termino el hilo: "+Thread.currentThread().getName()+" "+nombre+" en "+numR+" Segundos.");
    }
    public int Time(){
        return tiempo;
    }
}

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/** @author isaac */
public class Pool {
    public static void main(String[] args) {
        int total=0;
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Cliente h1 = new Cliente("Virginia");
        Cliente h2 = new Cliente("Maria");
        Cliente h3 = new Cliente("Javier");
        Cliente h4 = new Cliente("Moises");
        Cliente h5 = new Cliente("Carlos");
        Cliente h6 = new Cliente("Isaac");
        Cliente h7 = new Cliente("Julian");
        Cliente h8 = new Cliente("Josue");
        Cliente h9 = new Cliente("Enid");
        Cliente h10 = new Cliente("Andrea");
        executor.submit(h1);
        executor.submit(h2);
        executor.submit(h3);
        executor.submit(h4);
        executor.submit(h5);
        executor.submit(h6);
        executor.submit(h7);
        executor.submit(h8);
        executor.submit(h9);
        executor.submit(h10);
        executor.shutdown();
        while(!executor.isTerminated()){
            System.out.print("");
        }
        System.out.println("Executor apagado");
        total+=h1.Time();
        total+=h2.Time();
        total+=h3.Time();
        total+=h4.Time();
        total+=h5.Time();
        total+=h6.Time();
        total+=h7.Time();
        total+=h8.Time();
        total+=h9.Time();
        total+=h10.Time();
        System.out.println("La suma del tiempo que tardo cada cliente fue de: "+total+" Segundos.");
    }
}

/** @author isaac */
import java.util.Random;
public class Basura {
    private int pesoBasura = 0;
    private int cantidadBasura = 0;
    private int trabajoIntendente = 0;
    public synchronized void tirarBasura(String nombre){
        Random random=new Random();
        int basura=(random.nextInt(4))+2;
        System.out.println("El alumno: "+nombre+" esta tirando una basura con peso de: "+basura);
        cantidadBasura++;
        pesoBasura = pesoBasura + basura;
        System.out.println("El alumno: "+nombre+" tiro una basura con peso de: "+basura+" el peso total del bote de basura es de: "+pesoBasura);
        if(cantidadBasura == 10){
            System.out.println("El bote de basura esta lleno");
            notifyAll();
        }
        else if(pesoBasura >= 19){
            System.out.println("El peso del bote de basura esta excedido");
            notifyAll();
        }
        else{
        }
        trabajoIntendente++;
    }
    public synchronized int seguirTrabajando(){
        return trabajoIntendente;
    }
    public synchronized void vaciarBote(String nombre){
        try {
            System.out.println("El intendente: "+nombre+" esta esperando");
            wait();
            System.out.println("El intendente: "+nombre+" va al bote de basura");
            pesoBasura=0;
            cantidadBasura=0;
            System.out.println("El intendente: "+nombre+" ha limpiado el bote de basura");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
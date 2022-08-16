/** @author isaac */
public class Intendente extends Thread{
    private String nombre;
    private Basura basura;
    public Intendente(String nombre,Basura basura){
        this.nombre = nombre;
        this.basura = basura;
    }
    public synchronized void run(){
        while(basura.seguirTrabajando()<25){
            basura.vaciarBote(nombre);
        }
        System.out.println("El intendente: "+nombre+" se acaba de ir de la escuela");
    }
}
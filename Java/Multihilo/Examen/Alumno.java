/** @author isaac */
public class Alumno extends Thread{
    private String nombre;
    private Basura basura;
    public  Alumno(String nombre, Basura basura){
        this.nombre = nombre;
        this.basura = basura;
    }
    @Override
    public synchronized void run() {
        for(int i = 0; i<5;i++){
            try {
                basura.tirarBasura(nombre);
                this.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println("El alumno: "+nombre+" se acaba de ir de la escuela");
    }
}
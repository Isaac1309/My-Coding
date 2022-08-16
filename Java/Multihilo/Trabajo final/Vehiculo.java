/** @author isaac */
import java.util.Random;
public class Vehiculo extends Thread{
    private String placa; 
    private String marca;
    private Estacionamiento parking;
    private boolean cerrado = false;
    public Random random = new Random();
    
    public Vehiculo(Estacionamiento parking, String marca, String placa) {
        this.parking = parking;
        this.marca = marca;
        this.placa = placa;
    }
    public synchronized void setValidacion(boolean validacion){
        this.cerrado = validacion;
    }
    
    @Override
    public void run(){
        long tiempoEntrada = ((random.nextInt(5))+1)*1000+3000;
        long tiempo = ((random.nextInt(5))+1)*1000+3000;
        try {
            System.out.println("Inicio el hilo: "+marca+" con las placas de: "+placa);
            this.sleep(tiempoEntrada);
            parking.colocarAuto(this, placa, marca);
            if(cerrado == false){
                this.sleep(tiempo);
                parking.retirarAuto(placa, marca);
                System.out.println("El hilo: "+marca+" con las placas de: "+placa+" a finalizado.");
            }
            else{
                System.out.println("El hilo: "+marca+" a finalizado.");
            }
        } catch (InterruptedException e) {}
    }
}

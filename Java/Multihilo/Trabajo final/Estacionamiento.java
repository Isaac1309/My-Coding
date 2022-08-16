/** @author isaac */
import java.util.concurrent.ArrayBlockingQueue;
public class Estacionamiento {
    private boolean estadoAC = false;
    private boolean dentroE = false;
    private boolean []cajones={false,false,false,false,false}; 
    private ArrayBlockingQueue<String> arrayBQ = new ArrayBlockingQueue<>(5);

    public synchronized void colocarAuto(Vehiculo v,String placa,String marca){
        if(estadoAC == true){
            if (dentroE == false){
                while(arrayBQ.size()==5){
                    try{
                        System.out.println("El vehiculo: "+marca+" INTENTO METERSE pero los cajones estan LLENOS");
                        wait(10000);
                        if(arrayBQ.size()==5){
                            desocuparEstacionamiento(marca);
                        }else{
                            System.out.println("El vehiculo: "+marca+" a REANUDADO la operacion");
                            dentroE = true;
                        }
                    } catch(InterruptedException e){ }
                }
            }
            arrayBQ.add(marca);
            System.out.println("El vehiculo: "+marca+" se ha ESTACINADO");
            mostrarCajones();
        }else{
            System.out.println("El vehiculo: "+marca+" con la placa: "+placa+", se intento ESTACIONAR pero estaba CERRADO");
            v.setValidacion(true);
        }
    }
    public synchronized void retirarAuto(String placa, String marca){
        if(estadoAC == true){
            arrayBQ.remove(marca);
            System.out.println("El vehiculo: "+marca+", se ha RETIRADO");
            mostrarCajones();
            notify();
        }else{
            System.out.println("El vehiculo: "+marca+" se quedo ENCERRADO");
            Thread.currentThread().stop();
        }
    }
    public synchronized void desocuparEstacionamiento(String marca){
        System.out.println("El vehiculo: "+marca+" DESOCUPO el estacionamiento");
        Thread.currentThread().stop();
    }
    public synchronized void abrirEstacionamiento(){
        estadoAC = true;
        System.out.println("El estacionamiento a ABIERTO");
    }
    public synchronized void cerrarEstacionamiento(){
        System.out.println("El estacionamiento a CERRADO, todos los cajones pasaran a estar ocupados");
        estadoAC = false;
        for(int i=0;i<=cajones.length;i++){
            cajones[i]=true;
        }
    }
    public synchronized void mostrarCajones(){
        System.out.println("Cajones: "+arrayBQ);
    }
}

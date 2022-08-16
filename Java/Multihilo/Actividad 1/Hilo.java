package actividad.pkg1.hilos.en.java;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**@author isaac */
public class Hilo extends Thread{
    public Hilo (){}
    @Override
    public void run(){
        boolean es=false;
        int numrmx=1000, numrmn=1;
        int iniNumAle =(int) (Math.random()*(numrmx-numrmn+1)+numrmn);
        while(es==false){
            if(Actividad1HilosEnJava.ni<iniNumAle){
                es=false;
                try {
                    Thread.sleep(500);
                    System.out.println("El numero al azar es: "+iniNumAle+", el numero del usuario es mayor a: "+Actividad1HilosEnJava.ni+".");
                    numrmx=iniNumAle+1;
                    iniNumAle =(int) (Math.random()*(numrmx-numrmn+1)+numrmn);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(Actividad1HilosEnJava.ni>iniNumAle){
                es=false;
                try {
                    Thread.sleep(500);
                    System.out.println("El numero al azar es: "+iniNumAle+", el numero del usuario es menor a: "+Actividad1HilosEnJava.ni+".");
                    numrmn=iniNumAle;
                    iniNumAle =(int) (Math.random()*(numrmx-numrmn+1)+numrmn);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                es=true;
                try {
                    Thread.sleep(500);
                    System.out.println("El numero al azar es: "+iniNumAle+", este es el numero del usuario.");
                } catch (InterruptedException ex) {
                    Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }}
}

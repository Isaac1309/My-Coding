/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad.pkg1.hilos.en.java.redes;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author isaac
 */
public class hilo extends Thread{
    public hilo (){}
    @Override
    public void run(){
        boolean es=false;
        while(es==false){
            Random ran=new Random();
            int iniNumAle=(ran.nextInt(1001));
            if(Actividad1HilosEnJavaRedes.ni<iniNumAle){
                es=false;
                try {
                    Thread.sleep(500);
                    System.out.println("El numero al azar es: "+iniNumAle+", el numero del usuario es mayor a: "+Actividad1HilosEnJavaRedes.ni+".");
                } catch (InterruptedException ex) {
                    Logger.getLogger(hilo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(Actividad1HilosEnJavaRedes.ni>iniNumAle){
                es=false;
                try {
                    Thread.sleep(500);
                    System.out.println("El numero al azar es: "+iniNumAle+", el numero del usuario es menor a: "+Actividad1HilosEnJavaRedes.ni+".");
                } catch (InterruptedException ex) {
                    Logger.getLogger(hilo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                es=true;
                try {
                    Thread.sleep(500);
                    System.out.println("El numero al azar es: "+iniNumAle+", este es el numero del usuario.");
                } catch (InterruptedException ex) {
                    Logger.getLogger(hilo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}

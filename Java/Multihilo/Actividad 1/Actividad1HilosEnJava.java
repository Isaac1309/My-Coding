package actividad.pkg1.hilos.en.java;

import java.util.Scanner;

/**@author isaac */
public class Actividad1HilosEnJava {
    public static int ni;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Hilo hilito=new Hilo();
        System.out.println("Inserta un numero del 0 al 1000");
        ni= in.nextInt();
        hilito.start();
            System.out.println("Hilo iniciado");
    }
}

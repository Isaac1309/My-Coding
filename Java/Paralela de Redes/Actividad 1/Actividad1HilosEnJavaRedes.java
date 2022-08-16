/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad.pkg1.hilos.en.java.redes;

import java.util.Scanner;

/**
 *
 * @author isaac
 */
public class Actividad1HilosEnJavaRedes {
    public static int hl, ni;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        hilo hilito=new hilo();
        System.out.println("Inserta un numero del 0 al 1000");
        ni= in.nextInt();
        hilito.start();
            System.out.println("Hilo iniciado");
    }
    
}

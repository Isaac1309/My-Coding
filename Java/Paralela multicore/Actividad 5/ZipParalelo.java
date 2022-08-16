/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad.pkg5.fuerza.bruta;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

/**
 *
 * @author isaac
 */
public class ZipParalelo {
    String arreglo[]=new String [1000000];
    
    public ZipParalelo() throws InterruptedException, ExecutionException {
        Scanner s = new Scanner(System.in);
        String option = "";

        while(!option.equals("s")){
            System.out.println("a) Descomprimir \ns) Salir");
            option = s.nextLine();
            switch(option){
                case "a":
                    for(int i=0;i<arreglo.length;i++){
                        if(i<10){
                            arreglo[i] = "00000"+i;
                        }else if(i<100){
                            arreglo[i] = "0000"+i;
                        }else if(i<1000){
                            arreglo[i] = "000"+i;
                        }else if(i<10000){
                            arreglo[i] = "00"+i;
                        }else if(i<100000){
                            arreglo[i] = "0"+i;
                        }else{
                            arreglo[i] = ""+i;
                        }
                    }
                    ZipPass descomprimirZip = new ZipPass(arreglo, 0, arreglo.length);
                    ForkJoinPool pool = new ForkJoinPool();
                    pool.execute(descomprimirZip);
                    pool.shutdown();
                break;
                case "s":
                    break;
                default:
                    break;
            }
        }
        s.close();
    }
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        new ZipParalelo();
    }
}

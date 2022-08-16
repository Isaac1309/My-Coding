/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrón.fork.join;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author isaac
 */
public class PatrónForkJoin {
    int arreglo[]=new int [100];
    Random random = new Random();

    public PatrónForkJoin() throws InterruptedException, ExecutionException {
        Scanner s = new Scanner(System.in);
        String option = "";
        for(int i = 0; i < arreglo.length; i++) {
            arreglo[i]=random.nextInt(100);
        }
        int i=0;
        System.out.print("Arreglo: { ");
        for(i=0; i<arreglo.length; i++){
            System.out.print(i+":"+arreglo[i]+", ");
        }
        System.out.print("}");
        i=0;

        while(!option.equals("s")){
            System.out.println("\n\n a) Replasar numeros primos con -1 \n b) Contar numeros primos \n s) Salir");
            option = s.nextLine();
            switch(option){
                case "a":
                    Remplasar task1 = new Remplasar(arreglo, 0, arreglo.length);
                    ForkJoinPool pool = new ForkJoinPool();
                    pool.execute(task1);
                    pool.shutdown();
                    if (task1.isCompletedNormally())
                        System.out.format("\n\nCompletado");
                    System.out.print("\n\nResultado del arreglo: { ");
                    for(int primeNumber : arreglo) {
                        System.out.print(i+":"+primeNumber+", ");
                        i++;
                    }
                    System.out.print(" }");
                break;
                case "b":
                    Contar task2 = new Contar(arreglo, 0, arreglo.length);
                    ForkJoinPool pool1 = new ForkJoinPool();
                    pool1.execute(task2);
                    pool1.shutdown();
                    if (task2.isCompletedNormally())
                        System.out.format("\n\nCompletado");
                    System.out.println("Total de numeros primos encontrados: "+ task2.get());
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
        new PatrónForkJoin();
    }
}

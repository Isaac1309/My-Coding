import java.util.Random;
/**@author isaac */
public class Hilo extends Thread{
    @Override
    public void run(){
        Random random = new Random();
        int[] arreglo = {11,11,11,11,11,11,11,11,11,11};
        int numR, full=0;
        boolean rep=false;
        long start = System.currentTimeMillis();
        while(full<=9){
            numR = random.nextInt(10);
            System.out.println("El numero aleatorio es: "+numR);
            for(int r=0; r<arreglo.length;r++){
                if(arreglo[r]==numR){
                    rep=true;
                }
            }
            if(rep==true){
                rep=false;
            }else{
                arreglo[full]=numR;
                full++;
                System.out.println("-------------------------");
                System.out.println("|Se inserto el numero: "+numR+"|");
                System.out.println("-------------------------");
            }
        }
        long end = System.currentTimeMillis();
        long elapsedTime = end - start;
        for(int imp=0; imp<arreglo.length;imp++){
            if(imp==0){
                System.out.print("["+arreglo[imp]+", ");
            }else if(imp<9){
                System.out.print(arreglo[imp]+", ");
            }else{
                System.out.println(arreglo[imp]+"]");
            }
        }
        System.out.println("Duro: "+elapsedTime+" milisegundos.");
    }
}

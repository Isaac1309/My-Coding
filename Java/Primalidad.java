import java.util.Scanner;
public class Primalidad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num=0;
        boolean p=false;
        System.out.println("Inserta un numero para saber si es Numero Primo");
        num = scanner.nextInt();
        scanner.close();
        p = primo(num);
        if(p==true){
            System.out.println("Es un numero primo");
        }else{
            System.out.println("No es un numero primo");
        }
    }

    static boolean primo(int num){
        boolean r=true;
        for(int i=2;i<num;i++){
            if(num%i==0){
                r=false;
                return r;
            }
        }
        return r;
    }
}

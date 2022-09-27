import java.util.Scanner;

public class Palindromo {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String p;

        System.out.println("Ingresa el primer numero:");
        p=read.nextLine();
        read.close();

        if(primo(p)==true){
            System.out.println(p+" es palindromo");
        }else{
            System.out.println(p+" no es palindromo");
        }
    }

    static boolean primo(String c){
        StringBuilder compara=new StringBuilder();
        c=c.replace(" ", "");
        c=c.toLowerCase();
        for(int i=c.length()-1;i>=0;i--){
            compara.append(c.charAt(i));
        }
        return c.equals(compara.toString());
    }
}

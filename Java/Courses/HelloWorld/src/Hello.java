import java.util.Scanner;
public class Hello {
    public static void main(String[] args){
        System.out.println("Hello world");
        System.out.println("Please, write your name");
        Scanner in=new Scanner(System.in);
        String s= in.nextLine();
        System.out.println("Hello, "+s+".");
        //-----------------
        //Tipe of variables:
        int myFirstNumber=0;
        System.out.println("Number "+myFirstNumber+".");
    }
}

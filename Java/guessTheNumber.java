import java.util.Scanner;
import javax.lang.model.element.Element;

public class guessTheNumber {
    public static Scanner read = new Scanner(System.in);
    public static void main(String[] args) {
        int difficulty;
        System.out.println("Bienvenido a Adivina el Numero");
        BreakIt:
        while(true){
            System.out.println("Por favor seleccione la dificultad: ");
            System.out.println("Facil: 1");
            System.out.println("Medio: 2");
            System.out.println("Dificil: 3");
            System.out.println("Salir: 4");
            difficulty=read.nextInt();

            switch(difficulty){
                case 1:
                    play(10);
                    break;
                case 2:
                    play(7);
                    break;
                case 3:
                    play(5);
                    break;
                case 4:
                    System.out.println("Gracias por jugar");
                    break BreakIt;
                default:
                    System.out.println("Error: Por favor selecciona una opcion");
                    break;
            }
        }
    }

    static void play(int lives){
        int numRandom = (int)(Math.random()*101);
        int selectNum = -1;

        while(selectNum!=numRandom){
            System.out.println("Ingrese un numero entre 1 y 100");
            selectNum =read.nextInt();
            if(numRandom<selectNum){
                System.out.println("El numero es mas pequeño");
                lives--;
            }else if(numRandom>selectNum){
                System.out.println("El numero es mas grande");
                lives--;
            }
            if(lives==0){
                System.out.println("Game Over");
                break;
            }
            System.out.println("Te quedan "+lives+" vidas");
        }
        
        if(selectNum==numRandom){
            System.out.println("You are a WINNER");
        }
    }
}

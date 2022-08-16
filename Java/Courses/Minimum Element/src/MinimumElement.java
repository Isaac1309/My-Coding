import java.util.Scanner;

public class MinimumElement {
    public static int readInteger(){
        Scanner scanner = new Scanner(System.in);
        int values = scanner.nextInt();
        scanner.close();
        return values;
    }

    public static int[] readElements(int number){
        int[] values=new int[number];
        Scanner scanner = new Scanner(System.in);
        for (int i=0;i<values.length;i++){
            values[i]=scanner.nextInt();
        }
        scanner.close();
        return values;
    }

    public static int findMin(int[] passedArray){
        int minimum=passedArray[0];
        for (int i=0;i<passedArray.length;i++){
            if (passedArray[i]<=minimum){
                minimum=passedArray[i];
            }
        }
        return minimum;
    }
}

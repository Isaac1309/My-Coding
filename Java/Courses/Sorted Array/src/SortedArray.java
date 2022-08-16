import java.util.Scanner;

public class SortedArray {
    public static void printArray(int[] array){
        for (int i=0;i<array.length;i++){
            System.out.println("Element "+i+" contents "+array[i]);
        }
    }

    public static int[] getIntegers(int number){
        int[] values=new int[number];
        Scanner scanner=new Scanner(System.in);
        for (int i=0;i<values.length;i++){
            values[i]=scanner.nextInt();
        }
        return values;
    }

    public static int[] sortIntegers(int[] passedArray){
        int[] sortedArray=new int[passedArray.length];
        int position=0, highest;
        boolean isMax=false;
        for (int i=0;i<passedArray.length;i++){
            highest=passedArray[i];
            for (int j=0;j<passedArray.length;j++){
                if (passedArray[j]>=highest){
                    highest=passedArray[j];
                    position=j;
                    isMax=true;
                }
            }
            if (isMax){
                sortedArray[i] = highest;
                passedArray[position]=Integer.MIN_VALUE;
                isMax=false;
            }
        }
        return sortedArray;
    }
}
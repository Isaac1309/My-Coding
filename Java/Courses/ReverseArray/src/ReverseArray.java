import java.util.Arrays;

public class ReverseArray {
    public static void reverse(int[] array){
        int first=0, last=array.length-1, container;
        System.out.print("Array = "+ Arrays.toString(array));
        while (last>first){
            container=array[first];
            array[first]=array[last];
            array[last]=container;
            first++;
            last--;
        }
        System.out.print("Reversed array = "+ Arrays.toString(array));
    }
}
import java.lang.reflect.Array;
import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        String str1="restful";
        String str2="fluster";
        char[] order=str1.toCharArray();
        Arrays.sort(order);
        str1=new String(order);
        order=str2.toCharArray();
        Arrays.sort(order);
        str2=new String(order);
        if(str1.equals(str2)){
            System.out.println("True the strings are anagrams");
        }else{
            System.out.println("False the strings are not anagrams");
        }
    }
}

public class Palindrome {
    public static void main(String[] args) {
        String str1="Ana";
        char[] arr=str1.toLowerCase().toCharArray();
        int i1=0, i2=arr.length-1;
        while(i1!=i2){
            if(arr[i1]!=arr[i2]){
                System.out.println("The string is not a palindrome");
                break;
            }
            i1++;
            i2--;
        }
        if(i1==i2) System.out.println("The string is a palindrome");
    }
}

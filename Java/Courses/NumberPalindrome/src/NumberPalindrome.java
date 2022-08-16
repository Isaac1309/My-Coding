public class NumberPalindrome {
    public static boolean isPalindrome(int number){
        int reverse = 0, original=number, remainder;
        while (number!=0){
            remainder=number%10;
            reverse=reverse*10+remainder;
            number/=10;
        }
        if (original==reverse) return true;
        return false;
    }
}

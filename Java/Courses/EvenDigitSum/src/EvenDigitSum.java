public class EvenDigitSum {
    public static int getEvenDigitSum(int number){
        int sum=0, original=number, remainder;
        if (number>=0){
            while (number!=0) {
                remainder=number%10;
                if (remainder%2==0)sum+=remainder;
                number/=10;
            }
            return sum;
        }
        return -1;
    }
}

public class GreatestCommonDivisor {
    public static int getGreatestCommonDivisor(int first, int second){
        int remainder=100;
        if (first>=10&&second>=10){
            while (remainder!=0){
                if (first%remainder==0&&second%remainder==0)
                    return remainder;
                remainder--;
            }
        }
        return -1;
    }
}

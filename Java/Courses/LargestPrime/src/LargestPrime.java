public class LargestPrime {
    public static int getLargestPrime(int number){
        if (number>=2) {
            for (int lP=2;lP<number;lP++){
                if (number%lP==0){
                    number/=lP;
                    lP--;
                }
            }
            return number;
        }
        return -1;
    }
}

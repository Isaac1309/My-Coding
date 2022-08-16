public class IntegerReversion {
    public int reverse(int n){
        int reversed=0;
        int remainder=0;
        while (n>0){
            remainder=n%10;
            System.out.println("n%10 ="+remainder);
            n=n/10;
            System.out.println("n/10 ="+n);
            reversed =reversed*10+remainder;
            System.out.println("reversed*10+remainder ="+reversed);
        }
        return reversed;
    }
}

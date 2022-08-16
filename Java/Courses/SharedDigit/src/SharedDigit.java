public class SharedDigit {
    public static boolean hasSharedDigit(int number1, int number2){
        int remainder1,remainder2, original2=number2;
        if (number1>=10&&number1<=99&&number2>=10&&number2<=99){
            while (number1!=0) {
                remainder1=number1%10;
                while (number2!=0) {
                    remainder2=number2%10;
                    if (remainder1 == remainder2) {
                        return true;
                    }
                    number2/=10;
                }
                number1/=10;
                number2=original2;
            }
        }
        return false;
    }
}

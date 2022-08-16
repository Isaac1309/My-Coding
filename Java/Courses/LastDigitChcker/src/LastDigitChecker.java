public class LastDigitChecker {
    public static boolean hasSameLastDigit(int number1, int number2, int number3){
        int remainder1,remainder2,remainder3;
        if (isValid(number1)&&isValid(number2)&&isValid(number3)){
            remainder1=number1%10;
            remainder2=number2%10;
            remainder3=number3%10;
            if (remainder1==remainder2||remainder1==remainder3||remainder2==remainder3){
                return true;
            }
        }
        return false;
    }
    public static boolean isValid(int number){
        if (number>=10&&number<=1000){
            return true;
        }
        return false;
    }
}

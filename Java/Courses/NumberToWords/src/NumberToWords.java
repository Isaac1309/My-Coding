public class NumberToWords {
    public static int getDigitCount(int number){
        if (number>=0){
            int i=0;
            do {
                i++;
                number/=10;
            } while (number!=0);
            return i;
        }
        return -1;
    }
    public static int reverse(int number){
        int reverse = 0, remainder;
        while (number!=0){
            remainder=number%10;
            reverse=reverse*10+remainder;
            number/=10;
        }
        return reverse;
    }
    public static void numberToWords(int number){
        if (number>=0){
            int nReverse=reverse(number), remainder;
            for (int i=0;i<getDigitCount(number);i++){
                remainder=nReverse%10;
                switch (remainder){
                    case 0:
                        System.out.println("Zero");
                        break;
                    case 1:
                        System.out.println("One");
                        break;
                    case 2:
                        System.out.println("Two");
                        break;
                    case 3:
                        System.out.println("Three");
                        break;
                    case 4:
                        System.out.println("Four");
                        break;
                    case 5:
                        System.out.println("Five");
                        break;
                    case 6:
                        System.out.println("Six");
                        break;
                    case 7:
                        System.out.println("Seven");
                        break;
                    case 8:
                        System.out.println("Eight");
                        break;
                    case 9:
                        System.out.println("Nine");
                        break;
                    default:
                        break;
                }
                nReverse/=10;
            }
        }else{
            System.out.println("Invalid Value");
        }
    }
}

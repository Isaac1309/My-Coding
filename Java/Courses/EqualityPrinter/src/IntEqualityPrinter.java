public class IntEqualityPrinter {
    public static void printEqual(int fParameter,int sParameter,int tParameter){
        if (fParameter<0||sParameter<0||tParameter<0) System.out.println("Invalid Value");
        else {
            if (fParameter==sParameter&&fParameter==tParameter) System.out.println("All numbers are equal");
            else if (fParameter!=sParameter&&fParameter!=tParameter&&sParameter!=tParameter) System.out.println("All numbers are different");
            else if (fParameter!=sParameter&&fParameter!=tParameter&&sParameter!=tParameter) System.out.println("All numbers are different");
            else System.out.println("Neither all are equal or different");
        }
    }
}

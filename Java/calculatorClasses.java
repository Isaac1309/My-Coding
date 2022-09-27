public class calculatorClasses {
    public static void main(String[] args) {
        System.out.println(Calculator.sum(1,2,3,4));
        System.out.println(Calculator.sum(1.2,2.8,3.7,4.3));
        System.out.println(Calculator.subtraction(1,2,3,4));
        System.out.println(Calculator.subtraction(1.2,2.8,3.7,4.3));
        System.out.println(Calculator.multiplication(1,2,3,4));
        System.out.println(Calculator.multiplication(1.2,2.8,3.7,4.3));
        System.out.println(Calculator.divide(12,4));
        System.out.println(Calculator.divide(128.0,3.0));
    }
}

public class Calculator{
    public static final double PI=3.141592;
    
    public static int sum(int... num){
        int sum=0;
        for (int i=0;i<num.length;i++) {
            sum+=num[i];
        }
        return sum;
    }
    public static double sum(double... num){
        double sum=0;
        for (int i=0;i<num.length;i++) {
            sum+=num[i];
        }
        return sum;
    }

    public static int subtraction(int... num){
        int sub=0;
        for (int i=0;i<num.length;i++) {
            sub-=num[i];
        }
        return sub;
    }
    public static double subtraction(double... num){
        double sub=0;
        for (int i=0;i<num.length;i++) {
            sub-=num[i];
        }
        return sub;
    }


    public static int multiplication(int... num){
        int mul=1;
        for (int i=0;i<num.length;i++) {
            mul*=num[i];
        }
        return mul;
    }
    public static double multiplication(double... num){
        double mul=1;
        for (int i=0;i<num.length;i++) {
            mul*=num[i];
        }
        return mul;
    }


    public static int divide(int num1, int num2){
        int divi=num1/num2;
        return divi;
    }
    public static double divide(double num1, double num2){
        double divi=num1/num2;
        return divi;
    }

}

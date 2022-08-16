import java.util.Scanner;
public class InputCalculator {
    public static void inputThenPrintSumAndAverage(){
        Scanner scanner=new Scanner(System.in);
        double number=0, count=0;
        double average=0;
        boolean b=true;
        while (b){
            b= scanner.hasNextInt();
            if (b){
                number+= scanner.nextInt();
                count++;
            }
        }
        if (number==0){
            System.out.println("SUM = 0 AVG = 0");
        }else{
            average = (double) Math.ceil(number / count);
            System.out.println("SUM = " + (int)number + " AVG = " + (long)average);
        }
        scanner.close();
    }
}

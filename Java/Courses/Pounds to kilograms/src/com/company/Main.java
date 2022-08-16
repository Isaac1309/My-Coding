package com.company;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Please, write how many Pounds you want to convert to a Kilograms:");
        Scanner in=new Scanner(System.in);
        Double d= in.nextDouble();
        Double result= d * 0.45359237;
        System.out.println("The result is: "+result);
    }
}

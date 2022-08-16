package com.company;

public class Main {
    public static void main(String[] args) {
        int myMinIntValue= Integer.MIN_VALUE;
        int myMaxIntValue= Integer.MAX_VALUE;
        System.out.println("Integer Minimum Value = "+myMinIntValue);
        System.out.println("Integer Maximum Value = "+myMaxIntValue);
        System.out.println("Busted Max Value = "+(myMaxIntValue+1));
        System.out.println("Busted Min Value = "+(myMinIntValue-1));

        byte myMinByteValue= Byte.MIN_VALUE;
        byte myMaxByteValue= Byte.MAX_VALUE;
        System.out.println("Byte Minimum Value = "+myMinByteValue);
        System.out.println("Byte Maximum Value = "+myMaxByteValue);
        System.out.println("Busted Max Value = "+(myMaxByteValue+1));
        System.out.println("Busted Min Value = "+(myMinByteValue-1));

        short myMinShortValue= Short.MIN_VALUE;
        short myMaxShortValue= Short.MAX_VALUE;
        System.out.println("Byte Minimum Value = "+myMinShortValue);
        System.out.println("Byte Maximum Value = "+myMaxShortValue);
        System.out.println("Busted Max Value = "+(myMaxShortValue+1));
        System.out.println("Busted Min Value = "+(myMinShortValue-1));

        long myMinLongValue= Long.MIN_VALUE;
        long myMaxLongValue= Long.MAX_VALUE;
        System.out.println("Byte Minimum Value = "+myMinLongValue);
        System.out.println("Byte Maximum Value = "+myMaxLongValue);
        System.out.println("Busted Max Value = "+(myMaxLongValue+1));
        System.out.println("Busted Min Value = "+(myMinLongValue-1));

        float myMinFloatValue= Float.MIN_VALUE;
        float myMaxFloatValue= Float.MAX_VALUE;
        System.out.println("Byte Minimum Value = "+myMinFloatValue);
        System.out.println("Byte Maximum Value = "+myMaxFloatValue);

        double myMinDoubleValue= Double.MIN_VALUE;
        double myMaxDoubleValue= Double.MAX_VALUE;
        System.out.println("Byte Minimum Value = "+myMinDoubleValue);
        System.out.println("Byte Maximum Value = "+myMaxDoubleValue);

        float myFloat = 11f/3f;
        System.out.println("Float = "+myFloat);
        double myDouble = 11.00/3.00;
        System.out.println("Float = "+myDouble);
    }
}

public class DecimalComparator {
    public static boolean areEqualByThreeDecimalPlaces(double firstDouble, double secondDouble){
        int myFirstCheck = (int)(firstDouble * 1000);
        int mySecondCheck = (int)(secondDouble * 1000);
        if(myFirstCheck - mySecondCheck == 0){
            return true;
        }
        return false;
    }
}

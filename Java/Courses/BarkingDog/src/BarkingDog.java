public class BarkingDog {
    public static boolean shouldWakeUp(boolean currentlyBarking, int hourOfDay){
        if (hourOfDay >= 0 && hourOfDay <= 23) {
            if (!currentlyBarking) {
                System.out.println("Dog is not barking");
            } else if (hourOfDay < 8 || hourOfDay > 22) {
                return true;
            }
            return false;
        }
        return false;
    }
}

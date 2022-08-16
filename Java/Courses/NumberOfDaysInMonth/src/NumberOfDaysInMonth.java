public class NumberOfDaysInMonth {
    public static boolean isLeapYear(int year){
        if (year > 0 && year <= 9999) {
            if (year%4==0) {
                if (year%100==0){
                    if (year%400==0){
                        return true;
                    }
                    return false;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public static int getDaysInMonth(int month, int year){
        if (year > 0 && year <= 9999 && month>0 && month<13) {
            switch (month){
                case 1: case 3: case 5:  case 7: case 8:  case 10: case 12:
                    return 31;
                case 4: case 6: case 9: case 11:
                    return 30;
                case 2:
                    if(isLeapYear(year)) return 29;
                    return 28;
            }
        }
        return -1;
    }
}

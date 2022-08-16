public class TeenNumberChecker {
    public static boolean hasTeen(int fInt, int sInt, int tInt){
        if(fInt>12&&fInt<20||sInt>12&&sInt<20||tInt>12&&tInt<20){
            return true;
        }
        return false;
    }
    public static boolean isTeen(int fInt){
        if(fInt>12&&fInt<20){
            return true;
        }
        return false;
    }
}

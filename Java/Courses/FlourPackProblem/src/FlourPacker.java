public class FlourPacker {
    public static boolean canPack(int bigCount, int smallCount, int goal){
        if (goal>=0) {
            for (int b=(bigCount*5);b>=0;b-=5){
                if (b==goal) return true;
                for (int s=smallCount;s>=0;s--){
                    if (b+s==goal) return true;
                }
            }
        }
        return false;
    }
}

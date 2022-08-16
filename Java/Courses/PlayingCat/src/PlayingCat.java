public class PlayingCat {
    public static boolean isCatPlaying(boolean summer, int temperature){
        if (summer && temperature > 24 && temperature < 46) return true;
        if (!summer && temperature > 24 && temperature < 36) return true;
        return false;
    }
}

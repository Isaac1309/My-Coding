public class Main {
    public static void main(String[] args) {
        KMPAlgorithm search = new KMPAlgorithm("This is a test", "test");
        //We obtain the position where the string meets the search condition (counting the spaces)
        search.search();
    }
}

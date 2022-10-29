public class Main{
    public static void main(String[] args){
        RabinKarp search = new RabinKarp();
        //We obtain the position where the string meets the search condition (counting the spaces)
        System.out.println(search.search("This is a test", "test"));
    }
}
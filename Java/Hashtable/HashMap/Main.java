import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(1,"Adam");
        map.put(2,"Brandom");
        map.put(3,"Andy");
        map.put(40,"Betty");

        System.out.println("Different forms to print all information on the map");
        System.out.println("\nUsing the key: ");
        for(Integer key : map.keySet())
            System.out.println(map.get(key));

        System.out.println("\nUsing Entry: ");
        for(Map.Entry<Integer, String> entry : map.entrySet())
            System.out.println(entry.getKey()+" "+entry.getValue());

        System.out.println("\nUsing remove: ");
        map.remove(2);
        for(Map.Entry<Integer, String> entry : map.entrySet())
            System.out.println(entry.getKey()+" "+entry.getValue());
    }
}

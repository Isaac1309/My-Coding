import java.util.HashMap;
import java.util.Map;

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

        System.out.println("\n\nUsing a class 'Person' like a Key in a HashMap: ");
        Map<Person, String> mapPerson = new HashMap<>();
        Person person = new Person("John", 32);

        mapPerson.put(new Person("Juan", 16),"Perez");
        mapPerson.put(person,"Doe");

        System.out.println("\nUsing Entry: ");
        for(Map.Entry<Person, String> entry : mapPerson.entrySet())
            System.out.println(entry.getKey()+" "+entry.getValue());
    }
}

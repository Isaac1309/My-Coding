import java.util.HashMap;
import java.util.Map;

public class ClassMap {
    public static void main(String[] args) {
        Map numbers = new HashMap();
        numbers.put(1, "One");
        numbers.put(2, "Two");
        numbers.put(3, "Three");
        numbers.put(4, "Four");
        numbers.put(5, "Five");

        System.out.println("Diferent forms to work the Map/HashMap:");

        System.out.println("\nPrint the Map directly:");
        System.out.println(numbers);

        System.out.println("\nPrint an element from the Map:");
        System.out.println(numbers.get(1));

        System.out.println("\nPrint the value from Map with a Loop (For/ForEach):");
        for (Object obj : numbers.values()) {
            System.out.println(obj);
        }

        System.out.println("\nPrint the key from Map with a Lambda Expression:");
        numbers.keySet().forEach(obj -> {
            System.out.println(obj);
        });

        System.out.println("\nPrint the key and value from Map with a Lambda Expression:");
        numbers.keySet().forEach(obj -> {
            System.out.println(obj+" "+ numbers.get(obj));
        });
        
        System.out.println("\nRemove an element with the key from the Map:");
        System.out.println(numbers);
        numbers.remove(5);
        System.out.println(numbers);
        
        System.out.println("\nRemove all elements from the Map:");
        System.out.println(numbers);
        numbers.clear();
        System.out.println(numbers);
    }
}

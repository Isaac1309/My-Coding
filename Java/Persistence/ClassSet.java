import java.util.HashSet;

public class ClassSet {
    public static void main(String[] args) {
        HashSet days = new HashSet();
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        days.add("Sunday");
        days.add("Sunday");
        // The HashSet doesn't have an order and can't repite an element
        System.out.println("Diferent forms to work the Set/HashSet:");
        
        System.out.println("\nPrint the HashSet with a Loop (For/ForEach):");
        for (Object obj : days) {
            System.out.println(obj);
        }

        System.out.println("\nPrint the HashSet with a Lambda Expression:");
        days.forEach(obj -> {
            System.out.println(obj);
        });

        System.out.println("\nRemove an element from the HashSet:");
        System.out.println(days);
        days.remove("Monday");
        System.out.println(days);

        System.out.println("\nRemove all elements from the list:");
        System.out.println(days);
        days.clear();
        System.out.println(days);
    }
}

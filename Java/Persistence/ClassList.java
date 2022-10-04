import java.util.ArrayList;

public class ClassList {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add(1);
        list.add("String");
        list.add(25);
        list.add(12.06);
        list.add(true);
        System.out.println("Diferent forms to work a list:");
        
        System.out.println("\nPrint the list directly:");
        System.out.println(list);

        System.out.println("\nPrint the list with a Loop (For/ForEach):");
        for (Object object : list) {
            System.out.println(object);
        }

        System.out.println("\nPrint the list with a Lambda Expression:");
        list.forEach(object ->{
            System.out.println(object);
        });

        System.out.println("\nPrint an element from the list with Instances:");
        System.out.println(list.get(1));

        System.out.println("\nRemove an element from the list:");
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
        
        System.out.println("\nEdit an element from the list:");
        System.out.println(list);
        list.set(0, list.get(0)+" edited");
        System.out.println(list);
        
        System.out.println("\nRemove all elements from the list:");
        System.out.println(list);
        list.clear();
        System.out.println(list);
    }
}

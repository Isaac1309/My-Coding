public class Main {
    public static void main(String[] args) {
        System.out.println("Working with a Stack class that I create");
        System.out.println("Stacks with LinkedList of String");
        Stack<String> names = new Stack<>();

        names.push("Juan");
        names.push("Pedro");
        names.push("Jose");
        names.push("Maria");

        while(!names.isEmpty()){
            System.out.println(names.pop());
        }
        
        System.out.println("\nStacks with LinkedList of Integer");
        Stack<Integer> number = new Stack<>();

        number.push(1);
        number.push(2);
        number.push(3);
        number.push(4);

        while(!number.isEmpty()){
            System.out.println(number.pop());
        }
    }
}

public class Main{
    public static void main(String[] args) {
        System.out.println("Working with the class Stack in java");
        Stack<String> stack = new Stack<>();
        
        stack.push("Juan");
        stack.push("Pedro");
        stack.push("Jose");
        stack.push("Maria");

        System.out.println("Using peek() from Stack");
        System.out.println(stack.peek());
        System.out.println("Check the size() of the Stack");
        System.out.println(stack.size());

        System.out.println("Using pop() from Stack");
        System.out.println(stack.pop());
        System.out.println("Check the size() of the Stack");
        System.out.println(stack.size());
        

        System.out.println("Using a while isEmpty() with pop() from Stack");
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
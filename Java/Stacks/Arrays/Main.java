public class Main {
    public static void main(String[] args) {
        System.out.println("Stacks with Arrays");
        Stack<Integer> number = new Stack<>();

        number.push(1);
        number.push(2);
        number.push(3);
        number.push(4);
        number.push(5);
        number.push(6);

        while(!number.isEmpty()){
            System.out.println(number.pop());
        }
    }
}

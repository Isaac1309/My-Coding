public class passwordGenerator {
    public static void main(String[] args) {
        System.out.println(generator());
    }

    static String generator(){
        char[] upper = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        char[] lower = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        char[] numbers = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        
        StringBuilder chain = new StringBuilder();
        chain.append(upper);
        chain.append(lower);
        chain.append(numbers);

        StringBuilder password = new StringBuilder();

        for(int i=0;i<=16;i++){
            int amountChain=chain.length();
            int randomNum=(int)(Math.random()*amountChain);
            password.append(chain.toString().charAt(randomNum));
        }
        
        return password.toString();
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Challenges {
    public static void main(String[] args) {
        System.out.println("Challenge 1");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String myString = "Let's split this up into an array";
                String[] parts = myString.split(" ");
                for (String part: parts) {
                    System.out.println(part);
                }
            }
        };
        runnable.run();

        System.out.println("-----------");

        Runnable runnable1=()->{
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for (String part: parts) {
                System.out.println(part);
            }
        };
        runnable1.run();

        System.out.println("\nChallenge 2");

        /**StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 1) {
                returnVal.append(s.charAt(i));
            }
        }
        return returnVal.toString();*/

        System.out.println("-----------");

        Function<String,String> lambdaFunction = s->{
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++)
                if (i % 2 == 1)
                    returnVal.append(s.charAt(i));
            return returnVal.toString();
        };

        System.out.println("\nChallenge 3");
        System.out.println(lambdaFunction.apply("123456789"));

        System.out.println("\nChallenge 5");
        System.out.println(everySecondCharacter(lambdaFunction,"123456789"));

        System.out.println("\nChallenge 6");
        Supplier<String> iLoveJava = ()-> {
            return  "I love Java!";
        };

        System.out.println("\nChallenge 7");
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);

        System.out.println("\nChallenge 9");
        List<String> topNames2015= Arrays.asList(
                "Amelia","Olivia","emily","Isla","Ava",
                "oliver","Jack","Charlie","harry","Jacob"
        );
        List<String> firstUpperCaseList = new ArrayList<>();
        topNames2015.forEach(name -> firstUpperCaseList.add(name.substring(0,1)
                .toUpperCase()+name.substring(1)));
        firstUpperCaseList.sort((s1,s2)->s1.compareTo(s2));
        firstUpperCaseList.forEach(System.out::println);

        System.out.println("\nChallenge 10");
        firstUpperCaseList.sort(String::compareTo);
        firstUpperCaseList.forEach(System.out::println);

        System.out.println("\nChallenge 11");
        topNames2015.stream().map(name->name.substring(0,1).toUpperCase()+name.substring(1))
                .sorted(String::compareTo).forEach(System.out::println);

        System.out.println("\nChallenge 12");
        long namesBeginningWithA = topNames2015.stream()
                .map(name->name.substring(0,1).toUpperCase()+name.substring(1))
                .filter(name-> name.startsWith("A")).count();
        System.out.println("Number of names beginning with A is: "+namesBeginningWithA);

        System.out.println("\nChallenge 13");
        topNames2015.stream()
                .map(name->name.substring(0,1).toUpperCase()+name.substring(1))
                .peek(System.out::println).sorted(String::compareTo).count();

        System.out.println("\nChallenge 14");
        topNames2015.stream()
                .map(name->name.substring(0,1).toUpperCase()+name.substring(1))
                .peek(System.out::println).sorted(String::compareTo).collect(Collectors.toList());
    }

    /**Challenge 8*/
    Callable<Integer> callableSome = () -> { return 2*3; };

    /**Challenge 4*/
    public static String everySecondCharacter(Function<String,String> func, String str){
        return func.apply(str);
    }
}

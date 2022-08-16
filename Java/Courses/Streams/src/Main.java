import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList(
                "N40","N36","B12","B6","G53","G49", "g64",
                "G60","G50","I26","I17","I29","O71");

        List<String> gNumbers = new ArrayList<>();

        /**someBingoNumbers.forEach(number -> {
            if (number.toUpperCase().startsWith("G")){
                gNumbers.add(number);
                System.out.println(number);
            }
        });
        System.out.println("===");

        gNumbers.sort((s1, s2)->s1.compareTo(s2));
        gNumbers.forEach(number-> System.out.println(number));*/

        someBingoNumbers.stream().map(String::toUpperCase)
                .filter(s->s.startsWith("G")).sorted()
                .forEach(System.out::println);

        Stream<String> ioNumberStream = Stream.of("I26","I17","I29","O71");
        Stream<String> inNumberStream = Stream.of("N40","N36","I26","I17","I29","O71");
        Stream<String> concatStream = Stream.concat(inNumberStream,ioNumberStream);
        System.out.println("---");
        System.out.println(concatStream.distinct().peek(System.out::println).count());

        Employee john = new Employee("John Doe", 30);
        Employee jack = new Employee("Jack Ripper", 25);
        Employee juan = new Employee("Juan Martinez", 40);
        Employee jane = new Employee("Jane The Virginie", 22);

        Department hr = new Department("Human Resources");
        hr.addEmployee(john);
        hr.addEmployee(jack);
        hr.addEmployee(jane);
        Department accounting = new Department("Accounting");
        accounting.addEmployee(juan);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

         departments.stream().flatMap(department -> department.getEmployees().stream())
                 .forEach(System.out::println);

        System.out.println("--------------");
        /**List<String> sortedGNumbers = someBingoNumbers.stream()
                .map(String::toUpperCase)
                .filter(s->s.startsWith("G")).sorted()
                .collect(Collectors.toList());*/

        List<String> sortedGNumbers = someBingoNumbers.stream()
                .map(String::toUpperCase)
                .filter(s->s.startsWith("G")).sorted()
                .collect(ArrayList::new,ArrayList::add,ArrayList::addAll);

        sortedGNumbers.forEach(System.out::println);

        Map<Integer, List<Employee>> groupedByAge = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(employee -> employee.getAge()));

        departments.stream().flatMap(department -> department.getEmployees().stream())
                .reduce(((employee, employee2) -> employee.getAge()<employee2.getAge()?employee:employee2))
                .ifPresent(System.out::println);

        Stream.of("ABC","AC","BAA","CCCC","XY","ST").filter(s -> {
            System.out.println(s);
            return s.length()==3;
        }).count();
    }
}

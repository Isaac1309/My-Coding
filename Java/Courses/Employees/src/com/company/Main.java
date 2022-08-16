package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Employee john = new Employee("John Doe",30);
        Employee tim = new Employee("Tim Burton", 63);
        Employee jack = new Employee("Jack Sparrow", 40);
        Employee snow = new Employee("Jon Snow", 25);
        Employee red = new Employee("Red RidingHood", 35);
        Employee charming = new Employee("Prince Charming", 31);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);
        employees.add(red);
        employees.add(charming);

        /**printEmployeesByAge(employees,"Employees over 30",employee -> employee.getAge()>30);
        printEmployeesByAge(employees,"Employees 30 and under",employee -> employee.getAge()<=30);
        printEmployeesByAge(employees, "Employees 25 and under", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge()<=25;
            }
        });

        System.out.println();

        IntPredicate greaterThan15 = i -> i>15;
        IntPredicate lessThan100 = i -> i<100;
        System.out.println(greaterThan15.test(10));
        int a = 20;
        System.out.println(greaterThan15.test(a+5));
        System.out.println();
        System.out.println(greaterThan15.and(lessThan100).test(50));
        System.out.println(greaterThan15.and(lessThan100).test(15));
        System.out.println();

        Random random = new Random();
        Supplier<Integer> randomSupplier = ()-> random.nextInt(1000);
        for (int i=0; i<10; i++){
            //System.out.println(random.nextInt(1000));
            System.out.println(randomSupplier.get());
        }

        employees.forEach(employee -> {
            String lastName = employee.getName().substring(employee.getName().indexOf(' ')+1);
            System.out.println("LastName is: "+lastName);
        });*/

        Function<Employee, String> getLastName = employee ->{
            return employee.getName().substring(employee.getName().indexOf(' ')+1);
        };
        String lastName =getLastName.apply(employees.get(1));
        System.out.println(lastName);

        Function<Employee, String> getFirstName = employee ->{
            return employee.getName().substring(0, employee.getName().indexOf(' ')+1);
        };
        String firstName =getFirstName.apply(employees.get(1));
        System.out.println(firstName);

        Random random1 = new Random();
        /**for (Employee employee: employees){
         if (random1.nextBoolean())
         System.out.println(getAName(getFirstName, employee));
         else
         System.out.println(getAName(getFirstName, employee));
         }*/
        employees.forEach(employee->{
            if (random1.nextBoolean())
                System.out.println(getAName(getFirstName, employee));
            else
                System.out.println(getAName(getFirstName, employee));
        });

        Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase();
        Function<String, String> firstNameFunction = name -> name.substring(0, name.indexOf(' '));
        Function<String, String> lastNameFunction = name -> name.substring(name.indexOf(' ')+1);
        Function chainedFunction = upperCase.andThen(firstNameFunction);
        System.out.println(chainedFunction.apply(employees.get(0)));

        BiFunction<String,Employee,String> concatAge = (name, employee) -> {
            return name.concat(" "+employee.getAge());
        };
        String upperName = upperCase.apply(employees.get(0));
        System.out.println(concatAge.apply(upperName,employees.get(0)));
        /**String upperName2 = String.valueOf(chainedFunction.apply(employees.get(0)));
        System.out.println(concatAge.apply(upperName2,employees.get(0)));*/

        IntUnaryOperator incBy5 = i -> i+5;
        System.out.println(incBy5.applyAsInt(10));

        Consumer<String> c1 = s -> s.toUpperCase(); //consumer don't return a value and can be chained
        Consumer<String> c2 = s -> System.out.println(s);
        c1.andThen(c2).accept("Hello, World!");

    }

    private static String getAName(Function<Employee, String> getName, Employee employee){
        return getName.apply(employee);
    }

    private static void printEmployeesByAge(List<Employee> employees, String ageText, Predicate<Employee> ageCondition){
        System.out.println("\n"+ageText);
        System.out.println("==================");
        /**for (Employee employee : employees) {
            if (ageCondition.test(employee)) {
                System.out.println(employee.getName());
            }
        }*/
        employees.forEach(employee -> {
            if (ageCondition.test(employee)) {
                System.out.println(employee.getName());
            }
        });


        /**employees.forEach(employee -> {
            if (employee.getAge()>30){
                System.out.println(employee.getName());
            }
        });*/
        /**for (Employee employee : employees) {
         if (employee.getAge() > 30) {
         System.out.println(employee.getName());
         }
         }**/
    }
}

import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Thread(()-> {
            System.out.println("Printing from the Runnable");
            System.out.println("Line 2");
            System.out.println("This is line 3\n");
        }).start();


        Employee john = new Employee("John Doe",30);
        Employee tim = new Employee("Tim Burton", 63);
        Employee jack = new Employee("Jack Sparrow", 40);
        Employee snow = new Employee("Jon Snow", 25);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);

        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });

        /**for (Employee employee:employees){
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
            //new Thread(()-> System.out.println(employee.getAge())).start();
        }**/

        /**System.out.println("***********");
        for (int i=0; i<employees.size();i++){
            Employee employee = employees.get(i);
            System.out.println(employee.getName());
            new Thread(()-> System.out.println(employee.getAge())).start();
        }**/

        /**Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });**/

       /**Collections.sort(employees, (o1, o2) ->
            o1.getName().compareTo(o2.getName())
        );

        for (Employee employee:employees)
            System.out.println(employee.getName());**/


        /**String sillyString = doStringStuff(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                return s1.toUpperCase()+" "+s2.toUpperCase();
            }
        }, employees.get(0).getName(), employees.get(1).getName());
        System.out.println(sillyString);**/

        /**UpperConcat uc = (s1, s2) -> {
            String res = s1.toUpperCase() + " " + s2.toUpperCase();
            return res;
        };
        String sillyString =doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());
        System.out.println(sillyString);**/

        System.out.println();

        AnotherClass anotherClass =new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println(s);

        anotherClass.printValue();
    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2){
        return uc.upperAndConcat(s1,s2);
    }
}
class Employee {
    private String name;
    private  int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}

interface UpperConcat{
    public String upperAndConcat(String s1, String s2);
}

class AnotherClass{
    public String doSomething(){
        /**System.out.println("The AnotherClass class's name is: "+getClass().getSimpleName());
        return Main.doStringStuff(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                System.out.println("The anonymous class's name is: "+getClass().getSimpleName());
                return s1.toUpperCase()+" "+s2.toUpperCase();
            }
        }, "String1","String2");**/

        /**int i =0;
        {
            UpperConcat uc = new UpperConcat() {
                @Override
                public String upperAndConcat(String s1, String s2) {
                    System.out.println("i (within anonymous class) = "+i);
                    return s1.toUpperCase() + " " + s2.toUpperCase();
                }
            };
            System.out.println("The lambda expression's clas is "+getClass().getSimpleName());
            //i++;
            System.out.println("i = "+i);
            return Main.doStringStuff(uc,"String1","String2");
        }**/
        int i=0;
        //i++;
        UpperConcat uc = (s1, s2) -> {
            System.out.println("The lambda expression's clas is "+getClass().getSimpleName());
            System.out.println("i in the lambda expression = "+i);
            String res = s1.toUpperCase() + " " + s2.toUpperCase();
            return res;
        };
        System.out.println("The lambda expression's clas is "+getClass().getSimpleName());
        return Main.doStringStuff(uc,"String1","String2");
    }
    public void printValue(){
        int number=25;
        Runnable r = () -> {
            try {
                Thread.sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("The value is "+number);
        };
        new Thread(r).start();
    }
}
import classObject.*;
import encapsulation.*;
import inheritance.*;
import java.util.Date;
public class Main {
    public static void main(String[] args) {
        System.out.println("Class and Object like a Calculator:");
        System.out.println(Calculator.sum(1,2,3,4));
        System.out.println(Calculator.sum(1.2,2.8,3.7,4.3));
        System.out.println(Calculator.subtraction(1,2,3,4));
        System.out.println(Calculator.subtraction(1.2,2.8,3.7,4.3));
        System.out.println(Calculator.multiplication(1,2,3,4));
        System.out.println(Calculator.multiplication(1.2,2.8,3.7,4.3));
        System.out.println(Calculator.divide(12,4));
        System.out.println(Calculator.divide(128.0,3.0));
        System.out.println();

        Circle circle = new Circle(5);
        System.out.println("Encapsulation with the area and perimeter of a Circle:");
        System.out.println(circle);
        System.out.println("Area= "+circle.area());
        System.out.println("Perimeter= "+circle.perimeter());
        circle.setRadius(10);
        System.out.println(circle);
        System.out.println("Area= "+circle.area());
        System.out.println("Perimeter= "+circle.perimeter());
        System.out.println();
        
        System.out.println("Inheritance and Polymorphism:");
        System.out.println("Super Class (Person):");
        Person person = new Person("Andres", 'M', 22,"Jalisco Mexico");
        System.out.println(person);
        System.out.println(person.getDitails());

        System.out.println("Sub-Class (Employee):");
        Employee employee1 = new Employee(20000, "Juan");
        System.out.println(employee1);
        System.out.println(employee1.getDitails());
        Employee employee2 = new Employee(12000, "Pedro");
        System.out.println(employee2);
        
        var date = new Date();
        System.out.println("Sub-Class (Client):");
        Client client1 = new Client(date, true, "Maria", 'F', 25, "Chiapas Mexico");
        System.out.println(client1);
        System.out.println(client1.getDitails());
    }
}

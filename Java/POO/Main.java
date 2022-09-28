import classObject.*;
import encapsulation.*;
import inheritance.*;
import java.util.Date;

import javax.lang.model.element.Element;
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
        printDitails(employee2);
        
        Date date = new Date();
        System.out.println("Sub-Class (Client):");
        Client client1 = new Client(date, true, "Maria", 'F', 25, "Chiapas Mexico");
        System.out.println(client1);
        printDitails(client1);

        String obj="I'm an Object because i inherit from the Object Class";
        getType(employee1);
        getType(person);
        getType(obj);
        getType(client1);
    }
    public static void printDitails(Person person){
        System.out.println(person.getDitails());
    }
    public static void getType(Object object){
        if(object instanceof Employee){
            System.out.println("The type is Employee");
        }else if (object instanceof Client){
            System.out.println("The type is Client");
        }else if (object instanceof Person){
            System.out.println("The type is Person");
        }else if (object instanceof Object){
            System.out.println("The type is Object");
        }
    }
}

import java.util.Date;

import classObject.*;
import encapsulation.*;
import inheritance.*;
import enumType.*;
import abstractClass.*;
import interfaces.*;
import blockCode.*;

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

        Circle circle = new Circle(5);
        System.out.println("\nEncapsulation with the area and perimeter of a Circle:");
        System.out.println(circle);
        System.out.println("Area= "+circle.area());
        System.out.println("Perimeter= "+circle.perimeter());
        circle.setRadius(10);
        System.out.println(circle);
        System.out.println("Area= "+circle.area());
        System.out.println("Perimeter= "+circle.perimeter());
        
        System.out.println("\nInheritance and Polymorphism:");
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

        System.out.println("\nType enum:");
        System.out.println("Simple enum:");
        System.out.println(Days.Sunday);
        System.out.println("enum with data:");
        System.out.print(Continents.America+" has ");
        System.out.println(Continents.America.getCountries()+" countries");
        Continents continents = Continents.Asia;
        System.out.print(continents+" has ");
        System.out.println(continents.getCountries()+" countries");

        System.out.println("\nAbstract Class:");
        GeometricFigure figure = new Rectangle("Rectangle");
        System.out.println(figure);
        figure.draw();
        figure = new Square("Square");
        System.out.println(figure);
        figure.draw();
        
        System.out.println("\nInterface:");
        DataBase dataBase = new ImplementsData();
        dataBase.insert();
        dataBase.update();
        dataBase.list();
        dataBase.delete();

    
        System.out.println("\nCode Block:");
        Human person1 = new Human();
        System.out.println(person1);
        Human person2 = new Human();
        System.out.println(person2);
        Human person3 = new Human();
        System.out.println(person3);
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

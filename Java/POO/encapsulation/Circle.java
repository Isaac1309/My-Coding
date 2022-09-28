package encapsulation;
public class Circle {
    private double radius;
    private static final double PI=3.1416;

    public Circle(double radius){
        this.radius=radius;
    }

    public double getRadius(){
        return radius;
    }
    public void setRadius(double radius){
        this.radius=radius;
    }

    public double area(){
        return PI*(radius*radius);
    }
    public double perimeter(){
        return 2*PI*radius;
    }
    public String toString(){
        return "Circle [radius = "+radius+" ]";
    }
}

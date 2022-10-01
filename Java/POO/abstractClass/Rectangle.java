package abstractClass;
public class Rectangle extends GeometricFigure{
    public Rectangle(String figureType){
        super(figureType);
    }

    @Override
    public void draw(){
        System.out.println("Drawing a: "+getClass().getSimpleName());
    }
}

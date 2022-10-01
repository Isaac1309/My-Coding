package abstractClass;
public class Square extends GeometricFigure{
    public Square(String figureType){
        super(figureType);
    }

    @Override
    public void draw(){
        System.out.println("Drawing a: "+getClass().getSimpleName());
    }
}

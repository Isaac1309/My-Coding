package abstractClass;
public abstract class GeometricFigure {
    protected String figureType;

    protected GeometricFigure(String figureType){
        this.figureType=figureType;
    }

    public abstract void draw();

    public String getFigureType(String figureType){
        return figureType;
    }
    public void setFigureType(String figureType){
        this.figureType=figureType;
    }

    @Override
    public String toString(){
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("GeometricFigure {figureType= ")
        .append(this.figureType).append(" }");
        return sBuilder.toString();
    }
}

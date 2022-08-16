public class Point {
    private int x;
    private int y;

    public Point(){ this(0,0); }
    public Point(int x, int y){
        setX(x);
        setY(y);
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public double distance(){
        double r=Math.sqrt(((0-getX())*(0-getX()))+((0-getY())*(0-getY())));
        return r;
    }
    public double distance(int x, int y){
        double r=Math.sqrt(((x-getX())*(x-getX()))+((y-getY())*(y-getY())));
        return r;
    }
    public double distance(Point point){
        double r=Math.sqrt(((point.getX()-getX())*(point.getX()-getX()))+((point.getY()-getY())*(point.getY()-getY())));
        return r;
    }
}

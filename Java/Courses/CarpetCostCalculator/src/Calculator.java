public class Calculator {
    private Floor floor;
    private Carpet carpet;

    public Calculator(Floor floor, Carpet carpet){
        setFloor(floor);
        setCarpet(carpet);
    }

    public Floor getFloor() {
        return floor;
    }
    public Carpet getCarpet() {
        return carpet;
    }
    public void setFloor(Floor floor) {
        this.floor = floor;
    }
    public void setCarpet(Carpet carpet) {
        this.carpet = carpet;
    }
    public double getTotalCost(){
        return getFloor().getArea()*getCarpet().getCost();
    }
}

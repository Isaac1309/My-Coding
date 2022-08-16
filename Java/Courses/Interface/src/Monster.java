import java.util.ArrayList;
import java.util.List;

public class Monster implements ISaveable {
    private String name;
    private int hitPoints;
    private int strength;

    public Monster(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    @Override
    public List<String> write() {
        ArrayList<String> returned=new ArrayList<>();
        returned.add(0,getName());
        returned.add(1,""+getHitPoints());
        returned.add(2,""+getStrength());
        if (returned.isEmpty()) return null;
        else return returned;
    }
    @Override
    public void read(List<String> list) {
        if (!list.isEmpty()&&list.size()>0){
            this.name=list.get(0);
            this.hitPoints=Integer.parseInt(list.get(1));
            this.strength=Integer.parseInt(list.get(2));
        }
    }
    @Override
    public String toString(){
        return "Player{name='"+getName()+"', hitPoints="+getHitPoints()+
                ", strength="+getStrength()+"}";
    }

    public String getName() {
        return name;
    }
    public int getHitPoints() {
        return hitPoints;
    }
    public int getStrength() {
        return strength;
    }
}
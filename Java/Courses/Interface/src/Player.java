import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable {
    private String name;
    private String weapon;
    private int hitPoints;
    private int strength;

    public Player(String name, int hitPoints, int strength) {
        this.name = name;
        this.weapon="Sword";
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    @Override
    public List<String> write() {
        List<String> returned=new ArrayList<>();
        returned.add(0,getName());
        returned.add(1,""+getHitPoints());
        returned.add(2,""+getStrength());
        returned.add(3,getWeapon());
        if (returned.isEmpty()) return null;
        else return returned;
    }
    @Override
    public void read(List<String> list) {
        if (!list.isEmpty()&&list.size()>0){
            setName(list.get(0));
            setHitPoints(Integer.parseInt(list.get(1)));
            setStrength(Integer.parseInt(list.get(2)));
            setWeapon(list.get(3));
        }
    }
    @Override
    public String toString(){
        return "Player{name='"+getName()+"', hitPoints="+getHitPoints()+
                ", strength="+getStrength()+ ", weapon='"+getWeapon()+"'}";
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getWeapon() {
        return weapon;
    }
    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }
    public int getHitPoints() {
        return hitPoints;
    }
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }
    public int getStrength() {
        return strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
}
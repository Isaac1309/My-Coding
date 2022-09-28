package inheritance;
public class Person {
    protected String name;
    protected char gender;
    protected int age;
    protected String direction;

    public Person(){
    }
    public Person(String name){
        this.name=name;
    }
    public Person(String name,char gender, int age, String direction){
        this.name=name;
        this.gender=gender;
        this.age=age;
        this.direction=direction;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getDirection() {
        return direction;
    }
    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        StringBuilder sBuilder=new StringBuilder();
        sBuilder.append("Person{name=").append(name)
            .append(", gender=").append(gender)
            .append(", age=").append(age)
            .append(", direction=").append(direction)
            .append('}');

        return sBuilder.toString();
    }
}

public class Person implements Comparable<Person>{
    private int age;
    private String name;
    
    public Person(int age, String name){
        this.age=age;
        this.name=name;
    }

    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "Person [Age: "+this.age+" Name: "+this.name+"]";
    }
    @Override
    public int compareTo(Person o){
        return Integer.compare(o.getAge(), age);
    }
}

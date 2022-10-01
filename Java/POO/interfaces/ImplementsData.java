package interfaces;
public class ImplementsData implements DataBase{
    public void insert(){
        System.out.println("Data inserted");
    }

    public void delete(){
        System.out.println("Data deleted");
    }

    public void update(){
        System.out.println("Data updated");
    }

    public void list(){
        System.out.println("Listed data");
    }
}

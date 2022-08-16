import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Client john = new Client("John Doe", "0001",30000);
        Client tim = new Client("Tim Burton", "0002",63000);
        Client jack = new Client("Jack Sparrow", "0003",40000);
        Client snow = new Client("Jon Snow", "0004",25000);
        List<Client> clients = new ArrayList<>();
        clients.add(john);
        clients.add(tim);
        clients.add(jack);
        clients.add(snow);

        Collections.sort(clients, new Comparator<Client>() {
            @Override
            public int compare(Client o1, Client o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        for (Client client:clients)
            System.out.println(client.getAll());
    }
}

class Client{
    private String name;
    private String count_name;
    private double balance;

    public Client(String name, String count_name, double balance) {
        this.name = name;
        this.count_name = count_name;
        this.balance = balance;
    }

    public String getAll() {
        return "Name: "+name+", Count: "+count_name+", Balance: $"+balance;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCount_name() {
        return count_name;
    }
    public void setCount_name(String count_name) {
        this.count_name = count_name;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
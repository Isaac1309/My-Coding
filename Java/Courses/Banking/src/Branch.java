import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers=new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public ArrayList<Customer> getCustomers() {
        return customers;
    }
    public boolean newCustomer(String nameCustomer, double initialTransaction){
        if (findCustomer(nameCustomer)==null){
            this.customers.add(new Customer(nameCustomer, initialTransaction));
            return true;
        }
        return false;
    }
    public boolean addCustomerTransaction(String nameCustomer, double transaction){
        Customer customerTransaction = findCustomer(nameCustomer);
        if (customerTransaction!=null){
            customerTransaction.addTransaction(transaction);
            return true;
        }
        return false;
    }
    private Customer findCustomer(String nameCustomer){
        for (int i=0; i<this.customers.size();i++){
            Customer customerFind = this.customers.get(i);
            if (customerFind.getName().equals(nameCustomer)) return customerFind;
        }
        return null;
    }
}
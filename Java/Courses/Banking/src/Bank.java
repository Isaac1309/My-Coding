import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        branches=new ArrayList<>();
    }

    public boolean addBranch(String nameBranch){
        if (findBranch(nameBranch)==null){
            branches.add(new Branch(nameBranch));
            return true;
        }
        return false;
    }
    public boolean addCustomer(String nameBranch, String nameCustomer, double transaction){
        Branch branchAddCustomer = findBranch(nameBranch);
        if (branchAddCustomer!=null){
            return branchAddCustomer.newCustomer(nameCustomer, transaction);
        }
        return false;
    }
    public boolean addCustomerTransaction(String nameBranch, String nameCustomer, double transaction){
        Branch branchAddCustomer = findBranch(nameBranch);
        if (branchAddCustomer!=null){
            return branchAddCustomer.addCustomerTransaction(nameCustomer, transaction);
        }
        return false;
    }
    private Branch findBranch(String nameBranch){
        for (int i=0; i<branches.size();i++){
            Branch branchFind = branches.get(i);
            if (branchFind.getName().equals(nameBranch)) return branchFind;
        }
        return null;
    }
    public boolean listCustomers(String nameBranch, boolean printTransactions){
        Branch branchToPrint = findBranch(nameBranch);
        if (branchToPrint!=null){
            System.out.println("Customer details for branch "+branchToPrint.getName());
            ArrayList<Customer> branchCustomers = branchToPrint.getCustomers();
            for (int i=0;i<branchCustomers.size();i++){
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer: "+branchCustomer.getName()+"["+(i+1)+"]");
                if (printTransactions) {
                    System.out.println("Transactions");
                    ArrayList<Double> customerTransactions = branchCustomer.getTransactions();
                    for (int j = 0; j < customerTransactions.size(); j++) {
                        System.out.println("[" + (j + 1) + "]  Amount "+customerTransactions.get(j));
                    }
                }
            }
            return true;
        }else return false;
    }
}
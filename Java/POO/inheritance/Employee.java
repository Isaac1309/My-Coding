package inheritance;

public class Employee extends Person{
    private int idEmployee;
    private double salary;
    private static int countEmployee;

    public Employee(double salary, String name){
        super(name);
        this.idEmployee= ++Employee.countEmployee;
        this.salary=salary;
    }

    public int getIdEmployee(){
        return this.idEmployee;
    }
    
    public double getSalary(){
        return salary;
    }
    public void setSalary(double salary){
        this.salary=salary;
    }

    @Override
    public String toString() {
        StringBuilder sBuilder=new StringBuilder();
        sBuilder.append("Employee{idEmployee=").append(this.idEmployee)
            .append(", salary=").append(this.salary)
            .append(", ").append(super.toString())
            .append('}');
        return sBuilder.toString();
    }
    
    @Override
    public String getDitails() {
        return super.getDitails()+" Salary: "+this.salary;
    }
}

package inheritance;
import java.util.Date;
public class Client extends Person {
    private int idClient;
    private Date registerDate;
    private boolean vip;
    private static int countClient;

    public Client(Date registerDate, boolean vip, String name,char gender, int age, String direction){
        super(name, gender, age, direction);
        this.idClient= ++Client.countClient;
        this.vip=vip;
    }

    public int getIdClient(){
        return this.idClient;
    }

    public Date getRegisterDate(){
        return this.registerDate;
    }
    public void setRegisterDate(Date registerDate){
        this.registerDate=registerDate;
    }
    
    public boolean getVip(){
        return this.vip;
    }
    public void setVip(boolean vip){
        this.vip=vip;
    }

    @Override
    public String toString() {
        StringBuilder sBuilder=new StringBuilder();
        sBuilder.append("Client{idClient=").append(this.idClient)
            .append(", registerDate=").append(this.registerDate)
            .append(", vip=").append(this.vip)
            .append(", ").append(super.toString())
            .append('}');
        return sBuilder.toString();
    }
}

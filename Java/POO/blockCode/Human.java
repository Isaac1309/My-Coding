package blockCode;
public class Human {
    private final int idHuman;
    private static int countHuman;

    static{
        System.out.println("Static Block Execution");
        ++Human.countHuman;
        //this.idHuman=1; can't use here
    }

    {
        System.out.println("Block Execution");
        this.idHuman=Human.countHuman++;
    }

    public Human(){
        System.out.println("Constructor Execution");
    }

    public int getIdHuman(){
        return idHuman;
    }

    @Override
    public String toString() {
        return "Human{idHuman= "+this.idHuman+"}";
    }
}

/** @author isaac */
public class Banco {
    public static void main(String[] args) {
        cuenta c1=new cuenta("JuanS.A", 30, 19);
        cuenta c2=new cuenta("PepeS.A", 20, 19);
        cuenta c3=new cuenta("MaríaS.A", 40, 19);
        cuenta[] cuentas={c1,c2,c3};
        usuario us1=new usuario(c1, cuentas);
        usuario us2=new usuario(c2, cuentas);
        usuario us3=new usuario(c3, cuentas);
        Thread u1=new Thread(us1, "Juan");
        Thread u2=new Thread(us2, "Pepe");
        Thread u3=new Thread(us3, "María");
        u1.start();
        u2.start();
        u3.start();
    }
}

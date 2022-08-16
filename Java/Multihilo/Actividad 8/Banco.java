/** @author isaac */
public class Banco {
    public static void main(String[] args) {
        cuenta c1=new cuenta("Moises S.A", 30, 18);
        usuario us=new usuario(c1);
        Thread u1=new Thread(us, "Juan");
        Thread u2=new Thread(us, "Pepe");
        Thread u3=new Thread(us, "María");
        u1.start();
        u2.start();
        u3.start();
    }
}

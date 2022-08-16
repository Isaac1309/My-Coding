/** @author isaac */
public class cuenta {
    private String nombre="";
    private int saldoActual=0;
    private int limite=0;
    
    public cuenta (String nombre, int saldo, int limite){
        this.nombre=nombre;
        this.saldoActual=saldo;
        this.limite = limite;
    }
    public String getNombre(){
        return nombre;
    }
    public synchronized int getSaldoActual(){
        return saldoActual;
    }
    public synchronized int getLimite(){
        return limite;
    }
    public synchronized void retiroDeCuenta(int valorRetiro){
        saldoActual-=valorRetiro;
    }
    public synchronized void depositoACuenta(int valorDeposito){
        saldoActual+=valorDeposito;
    }
}

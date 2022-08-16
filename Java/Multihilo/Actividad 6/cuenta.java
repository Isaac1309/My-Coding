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
    public int getSaldoActual(){
        return saldoActual;
    }
    public int getLimite(){
        return limite;
    }
    public void retiroDeCuenta(int valorRetiro){
        saldoActual-=valorRetiro;
    }
    public void depositoACuenta(int valorDeposito){
        saldoActual+=valorDeposito;
    }
}

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
/** @author isaac */
public class usuario  implements Runnable{
    private String nombre;
    private cuenta cta;
    public usuario(cuenta cta){
        this.cta=cta;
        this.nombre = cta.getNombre();
    }
    @Override
    public void run() {
        Random random=new Random();
        for(int i=0;i<5; i++){
            int numAle=(random.nextInt(40))+10;
            int menuAle=(random.nextInt(3));
            switch(menuAle) {
                case 0:
                    try {
                        retirarDineroCuenta(numAle);
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(cuenta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 1:
                    try {
                        depositarDineroCuenta(numAle);
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(cuenta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 2:
                    System.out.println("Ususario: "+Thread.currentThread().getName()+" el saldo actual de la cuenta: "+nombre+" es de = $"+cta.getSaldoActual()+" Pesos.\n");
                    break;
            }
        }
    }

    private synchronized void retirarDineroCuenta(int valorRetiro){
        if(valorRetiro>=cta.getSaldoActual()){
            System.out.println("Ususario: "+Thread.currentThread().getName()+" no hay saldo suficiente en la cuenta: "+nombre+" para realizar la transaccion de $"+valorRetiro+" Pesos.");
            System.out.println("Ususario: "+Thread.currentThread().getName()+" el saldo actual de la cuenta: "+nombre+" es de = $"+cta.getSaldoActual()+" Pesos.\n");
        }else{
            System.out.println("Usuario: "+Thread.currentThread().getName()+" se esta realizando su retiro en la cuenta: "+nombre+" de: $"+valorRetiro+" Pesos.");
            cta.retiroDeCuenta(valorRetiro);
            System.out.println("Usuario: "+Thread.currentThread().getName()+" el retiro a la cuenta: "+nombre+" se a realizando correctamente, el nuevo saldo es: $"+cta.getSaldoActual()+" Pesos.\n");
        }
    }
    private synchronized void depositarDineroCuenta(int valorDeposito) {
        if(valorDeposito>cta.getLimite()){
            System.out.println("Ususario: "+Thread.currentThread().getName()+" no puede realizar el deposito de $"+valorDeposito+" Pesos en la cuenta: "+nombre+", el deposito maximo es de $"+cta.getLimite()+" Pesos.");
            System.out.println("Ususario: "+Thread.currentThread().getName()+" el saldo actual de la cuenta: "+nombre+" es de = $"+cta.getSaldoActual()+" Pesos.\n");
        }else{
            System.out.println("Ususario: "+Thread.currentThread().getName()+" se esta realizando su deposito en la cuenta: "+nombre+" de: $"+valorDeposito+" Pesos.");
            cta.depositoACuenta(valorDeposito);
            System.out.println("Usuario: "+Thread.currentThread().getName()+" el deposito a la cuenta: "+nombre+" se a realizando correctamente, el nuevo saldo es: $"+cta.getSaldoActual()+" Pesos.\n");
        }
    }
}

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
/** @author isaac */
public class CajeroAutomatico implements Runnable{
    CuentaBancaria miCuentaBancaria=new CuentaBancaria();

    @Override
    public void run() {
        Random random=new Random();
        for(int i=0;i<5; i++){
            int numAle=(random.nextInt(16))+5;
            int menuAle=(random.nextInt(2));
            switch(menuAle) {
                case 0:
                    try {
                        retirarDineroCuenta(numAle);
                        if(miCuentaBancaria.getSaldoActual()<=0){
                            System.out.println("Su cuenta actualmente no posee saldo.\n");
                        }
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(CajeroAutomatico.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 1:
                    try {
                        depositarDineroCuenta(numAle);
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(CajeroAutomatico.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
            }
        }
    }

    private synchronized void retirarDineroCuenta(int valorRetiro){
        while(miCuentaBancaria.getSaldoActual()<valorRetiro){
            System.out.println("Señor "+Thread.currentThread().getName()+" no hay saldo suficiente para realizar la transaccion de $"+valorRetiro+" Pesos.");
            System.out.println("El saldo Actual= $"+miCuentaBancaria.getSaldoActual()+" Pesos.\n");
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(CajeroAutomatico.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            System.out.println("Saldo Actual= $"+miCuentaBancaria.getSaldoActual()+" Pesos.");
            System.out.println("El usuario : "+Thread.currentThread().getName()+" esta realizando un retiro de: $"+valorRetiro+" Pesos.");
            miCuentaBancaria.retiroDeCuenta(valorRetiro);
            System.out.println("El retiro se a realizando correctamente, el nuevo saldo es: $"+miCuentaBancaria.getSaldoActual()+" Pesos.\n");
    }
    private synchronized void depositarDineroCuenta(int valorDeposito) {
        System.out.println("Saldo Actual= $"+miCuentaBancaria.getSaldoActual()+" Pesos.");
        System.out.println(Thread.currentThread().getName()+" esta realizando un deposito de: $"+valorDeposito+" Pesos.");
        miCuentaBancaria.depositoACuenta(valorDeposito);
        System.out.println("El deposito se a realizando correctamente, el nuevo saldo es: $"+miCuentaBancaria.getSaldoActual()+" Pesos.\n");
        notifyAll();
    }
}
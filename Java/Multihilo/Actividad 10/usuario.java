import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
/** @author isaac */
public class usuario implements Runnable{
    private cuenta cuenta[];
    private String nombre;
    private cuenta cta;
    public Random random=new Random();
    public usuario(cuenta cta, cuenta[] cuentas){
        this.cta=cta;
        this.nombre = cta.getNombre();
        this.cuenta = cuentas;
    }
    @Override
    public void run() {
        for(int i=0;i<5; i++){
            int numAle=(random.nextInt(16))+5;
            int menuAle=(random.nextInt(3));
            int ntran=(random.nextInt(3));
            switch(3) {
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
                case 3:
                    transferenciaDineroCuenta(numAle, ntran, cuenta);
                    break;
            }
        }
    }
    private synchronized void transferenciaDineroCuenta(int valorTran, int ntran, cuenta acuenta[]){
        while(nombre.equals(cuenta[ntran].getNombre())){
            ntran=(random.nextInt(3));
        }
        try {
            retirarDineroCuenta(valorTran);
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(cuenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Ususario: "+Thread.currentThread().getName()+" esta realizando una transeferencia en la cuenta: "+cuenta[ntran].getNombre()+" de: $"+valorTran+" Pesos.");
        cuenta[ntran].depositoACuenta(valorTran);
        System.out.println("Usuario: "+Thread.currentThread().getName()+" la transeferencia a la cuenta: "+cuenta[ntran].getNombre()+" se a realizando correctamente, el nuevo saldo es: $"+cuenta[ntran].getSaldoActual()+" Pesos.\n");
        notifyAll();
    }

    private synchronized void retirarDineroCuenta(int valorRetiro){
        int fRetiro=0, retiroR=0;
        boolean pRetiro=false;
        while(cta.getSaldoActual()<valorRetiro){
            if(cta.getSaldoActual()>0){
                System.out.println("Usuario: "+Thread.currentThread().getName()+" esta realizando su retiro en la cuenta: "+nombre+" de: $"+valorRetiro+" Pesos.");
                System.out.println("Usuario: "+Thread.currentThread().getName()+" el retiro que esta intentado relizar en la cuenta: "+nombre+" la cantidad maxima a retirar es de: $"+cta.getSaldoActual()+" Pesos.");
                fRetiro=valorRetiro-cta.getSaldoActual();
                retiroR=valorRetiro-fRetiro;
                if(pRetiro==false){
                        valorRetiro=valorRetiro-retiroR;
                        cta.retiroDeCuenta(retiroR);
                        pRetiro=true;
                        System.out.println("Usuario: "+Thread.currentThread().getName()+" a realizando un retiro a la cuenta: "+nombre+" por la cantidad de $"+retiroR+" Pesos, el nuevo saldo es de: $"+cta.getSaldoActual()+" Pesos.\n");
                        try {
                            wait();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(usuario.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }else{
                    cta.retiroDeCuenta(fRetiro);
                    System.out.println("Usuario: "+Thread.currentThread().getName()+" a realizando un retiro a la cuenta: "+nombre+" por la cantidad de "+fRetiro+", el nuevo saldo es de: $"+cta.getSaldoActual()+" Pesos.\n");
                }
            }else{
                System.out.println("Ususario: "+Thread.currentThread().getName()+" no hay saldo en la cuenta: "+nombre+" para realizar la transaccion de $"+valorRetiro+" Pesos.");
                System.out.println("Ususario: "+Thread.currentThread().getName()+" el saldo actual de la cuenta: "+nombre+" es de = $"+cta.getSaldoActual()+" Pesos.\n");
                try {
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(usuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        System.out.println("Usuario: "+Thread.currentThread().getName()+" esta realizando su retiro en la cuenta: "+nombre+" de: $"+valorRetiro+" Pesos.");
        cta.retiroDeCuenta(valorRetiro);
        System.out.println("Usuario: "+Thread.currentThread().getName()+" el retiro a la cuenta: "+nombre+" se a realizando correctamente, el nuevo saldo es: $"+cta.getSaldoActual()+" Pesos.\n");
    }

    private synchronized void depositarDineroCuenta(int valorDeposito) {
        while(valorDeposito>cta.getLimite()){
            System.out.println("Ususario: "+Thread.currentThread().getName()+" no puede realizar el deposito de $"+valorDeposito+" Pesos en la cuenta: "+nombre+", el deposito maximo es de $"+cta.getLimite()+" Pesos.");
            System.out.println("Ususario: "+Thread.currentThread().getName()+" el saldo actual de la cuenta: "+nombre+" es de = $"+cta.getSaldoActual()+" Pesos.\n");
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Ususario: "+Thread.currentThread().getName()+" esta realizando su deposito en la cuenta: "+nombre+" de: $"+valorDeposito+" Pesos.");
        cta.depositoACuenta(valorDeposito);
        System.out.println("Usuario: "+Thread.currentThread().getName()+" el deposito a la cuenta: "+nombre+" se a realizando correctamente, el nuevo saldo es: $"+cta.getSaldoActual()+" Pesos.\n");
        notifyAll();
    }
}

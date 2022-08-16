import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import java.net.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;

public class CajeroAutomatico implements Runnable{
    private ServerSocket ss = null;
    private Socket socket = null;
    private DataOutputStream clientOut;
    private ServerMM server = new ServerMM(4444);
    private CuentaBancaria miCuentaBancaria = new CuentaBancaria();
    private File file = new File("Movimientos.txt");
	public FileWriter fw = null;
	public BufferedWriter bw = null;
	public PrintWriter printerOut = null;
	public Date objDate =null;

    public CajeroAutomatico(ServerMM server,CuentaBancaria miCuentaBancaria){
        this.server = server;
        this.miCuentaBancaria = miCuentaBancaria;
    }

    @Override
    public void run() {
        List<Socket> sockets =server.getSockets();
        socket  = sockets.get(sockets.size()-1);
        DataInputStream dis =null;
        DataOutputStream dout=null;
		Random random=new Random();
		int currentconnected = server.getCurrentConnected();
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
			try{
				fw = new FileWriter(file,true);
				bw = new BufferedWriter(fw);
				printerOut = new PrintWriter(bw);
				dis=new DataInputStream(socket.getInputStream());
				dout=new DataOutputStream(socket.getOutputStream());
				
				while(currentconnected<3){
					currentconnected = server.getCurrentConnected();
				}
				while(true){
					int numAle=(random.nextInt(16))+5;
					dout.writeUTF("Seleciona una opcion:\n0.-Retirar Dinero\n1.-Depositar Dinero\n");
					System.out.println("Mande el mensaje\n");
					String selecS=(String)dis.readUTF();
					System.out.println("Mensaje recivido = "+selecS);
					switch(selecS) {
						case "0":
							try {
								retirarDineroCuenta(numAle,dout);
								if(miCuentaBancaria.getSaldoActual()<=0){
									System.out.println("Su cuenta actualmente no posee saldo.\n");
								}
								Thread.sleep(500);
							} catch (InterruptedException ex) {
								Logger.getLogger(CajeroAutomatico.class.getName()).log(Level.SEVERE, null, ex);
							}
							
							dout.flush();
							break;
						case "1":
							try {
								depositarDineroCuenta(numAle,dout);
								Thread.sleep(500);
							} catch (InterruptedException ex) {
								Logger.getLogger(CajeroAutomatico.class.getName()).log(Level.SEVERE, null, ex);
							}
							
							dout.flush();
							break;
					}
				}
			} catch (IOException e) {
				System.out.println("Client Disconnected");
				objDate = new Date();
				printerOut.println(objDate+" Client Disconnected");
				server.closeClient();
				try {
					bw.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
    }

    private synchronized void retirarDineroCuenta(int valorRetiro,DataOutputStream dout) throws IOException {
        while(miCuentaBancaria.getSaldoActual()<valorRetiro){
            System.out.println("Señor "+Thread.currentThread().getName()+" no hay saldo suficiente para realizar la transaccion de $"+valorRetiro+" Pesos.");
            System.out.println("El saldo Actual= $"+miCuentaBancaria.getSaldoActual()+" Pesos.\n");
			
			objDate = new Date();
			printerOut.println(objDate+" Señor "+Thread.currentThread().getName()+" no hay saldo suficiente para realizar la transaccion de $"+valorRetiro+" Pesos.");
			objDate = new Date();
			printerOut.println(objDate+" El saldo Actual= $"+miCuentaBancaria.getSaldoActual()+" Pesos.");
			
            try {
                dout.writeChars("Señor "+Thread.currentThread().getName()+" no hay saldo suficiente para realizar la transaccion de $"+valorRetiro+" Pesos.\n");
                dout.writeChars("El saldo Actual= $"+miCuentaBancaria.getSaldoActual()+" Pesos.\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                System.out.println("waiting");
                dout.writeChars("waiting\n");
				objDate = new Date();
				printerOut.println(objDate+" waiting");
                wait();
                System.out.println("resuming");
                dout.writeChars("resuming\n");
				objDate = new Date();
				printerOut.println(objDate+" resuming");
            } catch (InterruptedException ex) {
                Logger.getLogger(CajeroAutomatico.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            System.out.println("Saldo Actual= $"+miCuentaBancaria.getSaldoActual()+" Pesos.");
            System.out.println("El usuario : "+Thread.currentThread().getName()+" esta realizando un retiro de: $"+valorRetiro+" Pesos.");
			
			objDate = new Date();
			printerOut.println(objDate+" Saldo Actual= $"+miCuentaBancaria.getSaldoActual()+" Pesos.");
			objDate = new Date();
			printerOut.println(objDate+" El usuario : "+Thread.currentThread().getName()+" esta realizando un retiro de: $"+valorRetiro+" Pesos.");
			
            try{
                dout.writeChars("Saldo Actual= $"+miCuentaBancaria.getSaldoActual()+" Pesos.\n");
                dout.writeChars("El usuario : "+Thread.currentThread().getName()+" esta realizando un retiro de: $"+valorRetiro+" Pesos.\n");
                miCuentaBancaria.retiroDeCuenta(valorRetiro);
                System.out.println("El retiro se a realizando correctamente, el nuevo saldo es: $"+miCuentaBancaria.getSaldoActual()+" Pesos.\n");
                dout.writeChars("El retiro se a realizando correctamente, el nuevo saldo es: $"+miCuentaBancaria.getSaldoActual()+" Pesos.\n");
				
				objDate = new Date();
				printerOut.println(objDate+" El retiro se a realizando correctamente, el nuevo saldo es: $"+miCuentaBancaria.getSaldoActual()+" Pesos.");
			
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    private synchronized void depositarDineroCuenta(int valorDeposito,DataOutputStream dout) {
        try {
            System.out.println("Saldo Actual= $" + miCuentaBancaria.getSaldoActual() + " Pesos.");
            System.out.println(Thread.currentThread().getName() + " esta realizando un deposito de: $" + valorDeposito + " Pesos.");
			
			objDate = new Date();
			printerOut.println(objDate+" Saldo Actual= $" + miCuentaBancaria.getSaldoActual() + " Pesos.");
			objDate = new Date();
			printerOut.println(objDate+" El usuario : "+Thread.currentThread().getName() + " esta realizando un deposito de: $" + valorDeposito + " Pesos.");
			
            dout.writeChars("Saldo Actual= $" + miCuentaBancaria.getSaldoActual() + " Pesos.\n");
            dout.writeChars(Thread.currentThread().getName() + " esta realizando un deposito de: $" + valorDeposito + " Pesos.\n");
            miCuentaBancaria.depositoACuenta(valorDeposito);
            System.out.println("El deposito se a realizando correctamente, el nuevo saldo es: $" + miCuentaBancaria.getSaldoActual() + " Pesos.\n");
            dout.writeChars("El deposito se a realizando correctamente, el nuevo saldo es: $" + miCuentaBancaria.getSaldoActual() + " Pesos.\n");	
			
			objDate = new Date();
			printerOut.println(objDate+" El deposito se a realizando correctamente, el nuevo saldo es: $" + miCuentaBancaria.getSaldoActual() + " Pesos.\n");
			
            notifyAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientThread implements Runnable {
    private Socket socket;
    private DataOutputStream clientOut;
    private ServerMM server;

    public ClientThread(ServerMM server, Socket socket){
        this.server = server;
        this.socket = socket;
    }

    private DataOutputStream getWriter(){
        return clientOut;
    }

    @Override
    public void run() {
        try{
            clientOut = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            while(!socket.isClosed()){
                        if(clientOut != null){
                            String operacion="";
                            int a = 0, b=0, resp = 0;
                            Operaciones op = new Operaciones();
                            clientOut.writeChars("Selecciones una opcion:\n + Sumar\n - Restar\n" + " * Multiplicar");
                            clientOut.writeChars("\n / Dividir \n % Residuo\n");
                            operacion = (String) in.readUTF();
                            System.out.println("Mensaje recibido " + operacion);
                            clientOut.writeChars("Introduzca el primer valor\n");
                            a = (int) Integer.parseInt(in.readUTF());
                            System.out.println("Mensaje recibido " + a);
                            clientOut.writeChars("Introduzca el segundo valor\n");
                            b = (int) Integer.parseInt(in.readUTF());
                            System.out.println("Mensaje recibido " + b);
                            switch (operacion) {
                                case "+":
                                    resp = op.classSuma(a, b);
                                    break;
                                case "-":
                                    resp = op.classResta(a, b);
                                    break;
                                case "*":
                                    resp = op.classMultiplica(a, b);
                                    break;
                                case "/":
                                    resp = op.classDivision(a, b);
                                    break;
                                case "%":
                                    resp = op.classResiduo(a, b);
                                    break;
                                default:
                                    resp = -1000;
                                    System.out.println("Invalid operation!");
                            }
                            System.out.println("Resultado es "+resp);
                            clientOut.writeChars("Resultado es "+resp+"\n");
                            clientOut.flush();
                        }
            }
        } catch (IOException e) {
           System.out.println("Connection closed: "+socket.getRemoteSocketAddress());
           server.closeClient();
           System.out.println(server.currentconnected);
        }
    }
}
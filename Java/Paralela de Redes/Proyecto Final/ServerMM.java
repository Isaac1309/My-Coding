import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerMM {
    private static final int portNumber = 4444;
    private int port;
    private List<ClientThread> clientes;
    public static void main(String[] args) {
        ServerMM server = new ServerMM(portNumber);
        server.startServer();
    }

    public ServerMM(int portNumber){
        this.port = portNumber;
    }

    public List<ClientThread> getClients(){
        return clientes;
    }

    private void startServer(){
        clientes = new ArrayList<ClientThread>();
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(port);
            acceptClients(ss);
        } catch (IOException e){
            System.err.println("o se puede conectar con el puerto: "+port);
            System.exit(1);
        }
    }

    private void acceptClients(ServerSocket ss){
        System.out.println("Se inicio el server en el puerto= " + ss.getLocalSocketAddress());
        while(true){
            try{
                Socket socket = ss.accept();
                System.out.println("Conexion : " + socket.getRemoteSocketAddress());
                ClientThread cliente = new ClientThread(this, socket);
                Thread thread = new Thread(cliente);
                thread.start();
                clientes.add(cliente);
            } catch (IOException ex){
                System.out.println("Conexion fallida: "+port);
            }
        }
    }
}

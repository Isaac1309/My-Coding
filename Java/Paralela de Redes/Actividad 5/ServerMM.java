
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
    private int MAX =3;
    int currentconnected = 0;
    private int serverPort;

    public static void main(String[] args) {
        ServerMM server = new ServerMM(portNumber);
        server.startServer();
    }

    public ServerMM(int portNumber){
        this.serverPort = portNumber;
    }

    public void closeClient(){
        currentconnected -= 1;
    }

    private void startServer(){
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(serverPort);
            acceptClients(serverSocket);
        } catch (IOException e){
            System.err.println("Could not listen on port: "+serverPort);
            System.exit(1);
        }
    }

    private void acceptClients(ServerSocket serverSocket){
        System.out.println("server starts port = " + serverSocket.getLocalSocketAddress());
        while(true){
            if(currentconnected<MAX) {
                try {
                    Socket socket = serverSocket.accept();
                    System.out.println("accepts : " + socket.getRemoteSocketAddress());
                    ClientThread client = new ClientThread(this, socket);
                    Thread thread = new Thread(client);
                    thread.start();
                    currentconnected++;
                    System.out.println(currentconnected);
                } catch (IOException ex) {
                    System.out.println("Accept failed on : " + serverPort);
                }
            }else{
                System.out.print("");
            }
        }
    }
}

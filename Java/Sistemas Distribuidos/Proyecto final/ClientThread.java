import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientThread implements Runnable {
    private Socket socket;
    private PrintWriter mCliente;
    private ServerMM server;

    public ClientThread(ServerMM server, Socket socket){
        this.server = server;
        this.socket = socket;
    }

    private PrintWriter getWriter(){
        return mCliente;
    }

    public void run() {
        try{
            this.mCliente = new PrintWriter(socket.getOutputStream(), false);
            Scanner scan = new Scanner(socket.getInputStream());
            while(!socket.isClosed()){
                if(scan.hasNextLine()){
                    String mensaje = scan.nextLine();
                    for(ClientThread elCliente : server.getClients()){
                        PrintWriter elMCliente = elCliente.getWriter();
                        if(elMCliente != null){
                            elMCliente.write(mensaje + "\r\n");
                            elMCliente.flush();
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientThread implements Runnable {
    private Socket socket;
    private PrintWriter mCliente;
    private ServerMM server;
    private Logger logger;

    public ClientThread(ServerMM server, Socket socket) {
        this.server = server;
        this.socket = socket;
        logger = new Logger("server-log.txt");
    }

    private PrintWriter getWriter() {
        return mCliente;
    }
	
	public static StringBuffer cifrado(String text, int si) { 
        StringBuffer result= new StringBuffer(); 
  
        for (int i=0; i<text.length(); i++) { 
            if (Character.isUpperCase(text.charAt(i))) { 
                char ch = (char)(((int)text.charAt(i) + 
                                  si - 65) % 26 + 65); 
                result.append(ch); 
            }else if(Character.isLowerCase(text.charAt(i))){
                char ch = (char)(((int)text.charAt(i) + 
                                  si - 97) % 26 + 97); 
                result.append(ch); 
			}else if(Character.isDigit(text.charAt(i))){
                char ch = text.charAt(i); 
                result.append(ch); 
			}else{
				char ch = ' ';
                result.append(ch); 
            } 
        } 
        return result; 
    }

    public void run() {
        try {
            this.mCliente = new PrintWriter(socket.getOutputStream(), false);
            Scanner scan = new Scanner(socket.getInputStream());
            while (!socket.isClosed()) {
                if (scan.hasNextLine()) {
                    String mensaje = scan.nextLine();
                    for (ClientThread elCliente : server.getClients()) {
                        PrintWriter elMCliente = elCliente.getWriter();
                        if (elMCliente != null) {
                            elMCliente.write(mensaje + "\r\n");
							String messageDeciphered = mensaje;
							StringBuffer messageCiphered = cifrado(messageDeciphered, 4);
                            String dateNTime = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date().getTime());
                            logger.writeEvent("<<<<[" + dateNTime + "]>>>>\n" + "Machine: "
                                    + socket.getInetAddress().getCanonicalHostName() + "\n" + "IP: "
                                    + socket.getInetAddress() + "\n" + "Message received: " + messageCiphered + "\n"
                                    + "Message deciphered : " + messageDeciphered + "\n" + "Message sent: "
                                    + messageCiphered + "\n\n");

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
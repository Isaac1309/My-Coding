import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.channels.Selector;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente extends Thread implements ActionListener {
    String ip;
    int port;
    Socket s = null;
    JButton blogin = new JButton("Login");
    JTextField tuser = new JTextField("", 5);
    JTextField tip = new JTextField("", 5);
    JTextField tport = new JTextField("", 5);
    JTextField tmessage = new JTextField(5);
    public static JTextArea tchat = new JTextArea(10, 50);
    JButton bSend = new JButton("Enviar");
    JButton bcon = new JButton("Desconectar");
    boolean connected = true;
    JButton bregister = new JButton("Registrar");
    JFrame fLogin = new JFrame("Login");
    JFrame fClient = new JFrame();
    InputStream serverInStream;
    Scanner serverIn;
    Thread serverAccessThread;
    boolean recivingisdone = false;
    DataOutputStream dout;
    DataInputStream din;
    String inputString, outputString;
    Logger logger = new Logger("client-log.txt");

    public void loginWindow() {
        fLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel plogindata = new JPanel(new FlowLayout());
        fLogin.add(plogindata);
        plogindata.add(new JLabel("Nombre del Usuario"));
        plogindata.add(tuser);
        plogindata.add(new JLabel("Ip"));
        plogindata.add(tip);
        plogindata.add(new JLabel("Puerto"));
        plogindata.add(tport);
        plogindata.add(bregister);
        plogindata.add(blogin);
        bregister.addActionListener(this);
        blogin.addActionListener(this);
        fLogin.setSize(new Dimension(400, 100));
        fLogin.setResizable(false);
        fLogin.setLocation(750, 450);
        fLogin.setVisible(true);
    }

    public void clientWindow(String ip, int port) {
        fClient.setTitle(tuser.getText());
        fClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JScrollPane scroll = new JScrollPane(tchat);
        tchat.setLineWrap(true);
        tchat.setEditable(false);
        bSend.addActionListener(this);
        bcon.addActionListener(this);
        fClient.add(p1);
        p1.add(scroll);
        p1.add(p2);
        p2.add(new JLabel("Inserte texto:"));
        p2.add(tmessage);
        p2.add(bSend);
        p2.add(bcon);
        fClient.setSize(700, 275);
        fClient.setLocation(740, 320);
        fClient.setVisible(true);
        try {
            s = new Socket(ip, port);
            Thread.sleep(1000);
            serverInStream = s.getInputStream();
            serverIn = new Scanner(serverInStream);
            start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Cliente() {
        loginWindow();
    }

    public static void main(String[] args) {
        new Cliente();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == blogin) {
            port = Integer.parseInt(tport.getText());
            if (tip.getText().equals("")) {
                ip = "localhost";
            } else {
                ip = tip.getText();
            }
            clientWindow(ip, port);
            fLogin.setVisible(false);
        }
        if (e.getSource() == bSend && !tmessage.getText().equals("") && connected) {
            try {
                PrintWriter serverOut = new PrintWriter(s.getOutputStream(), false);
                serverOut.print(tuser.getText() + " > " + tmessage.getText() + "\n");
				String messageDeciphered = tuser.getText() + " > " + tmessage.getText() + "\n";
				StringBuffer messageCiphered = cifrado(messageDeciphered, 4);
                String dateNTime = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date().getTime());
                logger.writeEvent("<<<<[" + dateNTime + "]>>>>\n" + "Machine: "
                        + s.getInetAddress().getCanonicalHostName() + "\n" + "IP: " + s.getInetAddress()
                        + "\n" + "Message received: " + messageCiphered + "\n" + "Message deciphered : "
                        + messageDeciphered + "\n" + "Message sent: " + messageCiphered + "\n\n");

                serverOut.flush();
                tmessage.setText("");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if (e.getSource() == bcon) {
            if (connected) {
                try {
                    connected = false;
                    s.close();
                    tchat.append("Conexion cerrada \n");
                    bcon.setText("Establecer conexion");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            } else {
                try {
                    s = new Socket(ip, port);
                    serverInStream = s.getInputStream();
                    serverIn = new Scanner(serverInStream);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                connected = true;
                bcon.setText("Desconectado");
            }
        }
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
            while (!recivingisdone) {
                System.out.print("");
                if (connected) {
                    if (serverInStream.available() > 0) {
                        if (serverIn.hasNextLine()) {
                            tchat.append(serverIn.nextLine() + "\n");
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

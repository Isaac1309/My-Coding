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
    boolean connected =true;
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
        JScrollPane scroll= new JScrollPane(tchat);
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
            s = new Socket(ip,port);
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
            if(tip.getText().equals("")){
                ip= "localhost";
            }else{
                ip=tip.getText();
            }
            clientWindow(ip, port);
            fLogin.setVisible(false);
        }
        if (e.getSource() == bSend && !tmessage.getText().equals("") && connected) {
            try {
                PrintWriter serverOut = new PrintWriter(s.getOutputStream(), false);
                serverOut.print(tuser.getText() + " > " + tmessage.getText()+"\n");
                serverOut.flush();
                tmessage.setText("");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if(e.getSource()==bcon){
            if(connected){
                try {
                    connected=false;
                    s.close();
                    tchat.append("Conexion cerrada \n");
                    bcon.setText("Establecer conexion");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }else{
                try {
                    s = new Socket(ip,port);
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

    public void run() {
        try {
            while(!recivingisdone){
                System.out.print("");
                if(connected) {
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

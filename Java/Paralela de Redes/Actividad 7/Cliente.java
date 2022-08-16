import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
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
    JButton bSend = new JButton("Send");
    JButton bcon = new JButton("disconnect");
    boolean connected =true;
    JButton bregister = new JButton("Register");
    JFrame fLogin = new JFrame("Login");
    JFrame fClient = new JFrame();
    InputStream serverInStream;
    Scanner serverIn;
    DataInputStream in;
    Thread serverAccessThread;
    boolean recivingisdone = false;
    DataOutputStream dout;
    DataInputStream din;
    public void loginWindow() {
        fLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel plogindata = new JPanel(new FlowLayout());
        fLogin.add(plogindata);
        plogindata.add(new JLabel("Username"));
        plogindata.add(tuser);
        plogindata.add(new JLabel("ip"));
        plogindata.add(tip);
        plogindata.add(new JLabel("port"));
        plogindata.add(tport);
        plogindata.add(bregister);
        plogindata.add(blogin);
        bregister.addActionListener(this);
        blogin.addActionListener(this);
        fLogin.setSize(new Dimension(340, 200));
        fLogin.setResizable(false);
        fLogin.setLocation(520, 500);
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
        p2.add(new JLabel("Enter Text:"));
        p2.add(tmessage);
        p2.add(bSend);
        p2.add(bcon);
        fClient.setSize(720, 540);
        fClient.setLocation(740, 320);
        fClient.setVisible(true);
        try {
            s = new Socket(ip,port);
            Thread.sleep(1000);
            serverInStream = s.getInputStream();
            serverIn = new Scanner(serverInStream);
            in = new DataInputStream(s.getInputStream());
            start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    String inputString, outputString;
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
                DataInputStream in = new DataInputStream(s.getInputStream());
                DataOutputStream out = new DataOutputStream(s.getOutputStream());
                out.writeUTF(tmessage.getText());
                tchat.append(tmessage.getText()+"\n");
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
                    tchat.setText("");
                    tchat.append("Connection closed \n");
                    bcon.setText("Connect");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    System.out.println("Error closing socket");
                }
            }else{
                try {
                    s = new Socket(ip,port);
                    serverInStream = s.getInputStream();
                    serverIn = new Scanner(serverInStream);
                    in = new DataInputStream(s.getInputStream());
                    tchat.setText("");
                    tchat.append("Connected\n");
                } catch (IOException ioException) {
                   tchat.append("Could not connect\n");
                }
                connected = true;
                bcon.setText("Disconnect");
            }
        }
    }
    public void run() {
        while(!recivingisdone){
            System.out.print("");
            if(connected) {
                    if (serverIn.hasNextLine()) {
                        tchat.append(serverIn.nextLine() + "\n");
                    }
            }
        }
    }
}

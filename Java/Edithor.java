import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.io.*;
public class Edithor implements ActionListener{
	JFrame f;
	Panel p;
	Button b1, b2, b3, b4;
	JTextArea ta;
	MenuBar mb;
	Menu m1, m2, m3;
	MenuItem mi1, mi2, mi3, mi4, mi5, mi6, mi7, mi8, mi9, mi10, mi11, mi12;
	String  cadena;
	JFileChooser jf;
	JScrollPane jsc;

	public Edithor(){
	 f=new JFrame("Edithor");
	 p=new Panel();
	 // p.setLayout(new GridLayout(1,4));
	 b1=new Button("Mayusculas");
	 b2=new Button("Minusculas");
	 b3=new Button("Cortar");
	 b4=new Button("Pegar");

	 ta=new JTextArea("",25,40);
	 jsc=new JScrollPane(ta);
	 mb=new MenuBar();
	 m1=new Menu("Archivo");
	 m2=new Menu("Edicion");
	 m3=new Menu("Acerca de");
	 mi1=new MenuItem("Nuevo");
	 mi1.addActionListener(this);
	 mi2=new MenuItem("Abrir");
	 mi2.addActionListener(this);
	 mi3=new MenuItem("Guardar");
	 mi3.addActionListener(this);
	 mi4=new MenuItem("Salir");
	 mi4.addActionListener(this);
	 mi5=new MenuItem("Mayusculas");
	 mi5.addActionListener(this);
	 mi6=new MenuItem("Minusculas");
	 mi6.addActionListener(this);
	 mi7=new MenuItem("Copiar");
	 mi7.addActionListener(this);
	 mi8=new MenuItem("Cortar");
	 mi8.addActionListener(this);
	 mi9=new MenuItem("Pegar");
	 mi9.addActionListener(this);
	 mi10=new MenuItem("Selecc.Todo");
	 mi10.addActionListener(this);
	 mi11=new MenuItem("Alvarez Gonzalez Carlos Isaac");
	 mi12=new MenuItem("Edicion: 1.0");

	 f.setMenuBar(mb);
	 mb.add(m1);
	 mb.add(m2);
	 mb.add(m3);
	 m1.add(mi1);
	 m1.add(mi2);
	 m1.add(mi3);
	 m1.addSeparator();
	 m1.add(mi4);
	 m2.add(mi5);
	 m2.add(mi6);
	 m2.add(mi7);
	 m2.add(mi8);
	 m2.add(mi9);
	 m2.add(mi10);
	 m3.add(mi11);
	 m3.add(mi12);

	 p.add(b1);
	 p.add(b2);
	 p.add(b3);
	 p.add(b4);
	 f.add(p,BorderLayout.NORTH);
	 f.add(jsc,BorderLayout.CENTER);
	 b1.setBackground(new Color(128,0,64));
	 b1.setForeground(Color.white);
	 b1.setFont(new Font("Arial", Font.BOLD,12));
	 b2.setBackground(new Color(128,0,64));
	 b2.setForeground(Color.white);
	 b2.setFont(new Font("Arial", Font.BOLD,12));
	 b3.setBackground(new Color(128,0,64));
	 b3.setForeground(Color.white);
	 b3.setFont(new Font("Arial", Font.BOLD,12));
	 b4.setBackground(new Color(128,0,64));
	 b4.setForeground(Color.white);
	 b4.setFont(new Font("Arial", Font.BOLD,12));

	 b1.addActionListener(this);
	 b2.addActionListener(this);
	 b3.addActionListener(this);
	 b4.addActionListener(this);
	 f.setSize(800,950);
	 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 f.setVisible(true);
}	
	public void actionPerformed(ActionEvent e){
	 String cad;
	 if(e.getSource().equals(mi1)){
		ta.setText("");
	 }
	 else if(e.getSource().equals(mi4)){
		System.exit(0);
	 }
	 else if(e.getSource().equals(mi5)||e.getSource().equals(b1)){
		cad=ta.getSelectedText();
		ta.replaceRange(cad.toUpperCase(),ta.getSelectionStart(),ta.getSelectionEnd());
	 }
	 else if(e.getSource().equals(mi6)||e.getSource().equals(b2)){
		cad=ta.getSelectedText();
		ta.replaceRange(cad.toLowerCase(),ta.getSelectionStart(),ta.getSelectionEnd());
	 }
	 else if(e.getSource().equals(mi7)){
		cadena=ta.getSelectedText();
	 }
	 else if(e.getSource().equals(mi8)||e.getSource().equals(b3)){
		cadena=ta.getSelectedText();
		ta.replaceRange("",ta.getSelectionStart(),ta.getSelectionEnd());
	 }
	 else if(e.getSource().equals(mi9)||e.getSource().equals(b4)){
		ta.insert(cadena,ta.getCaretPosition());
	 }
	 else if(e.getSource().equals(mi10)){
		ta.selectAll();
	 }
	 else if(e.getSource().equals(mi2)){
		FileNameExtensionFilter filter=new FileNameExtensionFilter("Archivos de texto","txt","java","c","cpp","bath","html");
		int returnVal;
		jf=new JFileChooser();
		jf.setFileFilter(filter);
		returnVal = jf.showOpenDialog(f);
		if(returnVal == jf.APPROVE_OPTION){
		 System.out.println("You choose to open this file: "+ jf.getSelectedFile().getName());
		 ta.setText(abrir(jf.getSelectedFile()));
		}
	 }
	else if(e.getSource().equals(mi3)){	//Guardar
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto", "txt","java","c","cpp","bath","html");
		int returnVal;
		jf = new JFileChooser();
		 jf.setFileFilter(filter);
		 returnVal=jf.showSaveDialog(f);
		 if(returnVal==jf.APPROVE_OPTION){
		 System.out.printf("You choose to save like: " + jf.getSelectedFile().getName());
		 guardar(ta.getText(),jf.getSelectedFile());	
		}			
	}
}
	public String abrir(File archivos){
	 String lectura="", retorno="";
	 if(archivos!=null){
		try{
		 FileReader fr=new FileReader(archivos);
		 BufferedReader d=new BufferedReader(fr);
		 while((lectura=d.readLine())!=null){
			retorno+=lectura+"\n";}
		d.close();
		}catch(IOException e){
			System.out.println("Error de E/S");
		}
	 }return retorno;
}
	public boolean guardar (String text,File archivos){
	 boolean exito=false;
	 System.out.println(text);
	 if(archivos!=null){
		try{
		 FileWriter fr=new FileWriter(archivos);
		 fr.write(text);
		 exito=true;
		 fr.close();
		}catch(IOException e){
		 System.out.println("Error de E/S");
		}
	 }return exito;
}
	public static void main (String args[]){
	 Edithor g=new Edithor();
	 
}
}
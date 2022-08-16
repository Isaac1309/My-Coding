import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

class MyLabel extends JLabel{
	int actual, real;
	boolean acomodada;
 public MyLabel(int r){
	real=r;
	actual=-1; //aun no se le asigna
	acomodada=false;
 }
 public MyLabel(ImageIcon im, int r){
	super(im);
	real=r;
	actual=-1; //aun no se le asigna
	acomodada=false;
 }
 public void setActual(int a){
	actual=a;
 }
 public int getActual(){
	return actual;
 }
 public void setReal(int a){
	real=a;
 }
 public int getReal(){
	return real;
 }
 public void setAcomodada(boolean b){
	acomodada=b;
 }
 public boolean getAcomodada(){
	return acomodada;
 }

}

public class RompeCabezas extends MouseAdapter implements ActionListener{
	JFrame f;
	MyLabel partir[], jl1;
	JLabel completa;
	JButton inicio, cancelar;
	Panel p, p2, p1, pi;
	String lista[];
	Vector<Integer> v;
	CardLayout cl;
	int hrs,min,seg;
	boolean cambio,stop,first,verImg;

	Cronometro crono;
	Vector <Ganador> top;
	
	public RompeCabezas(){
	 if(!recuperaTop())
		top=new Vector<Ganador>(5);
		cambio=false;	
		verImg=false;

	 f=new JFrame("Rompe Cabezas");
	 p=new Panel();
	 p1=new Panel();
	 p2=new Panel(new GridLayout(4,3));
	 pi=new Panel(cl=new CardLayout());
	 inicio=new JButton("Iniciar");
	 cancelar=new JButton("Cancelar");
	 crono=new Cronometro();
	 completa=new JLabel(new ImageIcon("donnie.jpg"));
	 
	 p.add(inicio);
	 p.add(cancelar);
	 p.add(crono);
	 stop=false;

	 p1.add(completa);
	 pi.add(p1, "First");
	 pi.add(p2, "Second");
	 f.add(p,BorderLayout.NORTH);
	 f.add(pi,BorderLayout.CENTER);
	 f.setSize(706,1095);
	 f.setResizable(false);
	 f.setLocation(100,0);
		Image icon = new ImageIcon(getClass().getResource(".\\donnie.jpg")).getImage();
		f.setIconImage(icon);
	 inicio.addActionListener(this);
	 cancelar.addActionListener(this);

		inicio.setBackground(Color.LIGHT_GRAY);
		inicio.setForeground(Color.MAGENTA);
		inicio.setFont(new Font("",Font.ITALIC,12));
		cancelar.setBackground(Color.LIGHT_GRAY);
		cancelar.setForeground(Color.MAGENTA);
		cancelar.setFont(new Font("",Font.ITALIC,12));

	 f.setVisible(true);
	 f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	 lista=(new File(".\\imgs\\")).list();
	 System.out.println("Se cargaran"+lista.length+"imagenes");
	 cl.show(pi,"First");
	 partir=new MyLabel[lista.length];
		for(int i=0;i<lista.length;i++){
		  partir[i]=new MyLabel(new ImageIcon(".\\imgs\\"+lista[i]),i);
		  partir[i].setBorder(null);
		  partir[i].addMouseListener(this);
		  p2.add(partir[i]);
		}
	}

public boolean recuperaTop(){
	boolean leiste=true;
	try{
	FileInputStream fis=new FileInputStream("Ganadores.dat");
	ObjectInputStream ois = new ObjectInputStream(fis);
	top=(Vector<Ganador>)ois.readObject();
		}catch(IOException E){ 
	System.out.println("Error al leer/escribir en el archivo");
			leiste=false;
	}
		catch(ClassNotFoundException E){ 
	System.out.println("El tipo de la clase al que pertenece el objeto ");
			leiste=false;
	}
	return leiste;
}

	public void revolver(int n){
	   v=new Vector<Integer>();
	   for(int i=0;i<n;i++){
		v.add(new Integer(i));
	   }
	   System.out.println("\n\n");
	   Collections.shuffle(v);
	   for(int i=0;i<v.size();i++)
		System.out.print(v.get(i)+"");
	   }

	public void actionPerformed(ActionEvent e){
	   if(e.getSource().equals(inicio)){
		 revolver(lista.length);
		for(int i=0;i<lista.length;i++){
		  partir[i].setIcon(new ImageIcon(".\\imgs\\"+lista[v.get(i)]));
		  partir[i].setActual(v.get(i));
		  System.out.println("  "+i);
		}
			System.out.println("inicio");
		cl.previous(pi);
		crono.start();		
		
		}else{
			if(!verImg){
				cl.first(pi);
				verImg=true;
			}else{
				cl.last(pi);
				verImg=false;
			}
		}
	 }

public void mouseMoved(MouseEvent e){}
public void mousePressed(MouseEvent e){}
public void mouseReleased(MouseEvent e){}

public void leCoRe(int tiempo){
	for(int i=0;i<top.size();i++)
		if(((Ganador)top.get(i)).getTime()<tiempo)
		;
			
} 

	public void mouseClicked(MouseEvent e){
	 Icon img;
	 int temp, k;
	  MyLabel seg=(MyLabel)e.getSource();
	 if(!cambio){
		cambio=true;
		jl1=seg;
	 }else{
		cambio=false;
		img=seg.getIcon();
		seg.setIcon(jl1.getIcon());
		jl1.setIcon(img);
		temp=jl1.getActual();
		jl1.setActual(seg.getActual());
		seg.setActual(temp);
		if(jl1.getActual()==jl1.getReal()){
		  jl1.setAcomodada(true);
		  System.out.println("Etiqueta primer click acomodada");
		}
		if(seg.getActual()==seg.getReal()){
		  seg.setAcomodada(true);
		  System.out.println("Etiqueta segundo  click acomodada");
		}
		for(k=0; k<partir.length;k++)
		  if(!partir[k].getAcomodada()){
			break;}
		if(k==partir.length){
		System.out.println("Eres Victor el Oso");
		leCoRe(crono.stop());
		}
	}
	}

	public static void main (String args[]){
	 new RompeCabezas();
	}
}
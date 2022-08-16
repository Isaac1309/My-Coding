import java.awt.*;
import java.awt.event.*;
public class Actboton implements ActionListener{
	Frame f, f1;
	Button b1, b2, b3;

	public Actboton(){
	 f=new Frame("Botones que responden");
	 b1=new Button("Salir");
	 b2=new Button("Siguiente");
	 
	 b1.addActionListener(this);
	 b2.addActionListener(this);

	 f.add(b1,BorderLayout.SOUTH);
	 f.add(b2,BorderLayout.CENTER);

	 b1.setBackground(new Color(128,0,64));
	 b1.setForeground(Color.white);
	 b1.setFont(new Font("Arial", Font.BOLD,24));
	 b2.setBackground(new Color(128,0,64));
	 b2.setForeground(Color.white);
	 b2.setFont(new Font("Arial", Font.BOLD,36));
	 f.setSize(400,400);
	 f.setVisible(true);
}	
	public void actionPerformed(ActionEvent ev){
	 if(ev.getSource().equals(b1))
	  System.exit(0);
	 else if(ev.getSource().equals(b3)){
		f1.dispose();
		f1=null;
}
	 else if(ev.getActionCommand()=="Siguiente"){
		if(f1==null){
		 f1=new Frame("Secundaria");
		  b3=new Button("Salir");
		  f1.add(b3);
		  b3.addActionListener(this);
			b3.setBackground(new Color(128,0,64));
			b3.setForeground(Color.white);
			b3.setFont(new Font("Arial", Font.BOLD,48));
		  f1.setSize(400,400);
		  f1.setVisible(true);		  
}
}
}
	public static void main(String args[]){
	 Actboton g=new Actboton();
	 
}
}
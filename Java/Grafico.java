import java.awt.*;
public class Grafico{
	Frame f;
	Panel p;
	Button b1, b2;
	Label e;
	Choice ch;
	Checkbox cb, m, o;
	CheckboxGroup cg;
	TextField tf;
	TextArea ta;
	MenuBar mb;
	Menu m1, m2;
	MenuItem mi1, mi2, mi3, mi4;
	CheckboxMenuItem cbmi;

	public Grafico(){
	 f=new Frame("Titulo o nombre de la aplicacion");
	 p=new Panel();
	 p.setLayout(new GridLayout(2,1));
	 b1=new Button("Salir");
	 b2=new Button("Siguiente");
	 e=new Label("Esto es una etiqueta");
	 ch=new Choice();
	 ch.add("10");
	 ch.add("20");
	 ch.add("30");
	 ch.add("40");
	 cg=new CheckboxGroup();
	 cb=new Checkbox("Masculino",false,cg);
	 m=new Checkbox("Femenino",false,cg);
	 o=new Checkbox("Otro",false,cg);
	 tf=new TextField(50);
	 ta=new TextArea("escribe aqui",5,20,TextArea.SCROLLBARS_BOTH);
	 mb=new MenuBar();
	 m1=new Menu("Archivo");
	 m2=new Menu("Edicion");
	 mi1=new MenuItem("Nuevo");
	 mi2=new MenuItem("Abrir");
	 mi3=new MenuItem("Copiar");
	 mi4=new MenuItem("Cortar");
	 cbmi= new CheckboxMenuItem("Vista de impresion");

	 f.setMenuBar(mb);
	 mb.add(m1);
	 m1.add(mi1);
	 m1.addSeparator();
	 m1.add(mi2);
	 m1.addSeparator();
	 m1.add(m2);
	 m2.add(mi3);
	 m2.addSeparator();
	 m2.add(cbmi);
	 m2.addSeparator();
	 m2.add(mi4);

	 f.setLayout(new FlowLayout());
	 f.add(b1);
	 f.add(b2);
	 f.add(e);
	 f.add(ch);
	 f.add(cb);
	 f.add(m);
	 f.add(o);
	 f.add(p);
	 p.add(tf);
	 p.add(ta);
	 b1.setBackground(new Color(128,0,64));
	 b1.setForeground(Color.white);
	 b1.setFont(new Font("Arial", Font.BOLD,12));
	 f.setSize(250,250);
	 f.setVisible(true);
}	
	public static void main(String args[]){
	 Grafico g=new Grafico();
	 
}
}
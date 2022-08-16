import java.awt.*;
import javax.swing.event.*;
public class TablaPeriodica{
	Frame f;
	String nom[]={"H","Li","Na","K","Rb","Cs","Fr","Be","Mg","Ca","Sr","Ba","Ra","Sc","Ti","V","Cr","Mn","Fe","Co","Ni","Cu","Zn","Y","Zr","Nb","Mo","Tc","Ru","Rh","Pd","Ag","Cd","La-Lu","Hf","Ta","W","Re","Os","Ir","Pt","Au","Hg","Ac-Lr","Rf","Db","Sg","Bh","Hs","Mt","Ds","Rg","Cn","B","C","N","O","F","Al","Si","P","S","Cl","Ga","Ge","As","Se","Br","In","Sn","Sb","Te","I","Tl","Pb","Bi","Po","At","Uut","Fl","Uup","Lv","Uus","He","Ne","Ar","Kr","Xe","Rn","Uuo","La","Ce","Pr","Nd","Pm","Sm","Eu","Gd","Tb","Dy","Ho","Er","Tm","Yb","Lu","Ac","Th","Pa","U","Np","Pu","Am","Cm","Bk","Cf","Es","Fm","Md","No","Lr"};
	Label elementos[];
	Panel p1,p2,p3,p4,p5,p6;

	public TablaPeriodica(){
		f = new Frame("Tabla Periodica");
		f.setSize(500,500);
		f.setLocation(400,300);
		f.setVisible(true);
		p1 = new Panel();
		p2=new Panel();
		p3=new Panel();
		p4=new Panel();
		p5=new Panel();
		p6=new Panel();
		int i =0;

		elementos = new Label[120];
		for(i=0;i<7;i++){
			elementos[i]=new Label(nom[i]);
			elementos[i].setBackground(Color.green);
			p1.add(elementos[i]);}

		p1.setLayout(new GridLayout(7,0));

		f.add(p1);

	}
public static void main(String[] args){
	new TablaPeriodica();
}

}
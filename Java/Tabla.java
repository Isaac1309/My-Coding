import java.awt.*;
import javax.swing.*;
public class Tabla{
	JFrame f;
	String nom[]={"H","","Li","Be","Na","Mg","K","Ca","Rb","Sr","Cs","Ba","Fr","Ra","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","Sc","Ti","V","Cr","Mn","Fe","Co","Ni","Cu","Zn","Y","Zr","Nb","Mo","Tc","Ru","Rh","Pd","Ag","Cd","La-Lu","Hf","Ta","W","Re","Os","Ir","Pt","Au","Hg","Ac-Lr","Rf","Db","Sg","Bh","Hs","Mt","Ds","Rg","Cn","","","","","","He","B","C","N","O","F","Ne","Al","Si","P","S","Cl","Ar","Ga","Ge","As","Se","Br","Kr","In","Sn","Sb","Te","I","Xe","Tl","Pb","Bi","Po","At","Rn","Uut","Fl","Uup","Lv","Uus","Uuo","La","Ce","Pr","Nd","Pm","Sm","Eu","Gd","Tb","Dy","Ho","Er","Tm","Yb","Lu","Ac","Th","Pa","U","Np","Pu","Am","Cm","Bk","Cf","Es","Fm","Md","No","Lr"};
	Label elementos[];
	Panel p1, p3, p5, p6, pa;

	public Tabla(){
	 f=new JFrame("Tabla Periodica");
	 p1=new Panel();
	 p3=new Panel();
	 p5=new Panel();
	 p6=new Panel();
	 pa=new Panel();
	 int i =0;

	 elementos = new Label[156];
	 for(i=0;i<14;i++){
		elementos[i]=new Label(nom[i]);
		elementos[i].setBackground(new Color(255,170,80));
		elementos[i].setFont(new Font("Arial", Font.BOLD,18));
		p1.add(elementos[i]);
	}
		elementos[0].setBackground(new Color(20,180,40));
		elementos[3].setBackground(new Color(240,230,180));
		elementos[5].setBackground(new Color(240,230,180));
		elementos[7].setBackground(new Color(240,230,180));
		elementos[9].setBackground(new Color(240,230,180));
		elementos[11].setBackground(new Color(240,230,180));
		elementos[13].setBackground(new Color(240,230,180));
		elementos[1].setBackground(Color.white);

	 for(i=14;i<84;i++){
		elementos[i]=new Label(nom[i]);
		elementos[i].setBackground(new Color(50,130,250));
		elementos[i].setFont(new Font("Arial", Font.BOLD,18));
		p3.add(elementos[i]);
	}
		elementos[14].setBackground(Color.white);
		elementos[15].setBackground(Color.white);
		elementos[16].setBackground(Color.white);
		elementos[17].setBackground(Color.white);
		elementos[18].setBackground(Color.white);
		elementos[19].setBackground(Color.white);
		elementos[20].setBackground(Color.white);
		elementos[21].setBackground(Color.white);
		elementos[22].setBackground(Color.white);
		elementos[23].setBackground(Color.white);
		elementos[24].setBackground(Color.white);
		elementos[25].setBackground(Color.white);
		elementos[26].setBackground(Color.white);
		elementos[27].setBackground(Color.white);
		elementos[28].setBackground(Color.white);
		elementos[29].setBackground(Color.white);
		elementos[30].setBackground(Color.white);
		elementos[31].setBackground(Color.white);
		elementos[32].setBackground(Color.white);
		elementos[33].setBackground(Color.white);
		elementos[34].setBackground(Color.white);
		elementos[35].setBackground(Color.white);
		elementos[36].setBackground(Color.white);
		elementos[37].setBackground(Color.white);
		elementos[38].setBackground(Color.white);
		elementos[39].setBackground(Color.white);
		elementos[40].setBackground(Color.white);
		elementos[41].setBackground(Color.white);
		elementos[42].setBackground(Color.white);
		elementos[43].setBackground(Color.white);
		elementos[64].setBackground(new Color(255,60,60));
		elementos[74].setBackground(new Color(255,130,210));

	 for(i=84;i<126;i++){
		elementos[i]=new Label(nom[i]);
		elementos[i].setBackground(new Color(0,200,0));
		elementos[i].setFont(new Font("Arial", Font.BOLD,18));
		p5.add(elementos[i]);
	}
		elementos[84].setBackground(Color.white);
		elementos[85].setBackground(Color.white);
		elementos[86].setBackground(Color.white);
		elementos[87].setBackground(Color.white);
		elementos[88].setBackground(Color.white);
		elementos[89].setBackground(new Color(0,255,255));
		elementos[95].setBackground(new Color(0,255,255));
		elementos[101].setBackground(new Color(0,255,255));
		elementos[107].setBackground(new Color(0,255,255));
		elementos[113].setBackground(new Color(0,255,255));
		elementos[119].setBackground(new Color(0,255,255));
		elementos[91].setBackground(new Color(0,160,0));
		elementos[92].setBackground(new Color(0,160,0));
		elementos[93].setBackground(new Color(0,160,0));
		elementos[94].setBackground(new Color(0,160,0));
		elementos[98].setBackground(new Color(0,160,0));
		elementos[99].setBackground(new Color(0,160,0));
		elementos[100].setBackground(new Color(0,160,0));
		elementos[105].setBackground(new Color(0,160,0));
		elementos[106].setBackground(new Color(0,160,0));
		elementos[112].setBackground(new Color(0,160,0));
		elementos[96].setBackground(new Color(160,250,230));
		elementos[102].setBackground(new Color(160,250,230));
		elementos[108].setBackground(new Color(160,250,230));
		elementos[109].setBackground(new Color(160,250,230));
		elementos[114].setBackground(new Color(160,250,230));
		elementos[115].setBackground(new Color(160,250,230));
		elementos[116].setBackground(new Color(160,250,230));
		elementos[117].setBackground(new Color(160,250,230));
		elementos[121].setBackground(new Color(160,250,230));
		elementos[120].setBackground(new Color(50,130,250));
		elementos[122].setBackground(new Color(50,130,250));
		elementos[123].setBackground(new Color(50,130,250));
		elementos[124].setBackground(new Color(50,130,250));
		elementos[125].setBackground(new Color(50,130,250));

	 for(i=126;i<156;i++){
		elementos[i]=new Label(nom[i]);
		elementos[i].setBackground(new Color(255,130,210));
		elementos[i].setFont(new Font("Arial", Font.BOLD,18));
		p6.add(elementos[i]);
	}
		elementos[126].setBackground(new Color(255,60,60));
		elementos[127].setBackground(new Color(255,60,60));
		elementos[128].setBackground(new Color(255,60,60));
		elementos[129].setBackground(new Color(255,60,60));
		elementos[130].setBackground(new Color(255,60,60));
		elementos[131].setBackground(new Color(255,60,60));
		elementos[132].setBackground(new Color(255,60,60));
		elementos[133].setBackground(new Color(255,60,60));
		elementos[134].setBackground(new Color(255,60,60));
		elementos[135].setBackground(new Color(255,60,60));
		elementos[136].setBackground(new Color(255,60,60));
		elementos[137].setBackground(new Color(255,60,60));
		elementos[138].setBackground(new Color(255,60,60));
		elementos[139].setBackground(new Color(255,60,60));
		elementos[140].setBackground(new Color(255,60,60));

	 f.add(pa);
	 pa.setLayout(new BorderLayout());
	 p1.setLayout(new GridLayout(7,1,5,5));
	 p3.setLayout(new GridLayout(7,9,5,5));
	 p5.setLayout(new GridLayout(7,5,5,5));
	 p6.setLayout(new GridLayout(2,14,5,5));
	 pa.add(p1, BorderLayout.WEST);
	 pa.add(p3, BorderLayout.CENTER);
	 pa.add(p5, BorderLayout.EAST);
	 pa.add(p6, BorderLayout.SOUTH);

	 f.setLayout(new GridLayout(2,5));
	 f.setSize(1300,500);
	 f.setVisible(true);
	 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
	public static void main (String args[]){
	 Tabla g=new Tabla();
	}
}
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Event.*;
import java.util.*;
import javax.swing.JOptionPane.*;

public class TablaP extends JFrame implements ActionListener {
	JButton H,Li,Be,Na,Mg,K,Ca,Rb,Sr,Cs,Ba,Fr,Ra,Sc,T,V,Cr,Mn,Fe,Co,Ni,Cu,Zn,Y,Zr,Nb,Mo,Tc,Ru,Rh,Pd,Ag,Cd,LaLu,Hf,Ta,W,Re,Os,Ir,Pt,Au,Hg,AcLr,Rf,Db,Sg,Bh,Hs,Mt,Ds,Rg,Cn,He,B,C,N,O,F,Ne,Al,Si,P,S,Cl,Ar,Ga,Ge,As,Se,Br,Kr,In,Sn,Sb,Te,I,Xe,Tl,Pb,Bi,Po,At,Rn,Fl,Nh,Mc,Lv,Ts,Og,La,Ce,Pr,Nd,Pm,Sm,Eu,Gd,Tb,Dy,Ho,Er,Tm,Yb,Lu,Ac,Th,Pa,U,Np,Pu,Am,Cm,Bk,Cf,Es,Fm,Md,No,Lr;
	JLabel mnsj;

 public TablaP(){
	setLayout(null);
	mnsj = new JLabel ("\t Tabla Periódica De Los Elementos Químicos");
	mnsj.setBounds(250, 0, 400, 300);
	add(mnsj);

	H = new JButton ("H");
	H.setBounds(10, 100,53, 53);
	H.setBackground(new Color(20,180,40));
	add(H);	H.addActionListener(this);
	 Li = new JButton ("Li");
	Li.setBounds(10, 153, 53, 53);
	Li.setBackground(new Color(255,170,80));
	add(Li);	Li.addActionListener(this);
	Na = new JButton ("Na");
	Na.setBounds(10, 206, 53, 53);
	Na.setBackground(new Color(255,170,80));
	add(Na);	Na.addActionListener(this);
	K = new JButton ("K");
	K.setBounds(10, 259, 53, 53);
	K.setBackground(new Color(255,170,80));
	add(K);	K.addActionListener(this);
	Rb = new JButton ("Rb");
	Rb.setBounds(10, 312, 53, 53);
	Rb.setBackground(new Color(255,170,80));
	add(Rb);	Rb.addActionListener(this);
	Cs = new JButton ("Cs");
	Cs.setBounds(10, 365, 53, 53);
	Cs.setBackground(new Color(255,170,80));
	add(Cs);	Cs.addActionListener(this);
	Fr = new JButton ("Fr");
	Fr.setBounds(10, 418, 53, 53);
	Fr.setBackground(new Color(255,170,80));
	add(Fr);	Fr.addActionListener(this);
	Be = new JButton ("Be");
	Be.setBounds(63, 153, 53, 53);
	Be.setBackground(new Color(240,230,180));
	add(Be);	Be.addActionListener(this);
	Mg = new JButton ("Mg");
	Mg.setBounds(63, 206, 53, 53);
	Mg.setBackground(new Color(240,230,180));
	add(Mg);	Mg.addActionListener(this);
	Ca = new JButton ("Ca");
	Ca.setBounds(63, 259, 53, 53);
	Ca.setBackground(new Color(240,230,180));
	add(Ca);	Ca.addActionListener(this);
	Sr = new JButton ("Sr");
	Sr.setBounds(63, 312, 53, 53);
	Sr.setBackground(new Color(240,230,180));
	add(Sr);	Sr.addActionListener(this);
	Ba = new JButton ("Ba");
	Ba.setBounds(63, 365, 53, 53);
	Ba.setBackground(new Color(240,230,180));
	add(Ba);	Ba.addActionListener(this);
	Ra = new JButton ("Ra");
	Ra.setBounds(63, 418, 53, 53);
	Ra.setBackground(new Color(240,230,180));
	add(Ra);	Ra.addActionListener(this);
	Sc = new JButton ("Sc");
	Sc.setBounds(116, 259, 53, 53);
	Sc.setBackground(new Color(50,130,250));
	add(Sc);	Sc.addActionListener(this);
	Y = new JButton ("Y");
	Y.setBounds(116, 312, 53, 53);
	Y.setBackground(new Color(50,130,250));
	add(Y);	Y.addActionListener(this);
	LaLu = new JButton ("La-Lu");
	 LaLu.setBounds(116, 365, 53, 53);
	LaLu.setBackground(new Color(255,60,60));
	add(LaLu);	LaLu.addActionListener(this);
	AcLr = new JButton ("Ac-Lr");
	 AcLr.setBounds(116, 418, 53, 53);
	AcLr.setBackground(new Color(255,60,200));
	add(AcLr);	AcLr.addActionListener(this);
	T = new JButton ("Ti");
	T.setBounds(169, 259, 53, 53);
	T.setBackground(new Color(50,130,250));
	add(T);	T.addActionListener(this);
	Zr = new JButton ("Zr");
	Zr.setBounds(169, 312, 53, 53);
	Zr.setBackground(new Color(50,130,250));
	add(Zr);	Zr.addActionListener(this);
	Hf = new JButton ("Hf");
	Hf.setBounds(169, 365, 53, 53);
	Hf.setBackground(new Color(50,130,250));
	add(Hf);	Hf.addActionListener(this);
	Rf = new JButton ("Rf");
	Rf.setBounds(169, 418, 53, 53);
	Rf.setBackground(new Color(50,130,250));
	add(Rf);	Rf.addActionListener(this);
	V = new JButton ("V");
	V.setBounds(222, 259, 53, 53);
	V.setBackground(new Color(50,130,250));
	add(V);	V.addActionListener(this);
	Nb = new JButton ("Nb");
	Nb.setBounds(222, 312, 53, 53);
	Nb.setBackground(new Color(50,130,250));
	add(Nb);	Nb.addActionListener(this);
	Ta = new JButton ("Ta");
	Ta.setBounds(222, 365, 53, 53);
	Ta.setBackground(new Color(50,130,250));
	add(Ta);	Ta.addActionListener(this);
	Db = new JButton ("Db");
	Db.setBounds(222, 418, 53, 53);
	Db.setBackground(new Color(50,130,250));
	add(Db);	Db.addActionListener(this);
	Cr = new JButton ("Cr");
	Cr.setBounds(275, 259, 53, 53);
	Cr.setBackground(new Color(50,130,250));
	add(Cr);	Cr.addActionListener(this);
	Mo = new JButton ("Mo");
	Mo.setBounds(275, 312, 53, 53);
	Mo.setBackground(new Color(50,130,250));
	add(Mo);	Mo.addActionListener(this);
	W = new JButton ("W");
	W.setBounds(275, 365, 53, 53);
	W.setBackground(new Color(50,130,250));
	add(W);	W.addActionListener(this);
	Sg = new JButton ("Sg");
	Sg.setBounds(275, 418, 53, 53);
	Sg.setBackground(new Color(50,130,250));
	add(Sg);	Sg.addActionListener(this);
	Mn = new JButton("Mn");
	Mn.setBounds(328, 259, 53, 53);
	Mn.setBackground(new Color(50,130,250));
	add(Mn);	Mn.addActionListener(this);
	Tc = new JButton ("Tc");
	Tc.setBounds(328, 312, 53, 53);
	Tc.setBackground(new Color(50,130,250));
	add(Tc);	Tc.addActionListener(this);
	Re = new JButton ("Re");
	Re.setBounds(328, 365, 53, 53);
	 Re.setBackground(new Color(50,130,250));
	add(Re);	Re.addActionListener(this);
	Bh = new JButton ("Bh");
	Bh.setBounds(328, 418, 53, 53);
	Bh.setBackground(new Color(50,130,250));
	add(Bh);	Bh.addActionListener(this);
	Fe = new JButton ("Fe");
	Fe.setBounds(381, 259, 53, 53);
	Fe.setBackground(new Color(50,130,250));
	add(Fe);	Fe.addActionListener(this);
	Ru = new JButton ("Ru");
	Ru.setBounds(381, 312, 53, 53);
	Ru.setBackground(new Color(50,130,250));
	add(Ru);	Ru.addActionListener(this);
	Os = new JButton ("Os");
	Os.setBounds(381, 365, 53, 53);
	Os.setBackground(new Color(50,130,250));
	add(Os);	Os.addActionListener(this);
	Hs = new JButton ("Hs");
	Hs.setBounds(381, 418, 53, 53);
	Hs.setBackground(new Color(50,130,250));
	add(Hs);	Hs.addActionListener(this);
	Co = new JButton ("Co");
	Co.setBounds(434, 259, 53, 53);
	Co.setBackground(new Color(50,130,250));
	add(Co);	Co.addActionListener(this);
	Rh = new JButton ("Rh");
	Rh.setBounds(434, 312, 53, 53);
	Rh.setBackground(new Color(50,130,250));
	add(Rh);	Rh.addActionListener(this);
	Ir = new JButton ("Ir");
	Ir.setBounds(434, 365, 53, 53);
	Ir.setBackground(new Color(50,130,250));
	add(Ir);	Ir.addActionListener(this);
	Mt = new JButton ("Mt");
	Mt.setBounds(434, 418, 53, 53);
	Mt.setBackground(new Color(50,130,250));
	add(Mt);	Mt.addActionListener(this);
	 Ni = new JButton ("Ni");
	Ni.setBounds(487, 259, 53, 53);
	Ni.setBackground(new Color(50,130,250));
	add(Ni);	Ni.addActionListener(this);
	Pd = new JButton ("Pd");
	Pd.setBounds(487, 312, 53, 53);
	 Pd.setBackground(new Color(50,130,250));
	add(Pd);	Pd.addActionListener(this);
	 Pt = new JButton ("pt");
	Pt.setBounds(487, 365, 53, 53);
	Pt.setBackground(new Color(50,130,250));
	add(Pt);	Pt.addActionListener(this);
	Ds = new JButton ("Ds");
	Ds.setBounds(487, 418, 53, 53);
	Ds.setBackground(new Color(50,130,250));
	add(Ds);	Ds.addActionListener(this);
	Cu = new JButton ("Cu");
	Cu.setBounds(540, 259, 53, 53);
	Cu.setBackground(new Color(50,130,250));
	add(Cu);	Cu.addActionListener(this);
	Ag = new JButton ("Ag");
	 Ag.setBounds(540, 312, 53, 53);
	 Ag.setBackground(new Color(50,130,250));
	add(Ag);	Ag.addActionListener(this);
	Au = new JButton ("Au");
	Au.setBounds(540, 365, 53, 53);
	Au.setBackground(new Color(50,130,250));
	add(Au);	Au.addActionListener(this);
	Rg = new JButton ("Rg");
	Rg.setBounds(540, 418, 53, 53);
	Rg.setBackground(new Color(50,130,250));
	add(Rg);	Rg.addActionListener(this);
	Zn = new JButton ("Zn");
	Zn.setBounds(593, 259, 53, 53);
	Zn.setBackground(new Color(50,130,250));
	add(Zn);	Zn.addActionListener(this);
	Cd = new JButton ("Cd");
	Cd.setBounds(593, 312, 53, 53);
	Cd.setBackground(new Color(50,130,250));
	 add(Cd);	Cd.addActionListener(this);
	Hg = new JButton ("Hg");
	Hg.setBounds(593, 365, 53, 53);
	Hg.setBackground(new Color(50,130,250));
	add(Hg);	Hg.addActionListener(this);
	Cn = new JButton ("Cn");
	Cn.setBounds(593, 418, 53, 53);
	Cn.setBackground(new Color(50,130,250));
	add(Cn);	Cn.addActionListener(this);
	B = new JButton ("B");
	B.setBounds(646, 153, 53, 53);
	B.setBackground(new Color(0,236,0));
	add(B);	B.addActionListener(this);
	Al = new JButton ("Al");
	Al.setBounds(646, 206, 53, 53);
	Al.setBackground(new Color(200,255,250));
	add(Al);	Al.addActionListener(this);
	Ga = new JButton ("Ga");
	Ga.setBounds(646, 259, 53, 53);
	Ga.setBackground(new Color(200,255,250));
	add(Ga);	Ga.addActionListener(this);
	In = new JButton ("In");
	In.setBounds(646, 312, 53, 53);
	In.setBackground(new Color(200,255,250));
	add(In);	In.addActionListener(this);
	Tl = new JButton ("Tl");
	Tl.setBounds(646, 365, 53, 53);
	Tl.setBackground(new Color(200,255,250));
	add(Tl);	Tl.addActionListener(this);
	Nh = new JButton ("Nh");
	Nh.setBounds(646, 418, 53, 53);
	Nh.setBackground(new Color(50,130,250));
	add(Nh);	Nh.addActionListener(this);
	C = new JButton ("C");
	 C.setBounds(699, 153, 53, 53);
	C.setBackground(new Color(20,180,40));
	add(C);	C.addActionListener(this);
	Si = new JButton ("Si");
	Si.setBounds(699, 206, 53, 53);
	Si.setBackground(new Color(0,236,0));
	add(Si);	Si.addActionListener(this);
	Ge = new JButton ("Ge");
	Ge.setBounds(699, 259, 53, 53);
	Ge.setBackground(new Color(0,236,0));
	add(Ge);	Ge.addActionListener(this);
	Sn = new JButton ("Sn");
	Sn.setBounds(699, 312, 53, 53);
	Sn.setBackground(new Color(200,255,250));
	add(Sn);	Sn.addActionListener(this);
	Pb = new JButton ("Pb");
	Pb.setBounds(699, 365, 53, 53);
	Pb.setBackground(new Color(200,255,250));
	add(Pb);	Pb.addActionListener(this);
	Fl = new JButton ("Fl");
	 Fl.setBounds(699, 418, 53, 53);
	Fl.setBackground(new Color(255,255,0));
	add(Fl);	Fl.addActionListener(this);
	N = new JButton ("N");
	N.setBounds(752, 153, 53, 53);
	N.setBackground(new Color(20,180,40));
	add(N);	N.addActionListener(this);
	P = new JButton ("P");
	P.setBounds(752, 206, 53, 53);
	 P.setBackground(new Color(20,180,40));
	 add(P);	P.addActionListener(this);
	As = new JButton ("As");
	 As.setBounds(752, 259, 53, 53);
	As.setBackground(new Color(0,236,0));
	add(As);	As.addActionListener(this);
	Sb = new JButton ("Sb");
	Sb.setBounds(752, 312, 53, 53);
	Sb.setBackground(new Color(0,236,0));
	add(Sb);	Sb.addActionListener(this);
	Bi = new JButton ("Bi");
	Bi.setBounds(752, 365, 53, 53);
	Bi.setBackground(new Color(200,255,250));
	add(Bi);	Bi.addActionListener(this);
	Mc = new JButton ("Up");
	Mc.setBounds(752, 418, 53, 53);
	Mc.setBackground(new Color(50,130,250));
	add(Mc);	Mc.addActionListener(this);
	O = new JButton ("O");
	O.setBounds(805, 153, 53, 53);
	O.setBackground(new Color(20,180,40));
	add(O);	O.addActionListener(this);
	O.addActionListener(this);
	S = new JButton ("S");
	S.setBounds(805, 206, 53, 53);
	 S.setBackground(new Color(20,180,40));
	add(S);	S.addActionListener(this);
	Se = new JButton ("Se");
	Se.setBounds(805, 259, 53, 53);
	Se.setBackground(new Color(20,180,40));
	add(Se);	Se.addActionListener(this);
	Te = new JButton ("Te");
	Te.setBounds(805, 312, 53, 53);
	Te.setBackground(new Color(0,236,0));
	add(Te);	Te.addActionListener(this);
	Po = new JButton ("Po");
	Po.setBounds(805, 365, 53, 53);
	Po.setBackground(new Color(200,255,250));
	add(Po);	Po.addActionListener(this);
	Lv = new JButton ("Lv");
	Lv.setBounds(805, 418, 53, 53);
	Lv.setBackground(new Color(50,130,250));
	 add(Lv);	Lv.addActionListener(this);
	F = new JButton ("F");
	F.setBounds(858, 153, 53, 53);
	F.setBackground(new Color(20,180,40));
	 add(F);	F.addActionListener(this);
	Cl = new JButton ("Cl");
	Cl.setBounds(858, 206, 53, 53);
 	Cl.setBackground(new Color(20,180,40));
	 add(Cl);	Cl.addActionListener(this);
	 Br = new JButton ("Br");
	Br.setBounds(858, 259, 53, 53);
	Br.setBackground(new Color(20,180,40));
	 add(Br);	Br.addActionListener(this);
	I = new JButton ("I");
	I.setBounds(858, 312, 53, 53);
	I.setBackground(new Color(20,180,40));
	add(I);	I.addActionListener(this);
	 At = new JButton ("At");
	At.setBounds(858, 365, 53, 53);
	At.setBackground(new Color(192,3,112));
	add(At);	At.addActionListener(this);
	Ts = new JButton ("Ts");
	Ts.setBounds(858, 418, 53, 53);
	Ts.setBackground(new Color(50,130,250));
	add(Ts);	Ts.addActionListener(this);
	 He = new JButton ("He");
	He.setBounds(911, 100, 53, 53);
	He.setBackground(new Color(0,255,255));
	add(He);	He.addActionListener(this);
	Ne = new JButton ("Ne");
	Ne.setBounds(911, 153, 53, 53);
	Ne.setBackground(new Color(0,255,255));
	add(Ne);	Ne.addActionListener(this);
	Ar = new JButton ("Ar");
	Ar.setBounds(911, 206, 53, 53);
	 Ar.setBackground(new Color(0,255,255));
	 add(Ar);	Ar.addActionListener(this);
	 Kr = new JButton ("Kr");
	 Kr.setBounds(911, 259, 53, 53);
	Kr.setBackground(new Color(0,255,255));
	 add(Kr);	Kr.addActionListener(this);
	 Xe = new JButton ("Xe");
	 Xe.setBounds(911, 312, 53, 53);
	 Xe.setBackground(new Color(0,255,255));
	add(Xe);	Xe.addActionListener(this);
	Rn = new JButton ("Rn");
	Rn.setBounds(911, 365, 53, 53);
	Rn.setBackground(new Color(0,255,255));
	add(Rn);	Rn.addActionListener(this);
	Og = new JButton ("Og");
	Og.setBounds(911, 418, 53, 53);
	Og.setBackground(new Color(50,130,250));
	add(Og);	Og.addActionListener(this);
	La = new JButton ("La");
	La.setBounds(169, 524, 53, 53);
	La.setBackground(new Color(255,60,60));
	 add(La);	La.addActionListener(this);
	Ce = new JButton ("Ce");
	 Ce.setBounds(222, 524, 53, 53);
	 Ce.setBackground(new Color(255,60,60));
	add(Ce);	Ce.addActionListener(this);
	Pr = new JButton ("Pr");
	 Pr.setBounds(275, 524, 53, 53);
	 Pr.setBackground(new Color(255,60,60));
  	add(Pr);	Pr.addActionListener(this);
	 Nd = new JButton ("Nd");
	 Nd.setBounds(328, 524, 53, 53);
	Nd.setBackground(new Color(255,60,60));
	add(Nd);	Nd.addActionListener(this);
	Pm = new JButton ("Pm");
	 Pm.setBounds(381, 524, 53, 53);
	Pm.setBackground(new Color(255,60,60));
 	add(Pm);	Pm.addActionListener(this);
	Sm = new JButton ("sm");
	Sm.setBounds(434, 524, 53, 53);
	Sm.setBackground(new Color(255,60,60));
	add(Sm);	Sm.addActionListener(this);
	Eu = new JButton ("Eu");
	Eu.setBounds(487, 524, 53, 53);
	Eu.setBackground(new Color(255,60,60));
	add(Eu);	Eu.addActionListener(this);
	Gd = new JButton ("Gd");
	 Gd.setBounds(540, 524, 53, 53);
	 Gd.setBackground(new Color(255,60,60));
	add(Gd);	Gd.addActionListener(this);
	Tb = new JButton ("Tb");
	Tb.setBounds(593, 524, 53, 53);
	Tb.setBackground(new Color(255,60,60));
	add(Tb);	Tb.addActionListener(this);
	Dy = new JButton ("Dy");
	Dy.setBounds(646, 524, 53, 53);
	Dy.setBackground(new Color(255,60,60));
 	 add(Dy);	Dy.addActionListener(this);
	Ho = new JButton ("Ho");
	Ho.setBounds(699, 524, 53, 53);
	Ho.setBackground(new Color(255,60,60));
	add(Ho);	Ho.addActionListener(this);
	Er = new JButton ("Er");
	Er.setBounds(752, 524, 53, 53);
	 Er.setBackground(new Color(255,60,60));
	 add(Er);	Er.addActionListener(this);
	Tm = new JButton ("TM");
 	Tm.setBounds(805, 524, 53, 53);
	 Tm.setBackground(new Color(255,60,60));
	add(Tm);	Tm.addActionListener(this);
	Yb = new JButton ("Yb");
	Yb.setBounds(858, 524, 53, 53);
	Yb.setBackground(new Color(255,60,60));
	 add(Yb);	Yb.addActionListener(this);
	Lu = new JButton ("Lu");
	Lu.setBounds(911, 524, 53, 53);
	Lu.setBackground(new Color(255,60,60));
	add(Lu);	Lu.addActionListener(this);
	Ac = new JButton ("Ac");
	Ac.setBounds(169, 577, 53, 53);
	 Ac.setBackground(new Color(255,60,200));
	 add(Ac);	Ac.addActionListener(this);
	Th = new JButton ("Th");
	Th.setBounds(222, 577, 53, 53);
	Th.setBackground(new Color(255,60,200));
	 add(Th);	Th.addActionListener(this);
	 Pa = new JButton ("Pa");
	Pa.setBounds(275, 577, 53, 53);
	Pa.setBackground(new Color(255,60,200));
	add(Pa);	Pa.addActionListener(this);
	U = new JButton ("U");
	U.setBounds(328, 577, 53, 53);
	U.setBackground(new Color(255,60,200));
	add(U);	U.addActionListener(this);
	Np = new JButton ("Np");
	 Np.setBounds(381, 577, 53, 53);
	Np.setBackground(new Color(255,60,200));
	add(Np);	Np.addActionListener(this);
	Pu = new JButton ("Pu");
	Pu.setBounds(434, 577, 53, 53);
	Pu.setBackground(new Color(255,60,200));
	add(Pu);	Pu.addActionListener(this);
	Am = new JButton ("Am");
	 Am.setBounds(487, 577, 53, 53);
	Am.setBackground(new Color(255,60,200));
	add(Am);	Am.addActionListener(this);
	Cm = new JButton ("Cm");
	Cm.setBounds(540, 577, 53, 53);
	Cm.setBackground(new Color(255,60,200));
	add(Cm);	Cm.addActionListener(this);
	Bk = new JButton ("Bk");
	Bk.setBounds(593, 577, 53, 53);
	Bk.setBackground(new Color(255,60,200));
	add(Bk);	Bk.addActionListener(this);
	 Cf = new JButton ("Cf");
	Cf.setBounds(646, 577, 53, 53);
	Cf.setBackground(new Color(255,60,200));
	add(Cf);	Cf.addActionListener(this);   
	   Es = new JButton ("Es");
	Es.setBounds(699, 577, 53, 53);
	Es.setBackground(new Color(255,60,200));
	 add(Es);	Es.addActionListener(this);
	Fm = new JButton ("Fm");
	Fm.setBounds(752, 577, 53, 53);
	Fm.setBackground(new Color(255,60,200));
	add(Fm);	Fm.addActionListener(this);
	Md = new JButton ("Md");
	  Md.setBounds(805, 577, 53, 53);
	Md.setBackground(new Color(255,60,200));
	add(Md);	Md.addActionListener(this);
	 No = new JButton ("No");
	No.setBounds(858, 577, 53, 53);
	No.setBackground(new Color(255,60,200));
	add(No);	No.addActionListener(this);
	Lr = new JButton ("Lr");
	Lr.setBounds(911, 577, 53, 53);
 	 Lr.setBackground(new Color(255,60,200));
  	add(Lr);	Lr.addActionListener(this);
 }

 public void actionPerformed(ActionEvent evento){
	Container f = this.getContentPane();
	if(evento.getSource()== H){
		JOptionPane.showMessageDialog(null, " Numbre: Hidrogeno \n Numero atomico: 1 \n Peso Atomico: 1.00794 \n Simbolo: H" );}
	if(evento.getSource()== Li){
		JOptionPane.showMessageDialog(null, " Numbre: Litio \n Numero atomico: 3 \n Peso Atomico: 6.941 \n Simbolo: Li" );}
	if(evento.getSource()== Na){
		JOptionPane.showMessageDialog(null, " Numbre: Sodio \n Numero atomico: 11 \n Peso Atomico: 22.989770 \n Simbolo: Na" );}
	if(evento.getSource()== K){
		JOptionPane.showMessageDialog(null, " Numbre: Potasio \n Numero atomico: 19 \n Peso Atomico: 39.0983 \n Simbolo: k" );}
	if(evento.getSource()== Rb){
		JOptionPane.showMessageDialog(null, " Numbre: Rubidio \n Numero atomico: 37 \n Peso Atomico: 85.4678 \n Simbolo: Rb" );}
	if(evento.getSource()== Cs){
		JOptionPane.showMessageDialog(null, " Numbre: Cesio \n Numero atomico: 55 \n Peso Atomico: 132.90545 \n Simbolo: Cs" );}
	if(evento.getSource()== Fr){
		JOptionPane.showMessageDialog(null, " Numbre: Francio \n Numero atomico: 87 \n Peso Atomico: 223.02 \n Simbolo: Fr" ); }
	if(evento.getSource()== Be){
		JOptionPane.showMessageDialog(null, " Nombre: Berilio \n Numero atomico: 4 \n Peso Atomico: 9.012182 \n Simbolo: Be" );  }
	if(evento.getSource()== Mg){
		JOptionPane.showMessageDialog(null, " Nombre: Magnesio \n Numero atomico: 12 \n Peso Atomico: 24.3050 \n Simbolo: Mg" ); }
	if(evento.getSource()== Ca){
		JOptionPane.showMessageDialog(null, " Nombre: Calcio \n Numero atomico: 20 \n Peso Atomico: 40.078 \n Simbolo: Ca" ); }
	if(evento.getSource()== Sr){
		JOptionPane.showMessageDialog(null, " Nombre: Estroncio \n Numero atomico: 38 \n Peso Atomico: 87.62 \n Simbolo: Sr" );   }
	if(evento.getSource()== Ba){
		JOptionPane.showMessageDialog(null, " Nombre: Bario \n Numero atomico: 56 \n Peso Atomico: 137.327 \n Simbolo: Ba" ); }
	if(evento.getSource()== Ra){
		JOptionPane.showMessageDialog(null, " Nombre: Radio \n Numero atomico: 88 \n Peso Atomico: 226.0254 \n Simbolo: Ra" ); }
	if(evento.getSource()== Sc){
		JOptionPane.showMessageDialog(null, " Nombre: Escandio \n Numero atomico: 21 \n Peso Atomico: 44.955910 \n Simbolo: Sc" ); }
	if(evento.getSource()== Y){
		JOptionPane.showMessageDialog(null, " Nombre: Itrio \n Numero atomico: 39 \n Peso Atomico: 88.90585 \n Simbolo: Y" ); }
	if(evento.getSource()== AcLr){
		JOptionPane.showMessageDialog(null, "Serie Del Actino" );}
	if(evento.getSource()== LaLu){
		JOptionPane.showMessageDialog(null, "Serie Del Lantanidos" );}
	if(evento.getSource()== T){
		JOptionPane.showMessageDialog(null, " Nombre: Titanio \n Numero atomico: 22 \n Peso Atomico: 47.867 \n Simbolo: Ti" );  }
	if(evento.getSource()== Zr){
		JOptionPane.showMessageDialog(null, " Nombre: Circonio \n Numero atomico: 40 \n Peso Atomico: 91.224 \n Simbolo: Zr" ); }
	if(evento.getSource()== Hf){
		JOptionPane.showMessageDialog(null, " Nombre: Hafnio \n Numero atomico: 72 \n Peso Atomico: 178.49 \n Simbolo: Hf" ); }
	if(evento.getSource()== Rf){
		JOptionPane.showMessageDialog(null, " Nombre: Rutherfordio \n Numero atomico: 104 \n Peso Atomico: 621.1089 \n Simbolo: Rf" ); }
	if(evento.getSource()== V ){
		JOptionPane.showMessageDialog(null, " Nombre: Vanadio \n Numero atomico: 23 \n Peso Atomico: 50.9415 \n Simbolo: V " ); }
	if(evento.getSource()== Nb){
		JOptionPane.showMessageDialog(null, " Nombre: Niobio \n Numero atomico: 41 \n Peso Atomico: 92.90638 \n Simbolo: Nb" ); }
	if(evento.getSource()== Ta){
		JOptionPane.showMessageDialog(null, " Nombre: Tantalo \n Numero atomico: 73 \n Peso Atomico: 180.9474 \n Simbolo: Ta" ); }
	if(evento.getSource()== Db){
		JOptionPane.showMessageDialog(null, " Nombre: Dubnio \n Numero atomico: 105 \n Peso Atomico: 262.1144 \n Simbolo: Db" );}
	if(evento.getSource()== Cr ){
		JOptionPane.showMessageDialog(null, " Nombre: Cromo \n Numero atomico: 24 \n Peso Atomico: 51.9961 \n Simbolo: Cr" ); }
	if(evento.getSource()== Mo ){
		JOptionPane.showMessageDialog(null, " Nombre: Molibdeno \n Numero atomico: 42 \n Peso Atomico: 95.94 \n Simbolo: Mo" ); }
	if(evento.getSource()== W ){
		JOptionPane.showMessageDialog(null, " Nombre: Tugsteno \n Numero atomico: 74 \n Peso Atomico: 183.84 \n Simbolo: W" ); }
	if(evento.getSource()== Sg ){
		JOptionPane.showMessageDialog(null, " Nombre: Seaborgio \n Numero atomico: 106 \n Peso Atomico: 263.1186 \n Simbolo: Sg" ); }
	if(evento.getSource()== Mn ){
		JOptionPane.showMessageDialog(null, " Nombre: Manganeso \n Numero atomico: 25 \n Peso Atomico: 54.938049 \n Simbolo: Mn" ); }
	if(evento.getSource()== Tc ){
		JOptionPane.showMessageDialog(null, " Nombre: Tecnesio \n Numero atomico: 43 \n Peso Atomico: 98.9063 \n Simbolo: Tc" ); }
	if(evento.getSource()== Re ){
		JOptionPane.showMessageDialog(null, " Nombre: Renio \n Numero atomico: 75 \n Peso Atomico: 186.207 \n Simbolo: Re" ); }
	if(evento.getSource()== Bh ){
		JOptionPane.showMessageDialog(null, " Nombre: Bohrio \n Numero atomico: 107 \n Peso Atomico: 264.12 \n Simbolo: Bh" ); }
	if(evento.getSource()== Fe ){
		JOptionPane.showMessageDialog(null, " Nombre: Hierro \n Numero atomico: 26 \n Peso Atomico: 55.845 \n Simbolo: Fe" ); }
	if(evento.getSource()== Ru ){
		JOptionPane.showMessageDialog(null, " Nombre: Rutenio \n Numero atomico: 44 \n Peso Atomico: 101.07 \n Simbolo: Ru" ); }
	if(evento.getSource()== Os ){
		JOptionPane.showMessageDialog(null, " Nombre: Osmio \n Numero atomico: 76 \n Peso Atomico: 190.23 \n Simbolo: Os" ); }
	if(evento.getSource()== Hs ){
		JOptionPane.showMessageDialog(null, " Nombre: Hassnio \n Numero atomico: 108 \n Peso Atomico: 265.13 \n Simbolo: Hs" ); }
	if(evento.getSource()== Co ){
		JOptionPane.showMessageDialog(null, " Nombre: Cobalto \n Numero atomico: 27 \n Peso Atomico: 58.933200 \n Simbolo: Co" ); }
	if(evento.getSource()== Rh ){
		JOptionPane.showMessageDialog(null, " Nombre: Rodio \n Numero atomico: 45 \n Peso Atomico: 102.90550 \n Simbolo: Rh" ); }
	if(evento.getSource()== Ir ){
		JOptionPane.showMessageDialog(null, " Nombre: Iridio \n Numero atomico: 77 \n Peso Atomico: 192.217 \n Simbolo: Ir" ); }
	if(evento.getSource()== Mt ){
		JOptionPane.showMessageDialog(null, " Nombre: Meitnerio \n Numero atomico: 109 \n Peso Atomico: 268 \n Simbolo: Mt" ); }
	if(evento.getSource()== Ni ){
		JOptionPane.showMessageDialog(null, " Nombre: Niquel \n Numero atomico: 28 \n Peso Atomico: 58.6934 \n Simbolo: Ni" ); }
	if(evento.getSource()== Pd ){
		JOptionPane.showMessageDialog(null, " Nombre: Paladio \n Numero atomico: 46 \n Peso Atomico: 106.42 \n Simbolo: Pd" ); }
	if(evento.getSource()== Pt ){
		JOptionPane.showMessageDialog(null, " Nombre: Platino \n Numero atomico: 78 \n Peso Atomico: 195.078 \n Simbolo: Pt" ); }
	if(evento.getSource()== Ds ){
		JOptionPane.showMessageDialog(null, " Nombre: Darmstadtio \n Numero atomico: 110 \n Peso Atomico: 281 \n Simbolo: Ds" ); }
	if(evento.getSource()== Cu ){
		JOptionPane.showMessageDialog(null, " Nombre: Cobre \n Numero atomico: 29 \n Peso Atomico: 63.546 \n Simbolo: Cu" ); }
	if(evento.getSource()== Ag ){
		JOptionPane.showMessageDialog(null, " Nombre: Plata \n Numero atomico: 47 \n Peso Atomico: 107.8682 \n Simbolo: Ag" ); }
	if(evento.getSource()== Au ){
		JOptionPane.showMessageDialog(null, " Nombre: Oro \n Numero atomico: 79 \n Peso Atomico: 196.96655 \n Simbolo: Au" ); }
	if(evento.getSource()== Rg ){
		JOptionPane.showMessageDialog(null, " Nombre: Rcentgenio \n Numero atomico: 111 \n Peso Atomico: 280 \n Simbolo: Rg" ); }
	if(evento.getSource()== Zn ){
		JOptionPane.showMessageDialog(null, " Nombre: Cinc \n Numero atomico: 30 \n Peso Atomico: 65.39 \n Simbolo: Zn" ); }
	if(evento.getSource()== Cd ){
		JOptionPane.showMessageDialog(null, " Nombre: Cadmio \n Numero atomico: 48 \n Peso Atomico: 112.411 \n Simbolo: Cd" ); }
	if(evento.getSource()== Hg ){
		JOptionPane.showMessageDialog(null, " Nombre: Mercurio \n Numero atomico: 80 \n Peso Atomico: 200.59 \n Simbolo: Hg" ); }
	if(evento.getSource()== Cn ){
		JOptionPane.showMessageDialog(null, " Nombre: Copernicio \n Numero atomico: 112 \n Peso Atomico: 285 \n Simbolo: Cn"); }
	if(evento.getSource()== B ){
		JOptionPane.showMessageDialog(null, " Nombre: Boro \n Numero atomico: 5 \n Peso Atomico: 10.811 \n Simbolo: B" ); }
	if(evento.getSource()== Al ){
		JOptionPane.showMessageDialog(null, " Nombre: Alumino \n Numero atomico: 13 \n Peso Atomico: 26.981538 \n Simbolo: Al" ); }
	if(evento.getSource()== Ga ){
		JOptionPane.showMessageDialog(null, " Nombre: Galio \n Numero atomico: 31 \n Peso Atomico: 69.723 \n Simbolo: Ga" );  }
	if(evento.getSource()== In ){
		JOptionPane.showMessageDialog(null, " Nombre: Indio \n Numero atomico: 49 \n Peso Atomico: 114.818 \n Simbolo: In" ); }
	if(evento.getSource()== Tl ){
		JOptionPane.showMessageDialog(null, " Nombre: Talio \n Numero atomico: 81 \n Peso Atomico: 204.3833 \n Simbolo: Tl" );   }
	if(evento.getSource()== Nh ){
		JOptionPane.showMessageDialog(null, " Nombre: Nihonium \n Numero atomico: 113 \n Peso Atomico: ... \n Simbolo: Nh" ); }
	if(evento.getSource()== C ){
		JOptionPane.showMessageDialog(null, " Nombre: Carbono \n Numero atomico: 6 \n Peso Atomico: 12.0107 \n Simbolo: C" ); }
	if(evento.getSource()== Si ){
		JOptionPane.showMessageDialog(null," Nombre: Silicio \n Numero atomico: 14 \n Peso Atomico: 28.0855 \n Simbolo: Si" ); }
	if(evento.getSource()== Ge ){
		JOptionPane.showMessageDialog(null, " Nombre: Germanio \n Numero atomico: 32 \n Peso Atomico:72.61 \n Simbolo: Ge" ); }
	if(evento.getSource()== Sn ){
		JOptionPane.showMessageDialog(null, " Nombre: Estaño \n Numero atomico: 50 \n Peso Atomico: 118.710 \n Simbolo: Sn" ); }
	if(evento.getSource()== Pb ){
		JOptionPane.showMessageDialog(null, " Nombre: Plomo \n Numero atomico: 82 \n Peso Atomico: 207.2 \n Simbolo: Pb" ); }
	if(evento.getSource()== Fl ){
		JOptionPane.showMessageDialog(null, " Nombre: Flerovio \n Numero atomico: 114 \n Peso Atomico: 285 \n Simbolo: Fl"); }
	if(evento.getSource()== N ){
		JOptionPane.showMessageDialog(null, " Nombre: Nitrogeno \n Numero atomico: 7 \n Peso Atomico: 14.00674 \n Simbolo: N" ); }
	if(evento.getSource()== P ){
		JOptionPane.showMessageDialog(null, " Nombre: Fosforo \n Numero atomico: 15 \n Peso Atomico: 30.973761 \n Simbolo: P" ); }
	if(evento.getSource()== As ){
		JOptionPane.showMessageDialog(null, " Nombre: Arsenico \n Numero atomico: 33 \n Peso Atomico: 74.92160 \n Simbolo: As" ); }
	if(evento.getSource()== Sb ){
		JOptionPane.showMessageDialog(null, " Nombre: Antimonio \n Numero atomico: 51 \n Peso Atomico: 121.760 \n Simbolo: Sb" ); }
	if(evento.getSource()== Bi ){
		JOptionPane.showMessageDialog(null, " Nombre: Bismuto \n Numero atomico: 83 \n Peso Atomico: 208.98038 \n Simbolo: Bi" ); }
	if(evento.getSource()== Mc ){
		JOptionPane.showMessageDialog(null, " Nombre: Moscovium \n Numero atomico: 115 \n Peso Atomico: ... \n Simbolo: Mc" ); }
	if(evento.getSource()== O ){
		JOptionPane.showMessageDialog(null, " Nombre: Oxigeno \n Numero atomico: 8 \n Peso Atomico: 15.9994 \n Simbolo: O" );   }
	if(evento.getSource()== S ){
		JOptionPane.showMessageDialog(null, " Nombre: Azufre \n Numero atomico: 16 \n Peso Atomico: 32.066 \n Simbolo: S" ); }
	if(evento.getSource()== Se ){
		JOptionPane.showMessageDialog(null, " Nombre: Selenio \n Numero atomico: 34 \n Peso Atomico: 78.96 \n Simbolo: Se" ); }
	if(evento.getSource()== Te ){
		JOptionPane.showMessageDialog(null, " Nombre: Telurio \n Numero atomico: 52 \n Peso Atomico: 127.60 \n Simbolo: Te" ); } 
	if(evento.getSource()== Po ){
		JOptionPane.showMessageDialog(null, " Nombre: Polonio \n Numero atomico: 84 \n Peso Atomico: 208.9824 \n Simbolo: Po" ); }
	if(evento.getSource()== Lv ){
		JOptionPane.showMessageDialog(null, " Nombre: Livermorio \n Numero atomico: 116 \n Peso Atomico: 289 \n Simbolo: Lv " ); }
	if(evento.getSource()== F ){
		JOptionPane.showMessageDialog(null, " Nombre: Fluor \n Numero atomico: 9 \n Peso Atomico: 18.9984032 \n Simbolo: F" ); }
	if(evento.getSource()== Cl ){
		JOptionPane.showMessageDialog(null, " Nombre: Cloro \n Numero atomico: 17 \n Peso Atomico: 35.4527 \n Simbolo: Cl" ); }
	if(evento.getSource()== Br ){
		JOptionPane.showMessageDialog(null, " Nombre: Bromo \n Numero atomico: 35 \n Peso Atomico: 79.904 \n Simbolo: Br" ); }
	if(evento.getSource()== I ){
		JOptionPane.showMessageDialog(null, " Nombre: Yodo \n Numero atomico: 53 \n Peso Atomico: 126.90447 \n Simbolo: I" ); }
	if(evento.getSource()== At ){
		JOptionPane.showMessageDialog(null, " Nombre: Astato \n Numero atomico: 85 \n Peso Atomico: 209.9871 \n Simbolo: At" ); }
	if(evento.getSource()== Ts ){
		JOptionPane.showMessageDialog(null, " Nombre: Tennessine \n Numero atomico: 117 \n Peso Atomico: ... \n Simbolo: Ts " ); }
	if(evento.getSource()== He ){
		JOptionPane.showMessageDialog(null, " Nombre: Helio \n Numero atomico: 2 \n Peso Atomico: 4.002602 \n Simbolo: He" ); }
	if(evento.getSource()== Ne ){
		JOptionPane.showMessageDialog(null, " Nombre: Neon \n Numero atomico: 10 \n Peso Atomico: 20.1797 \n Simbolo: Ne" );   }
	if(evento.getSource()== Ar ){
		JOptionPane.showMessageDialog(null, " Nombre: Argon \n Numero atomico: 18 \n Peso Atomico: 39.948 \n Simbolo: Ar" ); }
	if(evento.getSource()== Kr ){
		JOptionPane.showMessageDialog(null, " Nombre: Cripton \n Numero atomico: 36 \n Peso Atomico: 83.80 \n Simbolo: Kr" ); }
	if(evento.getSource()== Xe ){
		JOptionPane.showMessageDialog(null, " Nombre: Xenon \n Numero atomico: 54 \n Peso Atomico: 131.29 \n Simbolo: Xe" ); }
	if(evento.getSource()== Rn ){
		JOptionPane.showMessageDialog(null, " Nombre: Radon \n Numero atomico: 86 \n Peso Atomico: 222.0176 \n Simbolo: Rn" ); }
	if(evento.getSource()== Og ){
		JOptionPane.showMessageDialog(null, " Nombre: Oganesson \n Numero atomico: 118 \n Peso Atomico: 293 \n Simbolo: Og" ); }
	if(evento.getSource()== La ){
		JOptionPane.showMessageDialog(null, " Nombre: Lantano \n Numero atomico: 57 \n Peso Atomico: 138.9055 \n Simbolo: La" );   }
	if(evento.getSource()== Ce ){
		JOptionPane.showMessageDialog(null, " Nombre: Cerio \n Numero atomico: 58 \n Peso Atomico: 140.116 \n Simbolo: Ce" );   }
	if(evento.getSource()== Pr ){
		JOptionPane.showMessageDialog(null, " Nombre: Praseodimio \n Numero atomico: 59 \n Peso Atomico: 140.90765 \n Simbolo: Pr" ); }
	if(evento.getSource()== Nd ){
		JOptionPane.showMessageDialog(null, " Nombre: Neodimio \n Numero atomico: 60 \n Peso Atomico: 144.24 \n Simbolo: Nd" ); }
	if(evento.getSource()== Pm ){
		JOptionPane.showMessageDialog(null, " Nombre: Prometio \n Numero atomico: 61 \n Peso Atomico: 144.9127 \n Simbolo: Pm" ); }
	if(evento.getSource()== Sm ){
		JOptionPane.showMessageDialog(null, " Nombre: Samario \n Numero atomico: 62 \n Peso Atomico: 150.36 \n Simbolo: Sm" ); }
	if(evento.getSource()== Eu ){
		JOptionPane.showMessageDialog(null, " Nombre: Europio \n Numero atomico: 63 \n Peso Atomico: 151.965 \n Simbolo: Eu" ); }
	if(evento.getSource()== Gd ){
		JOptionPane.showMessageDialog(null, " Nombre: Gadolinio \n Numero atomico: 64 \n Peso Atomico: 157.25 \n Simbolo: Gd" );   }
	if(evento.getSource()== Tb ){
		JOptionPane.showMessageDialog(null, " Nombre: Terbio \n Numero atomico: 65 \n Peso Atomico: 158.92534 \n Simbolo: Tb " ); }
	if(evento.getSource()== Dy ){
		JOptionPane.showMessageDialog(null, " Nombre: Disprosio \n Numero atomico: 66 \n Peso Atomico: 162.50 \n Simbolo: Dy" ); }
	if(evento.getSource()== Ho ){
		JOptionPane.showMessageDialog(null, " Nombre: Holmio \n Numero atomico: 67 \n Peso Atomico: 164.93032 \n Simbolo: Ho" ); }
	if(evento.getSource()== Er ){
		JOptionPane.showMessageDialog(null, " Nombre: Erbio  \n Numero atomico: 68 \n Peso Atomico: 167.26 \n Simbolo: Er" ); }
	if(evento.getSource()== Tm ){
		JOptionPane.showMessageDialog(null, " Nombre: Tulio \n Numero atomico: 69 \n Peso Atomico: 168.93421 \n Simbolo: Tm" ); }
	if(evento.getSource()== Yb ){
		JOptionPane.showMessageDialog(null, " Nombre: Iterbio \n Numero atomico: 70 \n Peso Atomico: 173.04 \n Simbolo: Yb" ); }
	if(evento.getSource()== Lu ){
		JOptionPane.showMessageDialog(null, " Nombre: Lutecio \n Numero atomico: 71 \n Peso Atomico: 174.967 \n Simbolo: Lu" );  }
	if(evento.getSource()== Ac ){
		JOptionPane.showMessageDialog(null, " Nombre: Actinio \n Numero atomico: 89 \n Peso Atomico: 227.0277 \n Simbolo: Ac" ); }
	if(evento.getSource()== Th ){
		JOptionPane.showMessageDialog(null, " Nombre: Torio \n Numero atomico: 90 \n Peso Atomico: 232.0381 \n Simbolo: Th" ); }
	if(evento.getSource()== Pa ){
		JOptionPane.showMessageDialog(null, " Nombre: Protactinio \n Numero atomico: 91 \n Peso Atomico: 231.0388 \n Simbolo: Pa" );  }
	if(evento.getSource()== U ){
		JOptionPane.showMessageDialog(null, " Nombre: Uranio \n Numero atomico: 92 \n Peso Atomico: 238.0289 \n Simbolo: U" ); }
	if(evento.getSource()== Np ){
		JOptionPane.showMessageDialog(null, " Nombre: Neptunio \n Numero atomico: 93 \n Peso Atomico: 237.0482 \n Simbolo: Np" ); }
	if(evento.getSource()== Pu ){
		JOptionPane.showMessageDialog(null, " Nombre: Plutonio \n Numero atomico: 94 \n Peso Atomico: 244.0642 \n Simbolo: Pu" ); }
	if(evento.getSource()== Am ){
		JOptionPane.showMessageDialog(null, " Nombre: Amaricio \n Numero atomico: 95 \n Peso Atomico: 243.0614 \n Simbolo: Am" ); }
	if(evento.getSource()== Cm ){
		JOptionPane.showMessageDialog(null, " Nombre: Curio \n Numero atomico: 96 \n Peso Atomico: 247.0703 \n Simbolo: Cm" ); }
	if(evento.getSource()== Bk ){
		JOptionPane.showMessageDialog(null, " Nombre: Berkelio \n Numero atomico: 97 \n Peso Atomico: 247.0703 \n Simbolo: Bk" ); }
	if(evento.getSource()== Cf ){
		JOptionPane.showMessageDialog(null, " Nombre: Californio \n Numero atomico: 98 \n Peso Atomico: 251.0796 \n Simbolo: Cf" ); }
	if(evento.getSource()== Es ){
		JOptionPane.showMessageDialog(null, " Nombre: Einstenio \n Numero atomico: 99 \n Peso Atomico: 252.0830 \n Simbolo: Es" ); }
	if(evento.getSource()== Fm ){
		JOptionPane.showMessageDialog(null, " Nombre: Fermio \n Numero atomico: 100 \n Peso Atomico: 257.0951 \n Simbolo: Fm" ); }
	 if(evento.getSource()== Md ){
		JOptionPane.showMessageDialog(null, " Nombre: Mendelevio \n Numero atomico: 101 \n Peso Atomico: 258.0984 \n Simbolo: Md" ); }
	if(evento.getSource()== No ){
		JOptionPane.showMessageDialog(null, " Nombre: Nobelio \n Numero atomico: 102 \n Peso Atomico: 259.1011 \n Simbolo: No" ); }
	if(evento.getSource()== Lr ){
		JOptionPane.showMessageDialog(null, " Nombre: Laurencio \n Numero atomico: 103 \n Peso Atomico: 262.110 \n Simbolo: Lr" ); }
 }

 public static void main(String[] args) {
	 TablaP ventana = new TablaP();

	 ventana.setBounds(150,10,1000,700);
	 ventana.setVisible(true);
	 ventana.setResizable(false);
	 ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
}
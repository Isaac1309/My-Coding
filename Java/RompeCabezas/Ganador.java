import java.io.*;
public class Ganador implements Serializable{
	private String nom;
	private int tiempo;

	public Ganador(String n, int t){
	nom = n;
	tiempo = t;
}
public String getNom(){
	return nom;
}
public int getTime(){
	return tiempo;
}
public void setNom(String nvo){
	nom = nvo;
}
public void setTiempo(int nt){
	tiempo = nt;
}

}
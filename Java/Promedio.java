public class Promedio{
	public static void main(String arg[]){
	float suma=0; int n=arg.length;
		for(int i=0;i<arg.length;i++)
		try{
		suma+=Float.parseFloat(arg[i]);
		}catch(NumberFormatException ex){
			System.out.println("Entrada invalida. \nSolo digitos y punto decimal");
			n--;
		}
		System.out.print("Promedio="+suma/n);
	}
}
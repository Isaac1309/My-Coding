import java.util.Scanner;

public class Calificaciones{
  private float cal[];
  int para;
  public Calificaciones(int s){
       cal=new float[s];
	para=-1;
   }
  public void llenar(Scanner ent){
      System.out.println("Introduce los valores");
  for(int i=0; i<cal.length; i++)
   cal[i]=ent.nextFloat();
   para=cal.length-1;
}
public void mostrarTodo(){
for(int i=0;i<para; i++)
    System.out.println(""+cal[i]);
	
}
public int buscarValor(float v){
   int i=0;
   while(i<=para&&cal[i]!=v);
     i++;
    if(i>=para)
    return -1;
  else return i;
  }
public boolean eliminar(float ve){
	int p=buscarValor(ve);
	System.out.println("Posicion: "+p);
	if(p>-1){
	 for(; p<para; p++)
	 cal[p]=cal[p+1];
	 para--;
	 return true;
	 }
	return false;
}
public static void main(String args[]){
     char opc;
     float v;
     Scanner ent=new Scanner(System.in);
      System.out.println("\nDimension para el arreglo:");
	System.out.println("\n(solo meter un numero)\n");
        Calificaciones c=new Calificaciones(ent.nextInt());
do{
	System.out.println("a)Llenar\nb)Mostrar todo\nc)Buscar valor\nd)Eliminar\ne)Salir");
       opc=(ent.next()).charAt(0);
      opc=Character.toLowerCase(opc);
      switch(opc){
         case 'a': c.llenar(ent);break;
         case 'b': c.mostrarTodo();break;
         case 'c': System.out.println("Valor a buscar:");
	       v=ent.nextFloat();
	       System.out.println("Se encuentra en la celda "+ c.buscarValor(v));
	       break;
	case 'd': System.out.println("Valor a eliminar");
		v=ent.nextFloat();
		if(c.eliminar(v))
		System.out.println("Eliminado");
		else System.out.println("No se encuentra el valor");
		break;
    }
  }while(opc!='e');
}
}
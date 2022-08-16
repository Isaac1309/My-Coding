import java.util.Scanner;

public class Calificacion{
  private float cal[];
  public Calificacion(int s){
       cal=new float[s];
   }
  public void llenar(Scanner ent){
      System.out.println("Introduce los valores");
  for(int i=0; i<cal.length; i++)
   cal[i]=ent.nextFloat();
}
public void mostrarTodo(){

for(float i : cal)
    System.out.println(i);
}

public int buscarValor(float v){
   int i=0;
   while(i<cal.length && cal[i]!=v);
     i++;
    if(i==cal.length)
    return -1;
  else return i;
  }
public boolean eliminar(){
    return false;
}
public static void main(String args[]){
     char opc;
     float v;
     Scanner ent=new Scanner(System.in);
      System.out.println("Dimension para el arreglo:");
        Calificacion c=new Calificacion(ent.nextInt());
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

    }
  }while(opc!='e');
}
}
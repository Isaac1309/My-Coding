import java.io.IOException; 
import java.util.Timer; 
import java.util.TimerTask; 
import java.awt.event.*; 
import java.awt.*;  

public class Cronometro extends Panel{  
 
 Timer timer = new Timer(); //administra los tiempo de repeticion 
	public int hrs,min,seg;   
	public boolean parar,first;     
  TextField tf;

 public Cronometro(){         
	tf=new TextField("0:0:0");                  
	tf.setEditable(false);         
             
	add(tf,BorderLayout.NORTH);         
	     
          
	first=true;         
	parar=false;           
 }	
 // clase interna en la que se indican las tareas a ejecutar por el timer  
	class MiTarea extends TimerTask {   
		public void run() {                     
			if(!parar){   
				seg++;                         
			if(seg%60==0){                            
			min+=seg/60;                            
			seg=seg%60;                            
			if(min%60==0){                               
			hrs+=min/60;                               
			min=min%60;                            
			}                         
 		     }      
		tf.setText(" "+hrs+":"+min+":"+seg);                      
	}   
      }  
 }

 public void start() {
	if(first){
		try{
			parar= false;
			hrs=min=seg=0;
			first=false;
			// le asignamos una tarea al timer
			timer.schedule(new MiTarea(),0,1000);
		}catch(Exception e){
			System.out.println("Error en el Timer (start)");
		}
	}else{hrs=min=seg=0;}
 }

 public int stop(){
	try{
		parar=true;
	}catch(Exception e){
		System.out.println("Error en el Timer (stop)");
	}
	return hrs*60+min*60+seg;
 }       
}  
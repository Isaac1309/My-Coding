/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;
/**
 *
 * @author isaac
 */
public class Aplicacion {
    public static void main(String[] args) {
        CajeroAutomatico cajero=new CajeroAutomatico();
        Thread El_Pepe=new Thread(cajero, "El Pepe");
        Thread Sech=new Thread(cajero, "Ete Sech");
        Thread Cheems=new Thread(cajero, "Cheems");
        Thread Peter=new Thread(cajero, "Peter Parker");
        El_Pepe.start();
        Sech.start();
        Cheems.start();
        Peter.start();
    }
}

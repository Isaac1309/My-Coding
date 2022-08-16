package actividad.pkg5.fuerza.bruta;

import net.lingala.zip4j.exception.ZipException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Israel Parra Flores
 */
public class ZipSecuencial {
    public static void main(String[] args) {
        String un;
        for(int i=0;i<1000000;i++){
            if(i<10){
                un = "00000"+i;
            }else if(i<100){
                un = "0000"+i;
            }else if(i<1000){
                un = "000"+i;
            }else if(i<10000){
                un = "00"+i;
            }else if(i<100000){
                un = "0"+i;
            }else{
                un = ""+i;
            }
            //Ponga aquí un password
            Zipper zipper = new Zipper(un);
            try {
                zipper.unpack("contenido", "archivos_descomprimidos/");
                System.out.println("La contraseña es "+un);
                break;
            } catch (ZipException ex) {
                System.out.println("No fue posible des-comprimir con "+un);
            }
        }
    }
}

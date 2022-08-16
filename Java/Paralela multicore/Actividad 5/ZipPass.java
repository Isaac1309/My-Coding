/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad.pkg5.fuerza.bruta;

import java.util.concurrent.RecursiveAction;
import net.lingala.zip4j.exception.ZipException;

/**
 *
 * @author isaac
 */
public class ZipPass extends RecursiveAction{

    private static final long serialVersionUID = 1L;
    private String[] arreglo;
    private int prim;
    private int ult;

    public ZipPass(String[] arreglo, int first, int last){
        this.arreglo = arreglo;
        this.prim = first;
        this.ult = last;
    }

    @Override
    protected void compute() {
        if(ult-prim<100000){
            Descomprimir();
        }else{
            int medium = (prim+ult)/2;
            ZipPass a1 = new ZipPass(arreglo, prim, medium+1);
            ZipPass a2 = new ZipPass(arreglo, medium+1, ult);
            invokeAll(a1,a2);
        }
    }
    private void Descomprimir(){
        for(int i = prim; i<ult; i++){
            Zipper zipper = new Zipper(arreglo[i]);
            try {
                zipper.unpack("contenido", "archivos_descomprimidos/");
                System.out.println("La contraseña es "+arreglo[i]);
                System.exit(0);
            } catch (ZipException ex) {
                System.out.println("No fue posible des-comprimir con "+arreglo[i]);
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrón.fork.join;

import java.util.concurrent.RecursiveAction;

/**
 *
 * @author isaac
 */
public class Remplasar extends RecursiveAction{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int[] numprim;
    private int prim;
    private int ult;

    public Remplasar(int[] numprim, int first, int last){
        this. numprim = numprim;
        this.prim = first;
        this.ult = last;
    }

    @Override
    protected void compute() {
        if(ult-prim<10){
            Replace();
        }else{
            int medium = (prim+ult)/2;
            Remplasar a1 = new Remplasar(numprim, prim, medium+1);
            Remplasar a2 = new Remplasar(numprim, medium+1, ult);
            invokeAll(a1,a2);
        }
    }
    private void Replace(){
        boolean primo = false;
        for(int i = prim;i<ult;i++){
            primo=true;
            for(int j =2;j<=numprim[i]/2;j++){
                if(numprim[i]%j==0){
                    primo = false;
                    break;
                }
            }
            if(primo){
                numprim[i] = -1;
                
            }
        }
    }
}

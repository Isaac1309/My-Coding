/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrón.fork.join;

import java.util.concurrent.RecursiveTask;

/**
 *
 * @author isaac
 */
public class Contar extends RecursiveTask <Integer>{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int[] numprim;
    private int prim;
    private int ult;

    public Contar(int[] numprim, int prim, int ult){
        this. numprim = numprim;
        this.prim = prim;
        this.ult = ult;
    }

    @Override
    protected Integer compute() {
        int addition =0;
        if(ult-prim<10){
            addition  = agrega();
        }else{
            int medium = (prim+ult)/2;
            Contar a1 = new Contar(numprim, prim, medium+1);
            Contar a2 = new Contar(numprim, medium+1, ult);
            invokeAll(a1,a2);
            try{
            addition+=a1.get();
            addition+=a2.get();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return addition;
    }
    private int agrega(){
        int contar =0;
        boolean primo = false;
        for(int i = prim;i<ult;i++){
            primo=true;
            for(int j=2;j<=numprim[i]/2;j++){
                if(numprim[i]%j==0){
                    primo = false;
                    break;
                }
            }
            if(primo){
                ++contar;
            }
        }
        return contar;
    }
}

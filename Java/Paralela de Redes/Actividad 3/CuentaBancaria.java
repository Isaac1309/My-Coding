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
public class CuentaBancaria {
    private int saldoActual=50;
    public int getSaldoActual(){
        return saldoActual;
    }
    public void retiroDeCuenta(int valorRetiro){
        saldoActual-=valorRetiro;
    }
    public void depositoACuenta(int valorDeposito){
        saldoActual+=valorDeposito;
    }
}

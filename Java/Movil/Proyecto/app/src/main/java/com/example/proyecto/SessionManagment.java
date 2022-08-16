package com.example.proyecto;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManagment {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String SHARED_PREF_NAME = "session";
    String SESSION_KEY = "session_user";

    public SessionManagment(Context context){
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.apply();
    }
    public void setSaldo(int saldo){
        editor.putString("SALDO", String.valueOf(saldo)).commit();
    }
    public void saveSession(Cuentas cuenta){
        //guarda cuenta
        int id = cuenta.getId();

        editor.putInt(SESSION_KEY,id).commit();
        editor.putInt("ID",cuenta.getId()).commit();
        editor.putInt("TIPO",cuenta.getTipo()).commit();
        editor.putString("NOMBRE",cuenta.getNombre()).commit();
        editor.putString("SALDO",cuenta.getSaldo()).commit();
    }

    public int getID(){
        return sharedPreferences.getInt("ID", 0);
    }

    public String getNOMBRE(){
        return sharedPreferences.getString("NOMBRE","");
    }

    public int getTIPO(){
        return sharedPreferences.getInt("TIPO", 5);
    }

    public String getSALDO(){
        return sharedPreferences.getString("SALDO","");
    }

    public void removeSession(){
        editor.putInt(SESSION_KEY,-1).commit();
        editor.putString("NOMBRE","").commit();
        editor.putInt("TIPO",-1).commit();
        editor.putString("SALDO","").commit();
        editor.putInt("ID",-1).commit();
    }
}

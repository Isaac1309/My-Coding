package com.example.proyecto.ui.Transaccion;

import android.Manifest;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.proyecto.Cuentas;
import com.example.proyecto.MainActivity;
import com.example.proyecto.R;
import com.example.proyecto.SQLiteOpen;
import com.example.proyecto.SessionManagment;
import com.google.android.gms.maps.GoogleMap;

import java.util.ArrayList;
import java.util.Date;

public class TransaccionFragment extends Fragment {
    GoogleMap map;
    RadioButton radioButton;
    TextView categoria;
    TextView monto;
    TextView plazo;
    int buttonchecked;
    int RETIRO = 0;
    int cuentaActual = -1;
    ArrayList<Cuentas> listCuentas;

    LocationManager locationManager;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_transacciones, container, false);

        RadioGroup radg = v.findViewById(R.id.radioGTrans);
        Button btntrans = v.findViewById(R.id.btnTrans);
        categoria = v.findViewById(R.id.categoria);
        monto = v.findViewById(R.id.costo);
        plazo = v.findViewById(R.id.dia_o_Plazo);
        SessionManagment sessionManagment = new SessionManagment(getContext());
        cuentaActual = -1;
        cuentaActual = sessionManagment.getID();
        radg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton = v.findViewById(checkedId);
                if(radioButton.getText().equals("Transaccion Unica")){
                    buttonchecked = 0;
                }
                if(radioButton.getText().equals("Transaccion Recurrente")){
                    buttonchecked = 1;
                }
                if(radioButton.getText().equals("Transaccion a Plazos")){
                    buttonchecked = 2;
                }
            }
        });

        btntrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String scat = String.valueOf(categoria.getText());
                String smonto = String.valueOf(monto.getText());
                String splazo = String.valueOf(plazo.getText());
                if (cuentaActual!=-1) {


                    if (!scat.equals("") && !smonto.equals("")) {
                        if (buttonchecked == 2 && !splazo.equals("")) {
                            register(cuentaActual,RETIRO,buttonchecked, scat, smonto, splazo, "");
                            Toast.makeText(getActivity(), "transaccion registrada correctamente", Toast.LENGTH_SHORT).show();

                        } else if (buttonchecked == 1 && !splazo.equals("")) {
                            register(cuentaActual,RETIRO,buttonchecked, scat, smonto, "");
                            Toast.makeText(getActivity(), "transaccion registrada correctamente", Toast.LENGTH_SHORT).show();
                        }  else if (buttonchecked ==0 && splazo.equals("")) {
                            register(cuentaActual,RETIRO,buttonchecked, scat, smonto, "");
                            Toast.makeText(getActivity(), "transaccion registrada correctamente", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getActivity(), "datos llenados incorrectamente", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getActivity(), "Tas pendejo o que mijo", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getActivity(), "No hay cuenta seleccionada para esta transferencia", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return v;
    }

    public void register(int cuentaActual,int retiroDeposito,int tipo, String categoria,String monto,String plazo,String latlng){
        SQLiteOpen conn = new SQLiteOpen(getContext(), "bdCuentas",null,1);
        SQLiteDatabase database = conn.getWritableDatabase();
        Date tiempo = new Date();
        int hrs=tiempo.getHours();
        int min=tiempo.getMinutes();
        int dia=tiempo.getDate();
        int mes=tiempo.getMonth()+1;
        int anual=tiempo.getYear()+1900;
        String date = dia +"/"+mes+"/"+anual+" "+hrs+":"+min ;
        ContentValues registery = new ContentValues();

        registery.put("cuenta", String.valueOf(cuentaActual));
        registery.put("retiroDeposito", String.valueOf(retiroDeposito));
        registery.put("tipo", String.valueOf(tipo));
        registery.put("categoria", String.valueOf(categoria));
        registery.put("monto", String.valueOf(monto));
        registery.put("plazo", String.valueOf(plazo));
        registery.put("latlng", String.valueOf(latlng));
        registery.put("fecha", date);
        Long idResult=database.insert("trans",null,registery);
        Toast.makeText(getActivity(),"Id Registro: "+idResult,Toast.LENGTH_SHORT).show();
        conn.close();
        restarDeCuenta(Integer.parseInt(monto));
    }

    public void register(int cuentaActual,int retiroDeposito,int tipo, String categoria,String monto,String latlng){
        String plazo = "n/a";
        SQLiteOpen conn = new SQLiteOpen(getContext(), "bdCuentas",null,1);
        SQLiteDatabase database = conn.getWritableDatabase();
        Date tiempo = new Date();
        int hrs=tiempo.getHours();
        int min=tiempo.getMinutes();
        int dia=tiempo.getDate();
        int mes=tiempo.getMonth()+1;
        int anual=tiempo.getYear()+1900;
        String date = dia +"/"+mes+"/"+anual+" "+hrs+":"+min ;
        ContentValues registery = new ContentValues();
        registery.put("cuenta", String.valueOf(cuentaActual));
        registery.put("retiroDeposito", String.valueOf(retiroDeposito));
        registery.put("tipo", String.valueOf(tipo));
        registery.put("categoria", String.valueOf(categoria));
        registery.put("monto", String.valueOf(monto));
        registery.put("plazo", String.valueOf(plazo));
        registery.put("latlng", String.valueOf(latlng));
        registery.put("fecha", date);
        Long idResult=database.insert("trans",null,registery);
        Toast.makeText(getActivity(),"Id Registro: "+idResult,Toast.LENGTH_SHORT).show();
        conn.close();
        restarDeCuenta(Integer.parseInt(monto));
    }
    public void restarDeCuenta(int monto){
        SessionManagment sessionManagment = new SessionManagment(getContext());
        SQLiteOpen conn = new SQLiteOpen(getContext(), "bdCuentas",null,1);
        SQLiteDatabase database = conn.getWritableDatabase();
        String stringsaldo =  sessionManagment.getSALDO();
        int saldo = Integer.parseInt(stringsaldo);

        saldo = saldo-monto;
        ContentValues registery = new ContentValues();
        registery.put("saldo",String.valueOf(saldo));
        database.update("cuentas",registery, "id="+cuentaActual, null);
        sessionManagment.setSaldo(saldo);
    }





}
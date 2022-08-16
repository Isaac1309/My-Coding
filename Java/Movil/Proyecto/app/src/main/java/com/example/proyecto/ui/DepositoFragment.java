package com.example.proyecto.ui;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyecto.R;
import com.example.proyecto.SQLiteOpen;
import com.example.proyecto.SessionManagment;

import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DepositoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DepositoFragment extends Fragment {
    int tipo= -1;
    int cuentaActual;
    int DEPOSITO = 1;
    RadioButton radioButton;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DepositoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DepositoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DepositoFragment newInstance(String param1, String param2) {
        DepositoFragment fragment = new DepositoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.fragment_deposito,container,false);

        RadioGroup radioGroup = v.findViewById(R.id.radioGDepo);
        TextView categoria = v.findViewById(R.id.categoriaD);
        TextView monto = v.findViewById(R.id.monto);
        TextView plazo = v.findViewById(R.id.diaP);
        Button btnAgregar = v.findViewById(R.id.btnAgregar);
        SessionManagment sessionManagment = new SessionManagment(getContext());
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton = v.findViewById(checkedId);
                String srad = String.valueOf(radioButton.getText());
                if(srad.equals("Deposito Unico")){
                    tipo = 0;
                }else if(srad.equals("Deposito Recurrente")){
                    tipo = 1;
                }
            }
        });


        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cuentaActual = sessionManagment.getID();
                String scat = String.valueOf(categoria.getText());
                String smonto = String.valueOf(monto.getText());
                String splazo = String.valueOf(plazo.getText());
                if(cuentaActual!=-1){
                    if(tipo == 0 && !scat.equals("")&& !smonto.equals("")&& splazo.equals("")){
                        register(cuentaActual,DEPOSITO,tipo,scat,smonto,"");
                    }else if(tipo == 1 && !scat.equals("")&& !smonto.equals("")&& !splazo.equals("")){
                        register(cuentaActual,DEPOSITO,tipo,scat,smonto,splazo,"");
                    }else{
                        Toast.makeText(getActivity(),"Datos ingresados incorrectamente",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getActivity(),"No hay cuenta Seleccionada",Toast.LENGTH_SHORT).show();
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
        depositar(Integer.parseInt(monto));
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
        depositar(Integer.parseInt(monto));
    }

    public void depositar(int monto){
        SessionManagment sessionManagment = new SessionManagment(getContext());
        SQLiteOpen conn = new SQLiteOpen(getContext(), "bdCuentas",null,1);
        SQLiteDatabase database = conn.getWritableDatabase();
        String stringsaldo =  sessionManagment.getSALDO();
        int saldo = Integer.parseInt(stringsaldo);

        saldo = saldo+monto;
        ContentValues registery = new ContentValues();
        registery.put("saldo",String.valueOf(saldo));
        database.update("cuentas",registery, "id="+cuentaActual, null);
        sessionManagment.setSaldo(saldo);
    }

}
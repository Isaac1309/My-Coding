package com.example.proyecto.ui.Reporte;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.proyecto.Cuentas;
import com.example.proyecto.R;
import com.example.proyecto.SQLiteOpen;
import com.example.proyecto.SessionManagment;
import com.example.proyecto.Transaccion;

import java.util.ArrayList;

public class ReporteFragment extends Fragment {
    SQLiteOpen conn;
    ListView listViewC;
    ArrayList<String> listInf;
    ArrayList<Transaccion> listTrans;
    int cuentaActual;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_reporte,container,false);
        Button gastoTotalM = v.findViewById(R.id.btnGastoT);
        Button gastoCuentaM = v.findViewById(R.id.btnGastoM);
        Button gastoPorF = v.findViewById(R.id.btnGastoF);
        TextView primF = v.findViewById(R.id.textPrimF);
        TextView segF = v.findViewById(R.id.textSegF);
        TextView gastoT = v.findViewById(R.id.GastoT);
        TextView depositoT = v.findViewById(R.id.DepositoT);

        SessionManagment sessionManagment = new SessionManagment(getContext());
        cuentaActual = sessionManagment.getID();
        gastoCuentaM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        gastoTotalM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        gastoPorF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



        return v;


    }

    private void consultar(){

        SQLiteDatabase db = conn.getReadableDatabase();
        Transaccion transaccion = null;
        listTrans = new ArrayList<Transaccion>();
        Cursor cursor = db.rawQuery("SELECT * FROM cuentas",null);

        while(cursor.moveToNext()){
            transaccion = new Transaccion();
            transaccion.setId(cursor.getInt(0));
            transaccion.setTipo(cursor.getInt(1));
            transaccion.setCategoria(cursor.getString(2));
            transaccion.setMonto(cursor.getString(3));
            transaccion.setPlazo(cursor.getString(4));
            transaccion.setLatlng(cursor.getString(5));
            transaccion.setDate(cursor.getString(6));
            listTrans.add(transaccion);
        }
        obtenerLista();
    }
    private void obtenerLista(){
        listInf = new ArrayList<String>();
        for (int i =0 ;i<listTrans.size();i++){
            String tipo ="";
            if(listTrans.get(i).getTipo() == 0){
                tipo = "Efectivo";
            }
            if(listTrans.get(i).getTipo() == 1){
                tipo = "Debito";
            }
            if(listTrans.get(i).getTipo() == 2){
                tipo = "Credito";
            }
            listInf.add(listTrans.get(i).getId()+" - " +tipo+" - "+listTrans.get(i).getCategoria());
        }
    }
}
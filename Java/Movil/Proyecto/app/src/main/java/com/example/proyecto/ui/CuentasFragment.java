package com.example.proyecto.ui;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.proyecto.Cuentas;
import com.example.proyecto.MainActivity;
import com.example.proyecto.R;
import com.example.proyecto.SQLiteOpen;
import com.example.proyecto.SessionManagment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CuentasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CuentasFragment extends Fragment {
    Button btnCrearCuentas;
    Button btnActualizar;
    Button btnEliminar;
    ListView listViewC;
    ArrayList<String> listInf;
    ArrayList<Cuentas> listCuentas;
    SQLiteOpen conn;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CuentasFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CuentasFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CuentasFragment newInstance(String param1, String param2) {
        CuentasFragment fragment = new CuentasFragment();
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
        View v = inflater.inflate(R.layout.fragment_cuentas, container, false);
        btnActualizar = v.findViewById(R.id.btnActualizarCuentas);
        btnEliminar = v.findViewById(R.id.btnEliminarCuenta);
        conn = new SQLiteOpen(getContext(),"bdCuentas",null,1);
        listViewC = v.findViewById(R.id.listadeCuentas);
        btnCrearCuentas = v.findViewById(R.id.btnCrearC);
        consultar();

        ArrayAdapter adaptador = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1,listInf);
        listViewC.setAdapter(adaptador);

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultar();
                ArrayAdapter adaptador = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1,listInf);
                listViewC.setAdapter(adaptador);
            }
        });

        btnCrearCuentas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CrearCuentaFragment cuentasFragment = new CrearCuentaFragment();
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                transaction.replace(R.id.cuentas,cuentasFragment);
                transaction.commit();
                v.setVisibility(View.INVISIBLE);
                listViewC.setVisibility(View.INVISIBLE);
                btnActualizar.setVisibility(View.INVISIBLE);
                btnEliminar.setVisibility(View.INVISIBLE);
            }
        });

        SessionManagment sessionManagment = new SessionManagment(getContext());

        listViewC.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sessionManagment.removeSession();
                sessionManagment.saveSession(listCuentas.get(position));
                int idc=sessionManagment.getID();
                Toast.makeText(getContext(),"Cuenta Seleccionada: "+idc,Toast.LENGTH_SHORT).show();
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int idc=sessionManagment.getID();
                eliminar(idc);
                sessionManagment.removeSession();
                consultar();
                ArrayAdapter adaptador = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1,listInf);
                listViewC.setAdapter(adaptador);
            }
        });

        return v;
    }
    private void consultar(){

        SQLiteDatabase db = conn.getReadableDatabase();
        Cuentas cuenta = null;
        listCuentas = new ArrayList<Cuentas>();
        Cursor cursor = db.rawQuery("SELECT * FROM cuentas",null);

        while(cursor.moveToNext()){
            cuenta = new Cuentas();
            cuenta.setId(cursor.getInt(0));
            cuenta.setTipo(cursor.getInt(1));
            cuenta.setNombre(cursor.getString(2));
            cuenta.setSaldo(cursor.getString(3));
            cuenta.setFecha(cursor.getString(4));
            listCuentas.add(cuenta);
        }
        obtenerLista();
    }

    private void eliminar(int idb){
        SessionManagment sessionManagment = new SessionManagment(getContext());
        SQLiteDatabase db = conn.getReadableDatabase();
        int cuentas = listCuentas.size();
        int cuentasEfectivo=0;
        for(int i = 0;i<listCuentas.size();i++){
            if(listCuentas.get(i).getTipo() ==0){
                cuentasEfectivo++;
            }
        }
        int  tipo = sessionManagment.getTIPO();
        if(tipo ==0 && cuentasEfectivo < 2){
            Toast.makeText(getActivity(),"No se puede eliminar cuenta",Toast.LENGTH_SHORT).show();
        }else{
            db.delete("cuentas","id = "+idb,null);
        }
    }

    private void obtenerLista(){
        listInf = new ArrayList<String>();
        for (int i =0 ;i<listCuentas.size();i++){
            String tipo ="";
            if(listCuentas.get(i).getTipo() == 0){
                tipo = "Efectivo";
            }
            if(listCuentas.get(i).getTipo() == 1){
                tipo = "Debito";
            }
            if(listCuentas.get(i).getTipo() == 2){
                tipo = "Credito";
            }
            listInf.add(listCuentas.get(i).getId()+" - " +tipo+" - "+listCuentas.get(i).getNombre());
        }
    }
}
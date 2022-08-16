package com.example.proyecto.ui;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyecto.MainActivity;
import com.example.proyecto.R;
import com.example.proyecto.SQLiteOpen;

import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CrearCuentaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CrearCuentaFragment extends Fragment {
    RadioButton radioButton;
    RadioGroup radioGroup;
    int rbSelected = 5;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CrearCuentaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CrearCuentaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CrearCuentaFragment newInstance(String param1, String param2) {
        CrearCuentaFragment fragment = new CrearCuentaFragment();
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
        View v =  inflater.inflate(R.layout.fragment_crear_cuenta,container,false);
        Button crearcuenta = v.findViewById(R.id.btnCrear);
        RadioGroup radioGroup = (RadioGroup) v.findViewById(R.id.rGroup);
        TextView nomcuenta = v.findViewById(R.id.nomCuenta);
        TextView cantidad = v.findViewById(R.id.cantidadD);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                radioButton = v.findViewById(checkedId);
               if(radioButton.getText().equals("Efectivo")){
                   rbSelected =0;
               }else if(radioButton.getText().equals("Debito")){
                    rbSelected =1;

                }else if(radioButton.getText().equals("Credito")){
                    rbSelected =2;


                }else{
                   Toast.makeText(getActivity(), "debes seleccionar un tipo", Toast.LENGTH_SHORT).show();
                }

            }
        });
        crearcuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = String.valueOf( nomcuenta.getText());
                String saldo = String.valueOf( cantidad.getText() );


                if(!nombre.equals("") && !saldo.equals("")) {
                    if (rbSelected !=5) {
                        register(rbSelected, nombre, saldo);
                    }else{
                        Toast.makeText(getActivity(),"debes seleccionar un tipo",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getActivity(), "debes llenar todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return v;



    }
    public void register(int tipoDeCuenta, String nombre,String saldo){
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
        registery.put("tipo", String.valueOf(tipoDeCuenta));
        registery.put("nombre", String.valueOf(nombre));
        registery.put("saldo", String.valueOf(saldo));
        registery.put("fecha", date);
        Long idResult=database.insert("cuentas",null,registery);
        Toast.makeText(getActivity(),"Id Registro: "+idResult,Toast.LENGTH_SHORT).show();
        conn.close();
    }
}
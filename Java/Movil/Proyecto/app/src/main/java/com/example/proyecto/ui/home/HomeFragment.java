package com.example.proyecto.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.proyecto.R;
import com.example.proyecto.SessionManagment;

public class HomeFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home,container,false);
        SessionManagment sessionManagment = new SessionManagment(getContext());
        TextView txtTipo = v.findViewById(R.id.text_cuenta);
        TextView textView = v.findViewById(R.id.text_home);
        TextView txtSaldo = v.findViewById(R.id.txt_Saldo);
        int getTp = sessionManagment.getTIPO();
        if (getTp==0){
            textView.setText("Nombre de la cuenta: '"+sessionManagment.getNOMBRE()+"'");
            txtSaldo.setText("Saldo en la cuenta: '"+sessionManagment.getSALDO()+" $'");
            txtTipo.setText("Tipo de cuenta: 'Efectivo'");
        }else if (getTp==1){
            textView.setText("Nombre de la cuenta: '"+sessionManagment.getNOMBRE()+"'");
            txtSaldo.setText("Saldo en la cuenta: '"+sessionManagment.getSALDO()+" $'");
            txtTipo.setText("Tipo de cuenta: 'Debito'");
        }else if (getTp==2){
            textView.setText("Nombre de la cuenta: '"+sessionManagment.getNOMBRE()+"'");
            txtSaldo.setText("Saldo en la cuenta: '"+sessionManagment.getSALDO()+" $'");
            txtTipo.setText("Tipo de cuenta: 'Credito'");
        }else{
            textView.setText("");
            txtSaldo.setText("");
            txtTipo.setText("");
        }
        return v;
    }
}
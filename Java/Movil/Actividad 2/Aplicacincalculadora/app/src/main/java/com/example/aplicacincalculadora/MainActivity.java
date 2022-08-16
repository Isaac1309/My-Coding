package com.example.aplicacincalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button Num0,Num1,Num2,Num3,Num4,Num5,Num6,Num7,Num8,Num9, btndivision, btnmultiplicacion, btnresta, btnsuma, btndecimal, btnigual, btnlimpiar;
    EditText Texto, agregar;
    double NumUno, NumDos, resultado;
    String operador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Num0 = (Button)findViewById(R.id.Num0);
        Num1 = (Button)findViewById(R.id.Num1);
        Num2 = (Button)findViewById(R.id.Num2);
        Num3 = (Button)findViewById(R.id.Num3);
        Num4 = (Button)findViewById(R.id.Num4);
        Num5 = (Button)findViewById(R.id.Num5);
        Num6 = (Button)findViewById(R.id.Num6);
        Num7 = (Button)findViewById(R.id.Num7);
        Num8 = (Button)findViewById(R.id.Num8);
        Num9 = (Button)findViewById(R.id.Num9);
        btndivision = (Button)findViewById(R.id.btndivision);
        btnmultiplicacion = (Button)findViewById(R.id.btnmultiplicacion);
        btnresta = (Button)findViewById(R.id.btnresta);
        btnsuma = (Button)findViewById(R.id.btnsuma);
        btndecimal = (Button)findViewById(R.id.btndecimal);
        btnigual = (Button)findViewById(R.id.btnigual);
        btnlimpiar = (Button)findViewById(R.id.btnlimpiar);
        Texto = (EditText)findViewById(R.id.Texto);

        Num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregar = (EditText)findViewById(R.id.Texto);
                Texto.setText(agregar.getText().toString() + "0");
            }
        });
        Num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregar = (EditText)findViewById(R.id.Texto);
                Texto.setText(agregar.getText().toString() + "1");

            }
        });
        Num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregar = (EditText)findViewById(R.id.Texto);
                Texto.setText(agregar.getText().toString() + "2");
            }
        });
        Num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregar = (EditText)findViewById(R.id.Texto);
                Texto.setText(agregar.getText().toString() + "3");
            }
        });
        Num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregar = (EditText)findViewById(R.id.Texto);
                Texto.setText(agregar.getText().toString() + "4");
            }
        });
        Num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregar = (EditText)findViewById(R.id.Texto);
                Texto.setText(agregar.getText().toString() + "5");
            }
        });
        Num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregar = (EditText)findViewById(R.id.Texto);
                Texto.setText(agregar.getText().toString() + "6");
            }
        });
        Num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregar = (EditText)findViewById(R.id.Texto);
                Texto.setText(agregar.getText().toString() + "7");
            }
        });
        Num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregar = (EditText)findViewById(R.id.Texto);
                Texto.setText(agregar.getText().toString() + "8");
            }
        });
        Num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregar = (EditText)findViewById(R.id.Texto);
                Texto.setText(agregar.getText().toString() + "9");
            }
        });
        btndecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregar = (EditText)findViewById(R.id.Texto);
                Texto.setText(agregar.getText().toString() + ".");
            }
        });
        btnigual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregar = (EditText)findViewById(R.id.Texto);
                NumDos = Double.parseDouble(agregar.getText().toString());
                if(operador.equals("+")){
                    Texto.setText("");
                    resultado = NumUno + NumDos;
                }
                if(operador.equals("-")){
                    Texto.setText("");
                    resultado = NumUno - NumDos;
                }
                if(operador.equals("*")){
                    Texto.setText("");
                    resultado = NumUno * NumDos;
                }
                if(operador.equals("/")){
                    Texto.setText("");
                    if(NumDos != 0){
                        resultado = NumUno / NumDos;
                    }else {
                        Texto.setText("Infinito");
                    }
                }
                Texto.setText(String.valueOf(resultado));
            }
        });
        btnsuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operador = "+";
                agregar = (EditText)findViewById(R.id.Texto);
                NumUno = Double.parseDouble(agregar.getText().toString());
                Texto.setText("");
            }
        });
        btnresta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operador = "-";
                agregar = (EditText)findViewById(R.id.Texto);
                NumUno = Double.parseDouble(agregar.getText().toString());
                Texto.setText("");
            }
        });
        btnmultiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operador = "*";
                agregar = (EditText)findViewById(R.id.Texto);
                NumUno = Double.parseDouble(agregar.getText().toString());
                Texto.setText("");
            }
        });
        btndivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operador = "/";
                agregar = (EditText)findViewById(R.id.Texto);
                NumUno = Double.parseDouble(agregar.getText().toString());
                Texto.setText("");
            }
        });
        btnlimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumUno = 0;
                NumDos = 0;
                Texto.setText("");
            }
        });

    }
}
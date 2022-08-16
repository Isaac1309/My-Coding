package com.example.bdatosnm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_viewAll;
    ListView lv_dbList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_viewAll=findViewById(R.id.btn_viewAll);
        lv_dbList=findViewById(R.id.lv_dbList);

        btn_viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "View All", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
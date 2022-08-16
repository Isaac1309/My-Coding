package com.example.proyecto;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteOpen extends SQLiteOpenHelper {
    public SQLiteOpen(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE cuentas(id INTEGER PRIMARY KEY AUTOINCREMENT,tipo INTEGER, nombre TEXT, saldo TEXT, fecha TEXT )");

        db.execSQL("CREATE TABLE trans(id INTEGER PRIMARY KEY AUTOINCREMENT,cuenta INTEGER,retiroDeposito INTEGER,tipo INTEGER, categoria TEXT, monto TEXT, plazo TEXT,latlng TEXT, fecha TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS cuentas");
        db.execSQL("DROP TABLE IF EXISTS trans");
        onCreate(db);
    }
}

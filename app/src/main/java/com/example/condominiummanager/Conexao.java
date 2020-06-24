package com.example.condominiummanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class Conexao extends SQLiteOpenHelper {
    public static final String name = "Cmanager.db";
    public static final int version = 1;

    public Conexao(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table usuario(cpf varchar(16) primary Key, " +
                "senha varchar(20), nome varchar(100));");
        db.execSQL("create table reclamacao(id integer primary Key autoincrement,"+
                "fk_usuario varchar(18), reclamacao varchar(500));");
        db.execSQL("create table edital(id integer primary Key autoincrement,"+
                " aviso varchar(500), data_p varchar(11), data_r varchar(11));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}

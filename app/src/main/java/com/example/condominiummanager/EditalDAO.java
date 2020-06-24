package com.example.condominiummanager;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

class EditalDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;
    private SQLiteDatabase checar;
    private String aviso = "aviso";
    private String data_p = "data_p";
    private String date_r = "date_r";
    private String nome_tabela = "edital";

    public EditalDAO() {
    }

    public void setConexao(Conexao con){
        conexao = con;
        banco = conexao.getWritableDatabase();
        checar = conexao.getReadableDatabase();
    }
    public long inserir(Edital edital){
        ContentValues values = new ContentValues();
        values.put(aviso, edital.getAviso());
        values.put(data_p, edital.getData_p());
        values.put(date_r, edital.getDate_r());
        return banco.insert(nome_tabela, null, values);
    }
    public Edital consultar(int id){
        Edital e = new Edital();
        String querry = "SELECT " + aviso + ", " + data_p + ", " + date_r + " FROM " + nome_tabela + " WHERE id="+id;
        Cursor cursor = banco.rawQuery(querry,null);
        while (cursor.moveToNext()){
            e.setAviso(cursor.getString(0));
            e.setData_p(cursor.getString(1));
            e.setDate_r(cursor.getString(2));
        }
        return e;
    }
    public void atualizar(Edital edital){
        ContentValues cv = new ContentValues();
        cv.put(aviso, edital.getAviso());
        cv.put(data_p, edital.getData_p());
        cv.put(date_r, edital.getDate_r());
        banco.update(nome_tabela, cv, "id = ?", new String[]{String.valueOf(edital.getId())});
    }
    public void remover(String id){
        banco.delete(nome_tabela, "id = ?", new String[]{id});
    }
}

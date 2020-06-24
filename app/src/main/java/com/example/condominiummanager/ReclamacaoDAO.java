package com.example.condominiummanager;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

class ReclamacaoDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;
    private String nome_tabela = "reclamacao";
    private String usuario = "fk_usuario";
    private String reclamacao = "reclamacao";

    public ReclamacaoDAO() {
    }
    public void setConexao(Conexao con){
        conexao = con;
        banco   = conexao.getWritableDatabase();

    }
    public long inserir(Reclamacoes reclamacoes){
        ContentValues values = new ContentValues();
        values.put(reclamacao, reclamacoes.getReclamacao());
        values.put(usuario, reclamacoes.getUsuario());
        return banco.insert(nome_tabela, null, values);
    }
    public Reclamacoes consultar(int id){
        Reclamacoes r = new Reclamacoes();
        String querry = "SELECT " + usuario + ", " + reclamacao + " FROM " + nome_tabela + " WHERE id="+id;
        Cursor cursor = banco.rawQuery(querry,null);
        while(cursor.moveToNext()){
            r.setUsuario(cursor.getString(0));
            r.setReclamacao(cursor.getString(1));
        }
        return r;
    }
    public void atualizar(Reclamacoes reclamacoes){
        ContentValues cv = new ContentValues();
        cv.put(reclamacao, reclamacoes.getReclamacao());
        cv.put(usuario, reclamacoes.getUsuario());
        banco.update(nome_tabela, cv, whereClause: "id = ?", new String[]{String.valueOf(reclamacoes.getId())});
    }
    public void remover(String id){
        banco.delete(nome_tabela, whereClause: "id = ?", new String[]{id});
    }
}

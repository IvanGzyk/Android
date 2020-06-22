package com.example.condominiummanager;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

class UsuarioDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;
    private String cpf = "cpf";
    private String senha = "senha";
    private String nome = "nome";
    private String nome_tabela = "usuario";

    public UsuarioDAO(){
    }
    public void setConexao(Conexao con){
        conexao = con;
        banco = conexao.getWritableDatabase();
    }
    public long inserir(Usuario usuario){
        ContentValues values = new ContentValues();
        values.put(cpf, usuario.getCpf());
        values.put(senha, usuario.getSenha());
        values.put(nome, usuario.getNome());
        return banco.insert(nome_tabela, null, values);
    }
    public Usuario consultar(String cpf){
        Usuario u = new Usuario();
        String querry = "SELECT " + cpf + ", " + senha + ", " + nome + " FROM " + nome_tabela + " WHERE cpf="+cpf;
        Cursor cursor = banco.rawQuery(querry,null);

        while(cursor.moveToNext()){
            u.setCpf(cursor.getString(0));
            u.setSenha(cursor.getString(1));
            u.setNome(cursor.getString(2));
        }
        return u;
    }
}

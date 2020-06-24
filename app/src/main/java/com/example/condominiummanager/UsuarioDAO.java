package com.example.condominiummanager;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

class UsuarioDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;
    private SQLiteDatabase checar;// Chama o SQLite
    private String cpf = "cpf";
    private String senha = "senha";
    private String nome = "nome";
    private String nome_tabela = "usuario";

    public UsuarioDAO(){
    }

    public void setConexao(Conexao con){
        conexao = con;
        banco = conexao.getWritableDatabase();
        checar = conexao.getReadableDatabase(); //verificação SELECT
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
    //Verifica login tipo bool
    public boolean checklogin(String login, String senha) {
        Cursor cursor = checar.rawQuery("select * from usuario where cpf=? and senha=?", new String[]{login, senha});
        if (cursor.getCount() > 0){
            return true;
        }else{
            return false;
        }
    }
    public void atualizar(Usuario usuario){
        ContentValues cv = new ContentValues();
        cv.put(cpf, usuario.getCpf());
        cv.put(senha, usuario.getSenha());
        cv.put(nome, usuario.getNome());
        banco.update(nome_tabela, cv, whereClause: "cpf = ?", new String[]{String.valueOf(usuario.getCpf())});
    }
    public void remover(String cpf){
        banco.delete(nome_tabela, whereClause: "cpf = ?", new String[]{cpf});
    }
}

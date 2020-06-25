package com.example.condominiummanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainReclamacoes extends AppCompatActivity {
    private Button bt_salvar;
    private ReclamacaoDAO dao;
    private Usuario user;
    private Conexao conexao;
    private EditText reclame;
    private String usuario = user.getCpf();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_reclamacoes);

        bt_salvar = findViewById(R.id.salvar_reclame);
        reclame = findViewById(R.id.reclames);
        conexao = new Conexao(this);
        dao = new ReclamacaoDAO();
        dao.setConexao(conexao);
        bt_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });
    }
    private void salvar(){
        Reclamacoes r = new Reclamacoes();
        r.setReclamacao(reclame.getText().toString());
        r.setUsuario(usuario);//verificar como faz para pegar o cpf do usuario logado...
        long id = dao.inserir(r);
        Toast.makeText(this, "Reclamação: " + id, Toast.LENGTH_LONG).show();

    }
}
package com.example.condominiummanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainReclamacoes extends AppCompatActivity {
    private Button bt_salvar;
    private Button bt_buscar;
    private ReclamacaoDAO dao;
    private Usuario user;
    private Conexao conexao;
    private EditText reclame;
    private EditText busca;
    private EditText edtID;
    private EditText cpf_usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_reclamacoes);

        bt_salvar = findViewById(R.id.salvar_reclame);
        bt_buscar = findViewById(R.id.bt_buscar);
        reclame = findViewById(R.id.reclames);
        busca = findViewById(R.id.r_busca);
        cpf_usuario = findViewById(R.id.r_cpf);
        conexao = new Conexao(this);
        dao = new ReclamacaoDAO();
        dao.setConexao(conexao);
        bt_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });

        //Consultar
        edtID = findViewById(R.id.r_busca);
        bt_salvar = findViewById(R.id.bt_buscar);

        bt_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(edtID.getText().toString());
                consultar(id);
            }
        });
    }
    private void salvar(){
        Reclamacoes r = new Reclamacoes();
        r.setReclamacao(reclame.getText().toString());
        r.setUsuario(cpf_usuario.getText().toString());
        long id = dao.inserir(r);
        Toast.makeText(this, "Reclamação: " + id, Toast.LENGTH_LONG).show();
    }
    public void consultar(int id){
        Reclamacoes r = dao.consultar(id);
        reclame.setText(r.getReclamacao());
        cpf_usuario.setText(r.getUsuario());
    }
}
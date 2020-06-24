package com.example.condominiummanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainAvisos extends AppCompatActivity {
    private EditText aviso;
    private EditText data_p;
    private EditText data_r;
    private Button bt_salvar;
    private EditalDAO dao;
    private Conexao conexao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_avisos);

        bt_salvar = findViewById(R.id.button3);
        aviso = findViewById(R.id.texto_avisos);
        data_p = findViewById(R.id.editTextDate);
        data_r = findViewById(R.id.editTextDate2);
        conexao = new Conexao(this);
        dao = new EditalDAO();
        dao.setConexao(conexao);

        bt_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });
    }
    private void salvar(){
        Edital e = new Edital();
        e.setAviso(aviso.getText().toString());
        e.setData_p(data_p.getText().toString());
        e.setDate_r(data_r.getText().toString());
        long id = dao.inserir(e);
        Toast.makeText(this, "Aviso: " + id, Toast.LENGTH_LONG).show();
    }
}
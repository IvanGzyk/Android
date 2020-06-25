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
    private EditText busca;
    private Button bt_salvar;
    private EditText edtID;
    private EditalDAO dao;
    private Conexao conexao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_avisos);

        bt_salvar = findViewById(R.id.button3);
        aviso = findViewById(R.id.texto_avisos);
        data_p = findViewById(R.id.data_p);
        data_r = findViewById(R.id.data_r);
        busca = findViewById(R.id.a_busca);
        conexao = new Conexao(this);
        dao = new EditalDAO();
        dao.setConexao(conexao);

        //Salvar
        bt_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });

        //Consultar
        edtID = findViewById(R.id.a_busca);
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
        Edital e = new Edital();
        e.setAviso(aviso.getText().toString());
        e.setData_p(data_p.getText().toString());
        e.setDate_r(data_r.getText().toString());
        long id = dao.inserir(e);
        Toast.makeText(this, "Aviso: " + id, Toast.LENGTH_LONG).show();
    }
    public void consultar(int id){
        Edital e = dao.consultar(id);
        aviso.setText(e.getAviso());
        data_p.setText(e.getData_p());
        data_r.setText(e.getDate_r());
    }
}
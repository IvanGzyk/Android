package com.example.condominiummanager;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainCadastro extends AppCompatActivity {
    private EditText cpfCnpj;
    private EditText senha;
    private EditText nome;
    private Button bt_salvar;
    private UsuarioDAO dao;
    private Conexao conexao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cadastro);

        bt_salvar = findViewById(R.id.bt_salvar);
        cpfCnpj = findViewById(R.id.cpfCnpj);
        senha = findViewById(R.id.senha);
        nome = findViewById(R.id.nome);
        conexao = new Conexao(this);
        dao = new UsuarioDAO();
        dao.setConexao(conexao);

        bt_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });
    }

    private void salvar() {
        Usuario u = new Usuario();
        u.setCpf(cpfCnpj.getText().toString());
        u.setNome(nome.getText().toString());
        u.setSenha(senha.getText().toString());
        long id = dao.inserir(u);
        Toast.makeText(this, "Usuario: " + id, Toast.LENGTH_LONG).show();
    }
}
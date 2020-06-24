package com.example.condominiummanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainLoginActivity extends AppCompatActivity {
    Button entrar;
    EditText cpf, pass;
    Conexao conexao;
    UsuarioDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        conexao = new Conexao(this);
        dao = new UsuarioDAO();
        dao.setConexao(conexao);
        entrar = (Button) findViewById(R.id.entrar);
        cpf = (EditText) findViewById(R.id.login);
        pass = (EditText) findViewById(R.id.senha);

        entrar.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View v){
                String login = cpf.getText().toString();
                String senha = pass.getText().toString();
                Boolean chkacesso = dao.checklogin(login, senha);

                if(chkacesso == true) {
                    Toast.makeText(MainLoginActivity.this, "Login feito com sucesso!!!", Toast.LENGTH_LONG).show();
                    Intent tela = new Intent(MainLoginActivity.this, MainPrincipalActivity.class);
                    startActivity(tela);
                }else {
                    Toast.makeText(MainLoginActivity.this, "Dados incorretos! Tente novamente.", Toast.LENGTH_LONG).show();
                }
            }
        });
}
}

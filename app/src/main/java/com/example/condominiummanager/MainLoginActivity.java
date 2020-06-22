package com.example.condominiummanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainLoginActivity extends AppCompatActivity {
    private Button entrar;
    private EditText login;
    private EditText senha;
    private EditText senha_bd;
    private EditText nome;
    private UsuarioDAO dao;
    private Conexao conexao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

    entrar = (Button) findViewById(R.id.entrar);
    login = (EditText) findViewById(R.id.cpfCnpj);
    senha = (EditText) findViewById(R.id.senha);
}

    public void ProximaPagina(View v){
        consultar(login.getText().toString());
        Toast.makeText(MainLoginActivity.this, nome +"Bem vindo ao Cmanager!!!", Toast.LENGTH_LONG).show();
        if (senha == senha_bd) {
            Intent tela = new Intent(this, MainPrincipalActivity.class);
            startActivity(tela);
        }
    }

    public void consultar(String cpf){
        Usuario usuarioconsulta = dao.consultar(cpf);
        nome.setText(usuarioconsulta.getNome());
        senha_bd.setText(usuarioconsulta.getSenha());
    }
}

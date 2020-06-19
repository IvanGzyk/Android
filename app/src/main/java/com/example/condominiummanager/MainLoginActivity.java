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
    EditText login;
    EditText senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

    entrar = (Button) findViewById(R.id.entrar);
    login = (EditText) findViewById(R.id.cpfCnpj);
    senha = (EditText) findViewById(R.id.senha);
}
    public void ProximaPagina(View v){
        Toast.makeText(MainLoginActivity.this, "Bem vindo ao Cmanager!!!", Toast.LENGTH_LONG).show();
        Intent tela = new Intent(this, MainPrincipalActivity.class);
        startActivity(tela);
    }
}

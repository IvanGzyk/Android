package com.example.condominiummanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainLoginActivity extends AppCompatActivity {
    Button entrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

    entrar = (Button) findViewById(R.id.entrar);
}
    public void ProximaPagina(View v){
        Intent tela = new Intent(this, MainPrincipalActivity.class);
        startActivity(tela);
    }
}

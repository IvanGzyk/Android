package com.example.condominiummanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainPrincipalActivity extends AppCompatActivity {

    ImageButton avisos;
    ImageButton reclamacoes;
    ImageButton config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_principal);

        avisos = (ImageButton) findViewById(R.id.avisos);
        reclamacoes = (ImageButton) findViewById(R.id.reclamacoes);
        config = (ImageButton) findViewById(R.id.usuario);

    }
    public void TelaAvisos(View v){
        Intent tela = new Intent(this, MainAvisos.class);
        startActivity(tela);
    }

    public void TeleReclamacoes(View v){
        Intent tela = new Intent(this,MainReclamacoes.class);
        startActivity(tela);
    }

    public void TelaConfig(View v){
        Intent tela = new Intent(this, MainUsuario.class);
        startActivity(tela);
    }

}

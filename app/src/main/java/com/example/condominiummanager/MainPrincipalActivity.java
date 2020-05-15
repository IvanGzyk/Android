package com.example.condominiummanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainPrincipalActivity extends AppCompatActivity {

    ImageButton avisos;
    ImageButton financeiro;
    ImageButton salao;
    ImageButton config;
    //Button sair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_principal);

        avisos = (ImageButton) findViewById(R.id.avisos);
        financeiro = (ImageButton) findViewById(R.id.financeiro);
        salao = (ImageButton) findViewById(R.id.salao);
        config = (ImageButton) findViewById(R.id.config);
        //sair = (Button) findViewById(R.id.sair);

    }
    public void TelaAvisos(View v){
        Intent tela = new Intent(this, MainBoletosActivity.class);
        startActivity(tela);
    }

    public void TelaFinanceiro(View v){
        Intent tela = new Intent(this, MainBoletosActivity.class);
        startActivity(tela);
    }

    public void TelaSalao(View v){
        Intent tela = new Intent(this, MainBoletosActivity.class);
        startActivity(tela);
    }

    public void TelaConfig(View v){
        Intent tela = new Intent(this, MainConfiguracoesActivity.class);
        startActivity(tela);
    }

    //public void TelaInicialSair(View v){
       // Intent tela = new Intent(this, MainActivity.class);
        //startActivity(tela);
    //}
}

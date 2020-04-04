package com.example.condominiummanager;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.ImageButton;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    ImageButton site;
    ImageButton entrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        site = (ImageButton) findViewById(R.id.site);
        entrar = (ImageButton) findViewById(R.id.entrar);

        site.setOnClickListener(new ImageButton.OnClickListener(){
            @Override
            public void onClick(View v) {

                String endereco = "http://www.cmanager.com.br";

                Uri uri = Uri.parse(endereco);

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);

                startActivity(intent);
            }
        });

    }
    public void TeleDeLogin(View v){
        Intent tela = new Intent(this, MainLoginActivity.class);
        startActivity(tela);
    }
}

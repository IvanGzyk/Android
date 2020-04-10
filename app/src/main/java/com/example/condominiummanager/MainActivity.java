package com.example.condominiummanager;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    Button site;
    Button entrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        site = (Button) findViewById(R.id.site);
        entrar = (Button) findViewById(R.id.entrar);

        site.setOnClickListener(new Button.OnClickListener(){
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

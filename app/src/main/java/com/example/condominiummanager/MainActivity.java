package com.example.condominiummanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.entrar:
                Intent tela = new Intent(this, MainLoginActivity.class);
                startActivity(tela);
                return true;
            case R.id.site:
                String endereco = "http://www.cmanager.com.br";
                Uri uri = Uri.parse(endereco);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                return true;
            case R.id.Cadastrar:
                Intent tela_cadastro = new Intent(this, MainCadastro.class);
                startActivity(tela_cadastro);
                return true;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}

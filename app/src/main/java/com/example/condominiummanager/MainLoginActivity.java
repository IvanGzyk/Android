package com.example.condominiummanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainLoginActivity extends AppCompatActivity {
    Button entrar;
    Button recacesso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

    entrar = (Button) findViewById(R.id.entrar);
    recacesso = (Button) findViewById(R.id.recacesso);

        recacesso.setOnClickListener(new Button.OnClickListener(){
        @Override
        public void onClick(View v) {

            String endereco = "http://www.cmanager.com.br/recuperar_acesso.php";
            Uri uri = Uri.parse(endereco);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    });

}
    public void PaginaPrincipal(View v){
        Intent tela = new Intent(this, MainPrincipalActivity.class);
        startActivity(tela);
    }
}

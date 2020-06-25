package com.example.condominiummanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainUsuario extends AppCompatActivity {
    private EditText cpfCnpj;
    private EditText senha;
    private EditText nome;
    private EditText consulta;
    private Button bt_salvar;
    private Button bt_atualizar;
    private Button bt_remover;
    private UsuarioDAO dao;
    private Conexao conexao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_usuario);
        bt_salvar = findViewById(R.id.c_salvar);
        bt_atualizar = findViewById(R.id.c_atualiza);
        bt_remover = findViewById(R.id.c_remove);
        cpfCnpj = findViewById(R.id.c_cpf);
        senha = findViewById(R.id.c_senha);
        nome = findViewById(R.id.c_nome);
        consulta = findViewById(R.id.c_busca);
        try {
            conexao = new Conexao(this);
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
        dao = new UsuarioDAO();
        dao.setConexao(conexao);

        //Salva
        bt_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });

        //Consulta
        bt_salvar = findViewById(R.id.c_consulta);
        bt_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cpf = consulta.getText().toString();
                consultar(cpf);
            }
        });

        //Remove
        bt_remover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remover();
            }
        });

        //Atualiza
        bt_atualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                atualizar();
            }
        });
    }
    private void salvar() {
        try {
            Usuario u = new Usuario();
            u.setCpf(cpfCnpj.getText().toString());
            u.setNome(nome.getText().toString());
            u.setSenha(senha.getText().toString());
            long id = dao.inserir(u);
            Toast.makeText(this, "Usuario: " + id, Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
    public void consultar(String cpf){
        try {
            Usuario usuario_consulta = dao.consultar(cpf);
            nome.setText(usuario_consulta.getNome());
            senha.setText(usuario_consulta.getSenha());
            cpfCnpj.setText(usuario_consulta.getCpf());
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
    public void remover(){
        try {
            dao.remover(consulta.getText().toString());
            Toast.makeText(this, "Removido com sucesso!!", Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
    public void atualizar(){
        try {
            Usuario u = new Usuario();
            u.setCpf(cpfCnpj.getText().toString());
            u.setNome(nome.getText().toString());
            u.setSenha(senha.getText().toString());
            dao.atualizar(u);
            Toast.makeText(this, "Atualizado com sucesso!!", Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
package com.example.dougl.appbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

    private EditText nameField;
    private EditText senhaField;
    private EditText confSenhaField;
    private EditText emailField;
    private EditText pergSecreta;
    private EditText resSecreta;
    private Button botaoConcluir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        nameField = (EditText) findViewById(R.id.CadastroNome);
        senhaField = (EditText) findViewById(R.id.CadastroSenha);
        confSenhaField = (EditText) findViewById(R.id.CadastroConfSenha);
        emailField = (EditText) findViewById(R.id.CadastroEmail);
        pergSecreta = (EditText) findViewById(R.id.CadastroPergunta);
        resSecreta = (EditText) findViewById(R.id.CadastroResposta);
        botaoConcluir = (Button) findViewById(R.id.buttonConcluir);

        botaoConcluir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(nameField.getText().length()==0 || senhaField.getText().length()==0
                        || confSenhaField.getText().length()==0 || emailField.getText().length()==0
                        || pergSecreta.getText().length()==0 || resSecreta.getText().length()==0){
                    Toast.makeText(CadastroActivity.this, R.string.completarCampos, Toast.LENGTH_SHORT).show();
                }else{
                    if(senhaField.getText().toString().equals(confSenhaField.getText().toString())){
                        Usuario usuario = new Usuario();
                        usuario.setEmail(emailField.getText().toString());
                        usuario.setNome(nameField.getText().toString());
                        usuario.setPergunta(pergSecreta.getText().toString());
                        usuario.setResposta(resSecreta.getText().toString());
                        usuario.setSenha(senhaField.getText().toString());
                        Toast.makeText(CadastroActivity.this, R.string.cadastroGG, Toast.LENGTH_SHORT).show();
                        onBackPressed();
                    }else{
                        Toast.makeText(CadastroActivity.this, R.string.senhasdesiguais, Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }


}

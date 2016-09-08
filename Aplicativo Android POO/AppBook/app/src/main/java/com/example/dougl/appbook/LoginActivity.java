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

public class LoginActivity extends AppCompatActivity {

    private EditText emailField;
    private EditText passwordField;
    private Button botaoLogar;
    private Button botaoSenha;
    private Button botaoCadastro;
    private int bodybuilder =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        botaoLogar = (Button)findViewById(R.id.buttonLogin);
        botaoCadastro = (Button) findViewById(R.id.buttonCadastro);
        botaoSenha = (Button) findViewById(R.id.buttonRecuperarSenha);
        emailField = (EditText) findViewById(R.id.EmailField);
        passwordField = (EditText) findViewById(R.id.SenhaField);

        botaoLogar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(validadorLogin(emailField.getText().toString(), passwordField.getText().toString())){
                    //Chama activity Pagina Inicial
                    Toast.makeText(LoginActivity.this, "Login GG", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, TelaPrincipalActivity.class);
                    startActivity(intent);
                }else{
                    passwordField.setText("");
                    Toast.makeText(LoginActivity.this, R.string.erro_login_mensage, Toast.LENGTH_SHORT).show();
                }
            }
        });

        botaoCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Chama Activity Cadastro
                Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });

        botaoSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RedefinirSenhaActivity.class);
                intent.putExtra("emailUser", emailField.getText().toString());
                startActivity(intent);
            }
        });

    }

    private boolean validadorLogin(String email, String senha){
        /*
        if(email.length() == 0 || senha.length() == 0) return false;
        else if(!email.contains("@")) return false;
        */



        return true;
    }

    @Override
    public void onBackPressed() {
        bodybuilder++;
        if(bodybuilder == 5) Toast.makeText(LoginActivity.this, R.string.zuerinha, Toast.LENGTH_SHORT).show();
        else if(bodybuilder == 9) Toast.makeText(LoginActivity.this, R.string.zuerinha2_0, Toast.LENGTH_SHORT).show();
        else if(bodybuilder == 13) Toast.makeText(LoginActivity.this, R.string.zuerinha5_0, Toast.LENGTH_SHORT).show();
        else if(bodybuilder == 18) Toast.makeText(LoginActivity.this, R.string.zuerinha3_0, Toast.LENGTH_SHORT).show();
        else if(bodybuilder == 29)Toast.makeText(LoginActivity.this, R.string.zuerinha4_0, Toast.LENGTH_SHORT).show();
    }
}

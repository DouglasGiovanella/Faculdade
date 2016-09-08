package com.example.dougl.appbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import static android.widget.TextView.*;

public class RedefinirSenhaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redefinir_senha);
        EditText campoEmail = (EditText) findViewById(R.id.RedefinirEmail);
        if (campoEmail != null) {
            campoEmail.setText(getIntent().getStringExtra("emailUser"), BufferType.EDITABLE);
        }

    }
}

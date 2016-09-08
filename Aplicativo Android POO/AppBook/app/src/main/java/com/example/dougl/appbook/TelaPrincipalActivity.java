package com.example.dougl.appbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;

public class TelaPrincipalActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (toolbar != null) {
            toolbar.setTitle("AppBook");
        }

        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();
        TabHost.TabSpec tabSpec = tabHost.newTabSpec("Meus Livros");
        tabSpec.setContent(R.id.tab1);
        tabSpec.setIndicator("Meus Livros");
        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("Recomendados");
        tabSpec2.setContent(R.id.tab2);
        tabSpec2.setIndicator("Recomendados");
        tabHost.addTab(tabSpec);
        tabHost.addTab(tabSpec2);

        ArrayList<Livro> livros = new ArrayList<Livro>();
        for(int i=0;i<5;i++){
            Livro livro = new Livro();
            livro.setNome("Nome "+i+1);
            livro.setAutor("Autor "+i+1);
            livros.add(livro);
        }
        ListView listView = (ListView) findViewById(R.id.listaMeuslivros);
        listView.setAdapter(new LivroAdapter(TelaPrincipalActivity.this, livros));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.desconetarItem){
            Intent intent = new Intent(TelaPrincipalActivity.this, LoginActivity.class);
            startActivity(intent);
            return true;
        }else{
            Intent intent = new Intent(TelaPrincipalActivity.this, CadastroLivroActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(TelaPrincipalActivity.this, "Desconecte-se no menu para voltar", Toast.LENGTH_LONG).show();
    }

}

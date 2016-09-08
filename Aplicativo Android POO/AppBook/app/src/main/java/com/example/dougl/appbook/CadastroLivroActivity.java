package com.example.dougl.appbook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import cz.msebera.android.httpclient.Header;

public class CadastroLivroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_livro);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Buscar Livros");

    }

    public void atualizaLista(String busca){
        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayList<Livro> livros = getLivros(busca);
        listView.setAdapter(new LivroAdapter(CadastroLivroActivity.this, livros));
        /*
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {

        }
        */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);


        SearchView sv = new SearchView(this);
        sv.setBackgroundColor(View.DRAWING_CACHE_QUALITY_AUTO);
        sv.setOnQueryTextListener(new SearchFiltro());
        MenuItem m1 = menu.add(0,0,0, "Item 1");
        m1.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        m1.setActionView(sv);

        return (true);

    }

    private class SearchFiltro implements SearchView.OnQueryTextListener{


        @Override
        public boolean onQueryTextSubmit(String query) {
            atualizaLista(query);
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            atualizaLista(newText);
            return false;
        }
    }


    public ArrayList<Livro> getLivros(String textoPesquisa){

        final ArrayList<Livro> livros = new ArrayList<Livro>();

        if(textoPesquisa.length()>0){

            textoPesquisa = textoPesquisa.replace(" ", "+");
            String url = "https://www.googleapis.com/books/v1/volumes?q=";
            url = url + textoPesquisa;

            AsyncHttpClient client = new AsyncHttpClient();
            client.get(url, new AsyncHttpResponseHandler() {

                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                    String json = new String(responseBody);

                    try {
                        JSONObject object = new JSONObject(json);
                        JSONArray array = object.getJSONArray("items");
                        for (int i = 0; i < array.length(); i++) {
                            Livro book = new Livro();
                            JSONObject item = array.getJSONObject(i);

                            JSONObject volumeInfo = item.getJSONObject("volumeInfo");

                            String title = volumeInfo.getString("title");
                            book.setNome(title);
                            String editora = volumeInfo.getString("publisher");
                            book.setEditora(editora);
                            JSONArray authors = volumeInfo.getJSONArray("authors");
                            String author = authors.getString(0);
                            book.setAutor(author);
                            JSONObject imageLinks = volumeInfo.getJSONObject("imageLinks");
                            String imageLink = imageLinks.getString("smallThumbnail");
                            book.setImage_url(imageLink);
                            livros.add(book);
                            Log.d("TAG", book.getNome()+" " + book.getAutor());
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                }

            });

        }else{
            Toast.makeText(CadastroLivroActivity.this, "Campo Vazio", Toast.LENGTH_SHORT).show();
        }

        return livros;
    }




}

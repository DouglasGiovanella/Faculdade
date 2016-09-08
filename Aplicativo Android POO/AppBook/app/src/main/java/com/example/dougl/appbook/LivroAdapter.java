package com.example.dougl.appbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dougl on 07/09/2016.
 */
public class LivroAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Livro> lista;

    public LivroAdapter(Context context, ArrayList<Livro> lista){
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Livro livro = lista.get(position);
        View layout;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layout = inflater.inflate(R.layout.lista_livros, null);
        }else{
            layout = convertView;
        }

        TextView nome = (TextView) layout.findViewById(R.id.nomeLivro);
        nome.setText(livro.getNome());

        TextView autor = (TextView) layout.findViewById(R.id.autorLivro);
        autor.setText(livro.getAutor());

        ImageView imageView = (ImageView) layout.findViewById(R.id.imagemLista);
        Picasso.with(context).load(livro.getImage_url()).resize(80,120).into(imageView);

        return layout;
    }
}

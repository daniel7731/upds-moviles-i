package com.daniel.list2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.daniel.list2.Elemento;
import com.daniel.list2.R;

import java.util.ArrayList;

public class ElementAdapter extends ArrayAdapter<Elemento> {
    private ArrayList<Elemento> listado;
    private AppCompatActivity appCompatActivity;

    public void setListado(ArrayList<Elemento> listado) {
        this.listado = listado;
    }

    public ArrayList<Elemento> getListado() {
        return listado;
    }

    public ElementAdapter(@NonNull AppCompatActivity context, ArrayList<Elemento> listado) {
        super(context, R.layout.elemento,listado);
        this.appCompatActivity = context;
        this.listado=listado;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = appCompatActivity.getLayoutInflater();
        View item = inflater.inflate(R.layout.elemento, null);

        TextView textView1 = item.findViewById(R.id.stitulo);
        textView1.setText(listado.get(position).titulo);

        TextView textView2 = item.findViewById(R.id.ssubtitulo);
        textView2.setText(listado.get(position).subTitulo);
        return(item);
    }
}

package com.utad.danieliglesia.milib.Fragments;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.utad.danieliglesia.milib.R;

import java.util.ArrayList;

/**
 * Created by daniel.iglesia on 18/12/2017.
 */

public class ListaAndroidAdapter extends RecyclerView.Adapter<AndroidViewHolder>{

    private ArrayList<String> lista;

    public ListaAndroidAdapter(ArrayList<String> lista){
    this.lista=lista;
    }

    @Override
    public AndroidViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.celda_android_layout,null);
        AndroidViewHolder androidViewHolder=new AndroidViewHolder(view);
        return androidViewHolder;
    }

    @Override
    public void onBindViewHolder(AndroidViewHolder holder, int position) {
        holder.textoAndroid.setText(lista.get(position));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
class AndroidViewHolder extends ViewHolder{

    public TextView textoAndroid;


    public AndroidViewHolder(View itemView) {

        super(itemView);
        textoAndroid=itemView.findViewById(R.id.textoAndroid);
    }
}
package com.utad.danieliglesia.milib.Fragments;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by daniel.iglesia on 18/12/2017.
 */

public class ListaAndroidAdapter extends RecyclerView.Adapter<AndroidViewHolder>{

    @Override
    public AndroidViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(AndroidViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
class AndroidViewHolder extends ViewHolder{

    public AndroidViewHolder(View itemView) {
        super(itemView);
    }
}
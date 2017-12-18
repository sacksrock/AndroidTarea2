package com.utad.danieliglesia.milib.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.utad.danieliglesia.milib.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaAndroidFragment extends Fragment {
    public RecyclerView recyclerView;

    public ListaAndroidFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_lista_android, container, false);
        recyclerView= v.findViewById(R.id.listaandroid);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        


        return v;
    }

}

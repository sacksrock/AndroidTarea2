package com.utad.danieliglesia.activity2;

/**
 * Created by daniel.iglesia on 18/12/2017.
 */
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;


        //import com.google.android.gms.common.data.DataHolder;
        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.GenericTypeIndicator;
        import com.utad.danieliglesia.activity2.Adapters.ListaCochesAdapter;
        import com.utad.danieliglesia.activity2.Adapters.ListaMensajesAdapter;
        import com.utad.danieliglesia.activity2.Objets.Coche;
        import com.utad.danieliglesia.activity2.Objets.Mensaje;
        import com.utad.danieliglesia.milib.Fragments.ListaFragment;


        import java.util.ArrayList;


public class SecondActivity extends AppCompatActivity {

    ListaFragment listaMensajesFragment,ListaFragmentCoches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_second);

        SecondActivityEvents Events = new SecondActivityEvents(this);
        DataHolder.instance.firebaseAdmin.setListener(Events);

        listaMensajesFragment = (ListaFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentListaMensajes);
        ListaFragmentCoches = (ListaFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentListCoches);

        DataHolder.instance.firebaseAdmin.Rama("Coches");

        ArrayList<String> mdatos= new ArrayList<>();


        ListaMensajesAdapter listaMensajesAdapter = new ListaMensajesAdapter(mdatos);

        listaMensajesFragment.recyclerView.setAdapter(listaMensajesAdapter);
    }
}

class SecondActivityEvents implements FirebaseAdminListener {

    SecondActivity secondActivity;

    public SecondActivityEvents(SecondActivity secondActivity){
        this.secondActivity = secondActivity;
    }


    @Override
    public void Rama (String rama, DataSnapshot dataSnapshot) {
        if(rama.equals("Coches")){
            GenericTypeIndicator<ArrayList<Coche>> indicator = new GenericTypeIndicator<ArrayList<Coche>>(){};
            ArrayList<Coche> coches = dataSnapshot.getValue(indicator);
            ListaCochesAdapter listaCochesAdapter = new ListaCochesAdapter(coches,secondActivity);
            secondActivity.ListaFragmentCoches.recyclerView.setAdapter(listaCochesAdapter);
        }
    }
    @Override
    public void registerFirebase(Boolean ok) {

    }
    @Override
    public void loginFirebase(Boolean ok) {

    }
}
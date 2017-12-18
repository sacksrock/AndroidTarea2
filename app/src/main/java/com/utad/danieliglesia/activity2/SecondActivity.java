package com.utad.danieliglesia.activity2;

/**
 * Created by daniel.iglesia on 18/12/2017.
 */
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;


        import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListaFragment listaMensajesFragment,ListaFragmentCoches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        SecondActivityEvents events = new SecondActivityEvents(this);
        DataHolder.instance.fireBaseAdmin.setListener(events);

        listaMensajesFragment = (ListaFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentListaMensajes);
        ListaFragmentCoches = (ListaFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentListCoches);

        DataHolder.instance.fireBaseAdmin.descargarYObservarRama("Coches");

        ArrayList<String> mdatos= new ArrayList<>();


        ListaMensajesAdapter listaMensajesAdapter = new ListaMensajesAdapter(mdatos);

        listaMensajesFragment.recyclerView.setAdapter(listaMensajesAdapter);
    }
}

class SecondActivityEvents implements FireBaseAdminListener{

    SecondActivity secondActivity;

    public SecondActivityEvents(SecondActivity secondActivity){
        this.secondActivity = secondActivity;
    }

    @Override
    public void FireBaseAdmin_RamaDescargada(String rama, DataSnapshot dataSnapshot) {
        if(rama.equals("Coches")){
            GenericTypeIndicator<ArrayList<FBCoche>> indicator = new GenericTypeIndicator<ArrayList<FBCoche>>(){};
            ArrayList<FBCoche> coches = dataSnapshot.getValue(indicator);
            ListaCochesAdapter listaCochesAdapter = new ListaCochesAdapter(coches,secondActivity);
            secondActivity.ListaFragmentCoches.recyclerView.setAdapter(listaCochesAdapter);
        }
    }



    @Override
    public void FireBaseAdmin_RegisterOk(Boolean ok) {

    }

    @Override
    public void FireBaseAdmin_LoginOk(Boolean ok) {

    }
}

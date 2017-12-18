package com.utad.danieliglesia.activity2;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



import com.google.firebase.database.DataSnapshot;
import com.utad.danieliglesia.milib.Fragments.LoginFragment;
import com.utad.danieliglesia.milib.Fragments.LoginFragmentListener;
import com.utad.danieliglesia.milib.Fragments.RegisterFragment;
import com.utad.danieliglesia.milib.Fragments.RegisterFragmentListener;

public class MainActivity extends AppCompatActivity {

    LoginFragment loginFragment;
    RegisterFragment registerFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inicializado el fragment del Login
        loginFragment = (LoginFragment)getSupportFragmentManager().findFragmentById(R.id.loginFragment);
        registerFragment = (RegisterFragment) getSupportFragmentManager().findFragmentById(R.id.registerFragment);

        MainActivityEvents mainActivityEvents = new MainActivityEvents(this);


        loginFragment.setListener(mainActivityEvents);
        registerFragment.setListener(mainActivityEvents);
        DataHolder.instance.firebaseAdmin.setListener((FirebaseAdminListener) mainActivityEvents);

        FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
        transition.show(loginFragment);
        transition.hide(registerFragment);
        transition.commit();



    }
}

class MainActivityEvents implements LoginFragmentListener, RegisterFragmentListener, FirebaseAdminListener{
    MainActivity mainActivity;
    public MainActivityEvents(MainActivity mainActivity){
        this.mainActivity=mainActivity;
    }

    @Override
    public void OnLoginClicked(String sUser, String sPass) {
        DataHolder.instance.firebaseAdmin.login(sUser,sPass,mainActivity);
    }

    @Override
    public void OnRegisterClicked() {
        FragmentTransaction transition = mainActivity.getSupportFragmentManager().beginTransaction();
        transition.hide(mainActivity.loginFragment);
        transition.show(mainActivity.registerFragment);
        transition.commit();

    }

    @Override
    public void OnAceptarClicked(String sUser, String sPass) {
        DataHolder.instance.firebaseAdmin.singIn(sUser,sPass,mainActivity);
    }

    @Override
    public void OnCancelarClicked() {
        FragmentTransaction transition = mainActivity.getSupportFragmentManager().beginTransaction();
        transition.show(mainActivity.loginFragment);
        transition.hide(mainActivity.registerFragment);
        transition.commit();

    }

    @Override
    public void registerFirebase(Boolean ok) {
        if(ok){
            Intent intent = new Intent(mainActivity,SecondActivity.class);
            mainActivity.startActivity(intent);
            mainActivity.finish();
        }
        else{

        }

    }

    @Override
    public void loginFirebase(Boolean ok) {
        if(ok){
            Intent intent = new Intent(mainActivity,SecondActivity.class);
            mainActivity.startActivity(intent);
            mainActivity.finish();
        }
        else{

        }
    }

    @Override
    public void Rama(String rama, DataSnapshot dataSnapshot) {

    }


}
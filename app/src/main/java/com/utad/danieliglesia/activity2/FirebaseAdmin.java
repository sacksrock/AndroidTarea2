package com.utad.danieliglesia.activity2;

/**
 * Created by daniel.iglesia on 30/11/2017.
 */

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by sergioredondo on 24/11/17.
 */

public class FirebaseAdmin {
    private FirebaseAuth mAuth;
    public FirebaseUser user;
    FirebaseAdminListener listener;
    FirebaseDatabase database;
    DatabaseReference myRefRaiz;


    public FirebaseAdmin(){
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        myRefRaiz = database.getReference();
    }
    public void setListener(FirebaseAdminListener listener) {

        this.listener = listener;
    }

    public void login(String email, String pass, Activity activity){
        mAuth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("FirebaseAdmin", "createUserWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (task.isSuccessful()) {
                            user = FirebaseAuth.getInstance().getCurrentUser();
                            listener.loginFirebase(true);
                        }
                        else{
                            listener.loginFirebase(false);
                        }

                        // ...
                    }
                });
    }
    public void singIn(String email, String pass, Activity activity){
        mAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("FirebaseAdmin", "createUserWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (task.isSuccessful()) {
                            user = FirebaseAuth.getInstance().getCurrentUser();
                            listener.registerFirebase(true);
                        }
                        else{
                            listener.registerFirebase(false);
                        }

                        // ...
                    }
                });
    }
    public void Rama(final String rama){
        DatabaseReference refRama= myRefRaiz.child(rama);
        refRama.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                listener.Rama(rama,dataSnapshot);
                //.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                listener.Rama(rama,null);

                // Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }
}
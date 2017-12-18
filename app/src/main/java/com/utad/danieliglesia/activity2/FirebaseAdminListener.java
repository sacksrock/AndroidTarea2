package com.utad.danieliglesia.activity2;

import com.google.firebase.database.DataSnapshot;

/**
 * Created by daniel.iglesia on 30/11/2017.
 */

public interface FirebaseAdminListener {
    public void registerFirebase(Boolean ok);
    public void loginFirebase(Boolean ok);
    public void Rama(String rama,DataSnapshot dataSnapshot);
}

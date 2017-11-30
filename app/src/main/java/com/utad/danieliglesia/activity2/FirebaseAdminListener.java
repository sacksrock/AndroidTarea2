package com.utad.danieliglesia.activity2;

/**
 * Created by daniel.iglesia on 30/11/2017.
 */

public interface FirebaseAdminListener {
    public void registerFirebase(String emailAddress, String password);
    public void loginFirebase(String emailAddress, String password);
}

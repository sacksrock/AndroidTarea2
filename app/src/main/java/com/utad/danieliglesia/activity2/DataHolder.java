package com.utad.danieliglesia.activity2;

/**
 * Created by daniel.iglesia on 18/12/2017.
 */

public class DataHolder {
        public static DataHolder instance= new DataHolder();

        public FirebaseAdmin firebaseAdmin;
        public DataHolder() {
            firebaseAdmin = new FirebaseAdmin();
        }
}

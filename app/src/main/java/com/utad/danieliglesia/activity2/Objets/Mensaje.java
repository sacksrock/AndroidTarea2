package com.utad.danieliglesia.activity2.Objets;
import com.google.firebase.database.IgnoreExtraProperties;
/**
 * Created by daniel.iglesia on 18/12/2017.
 */
@IgnoreExtraProperties
public class Mensaje {
        public String original;

        public Mensaje(){

        }

        public Mensaje(String original){
            this.original = original;
        }
}

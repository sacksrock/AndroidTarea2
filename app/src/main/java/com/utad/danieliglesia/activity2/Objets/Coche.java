package com.utad.danieliglesia.activity2.Objets;
import com.google.firebase.database.IgnoreExtraProperties;
/**
 * Created by daniel.iglesia on 18/12/2017.
 */
@IgnoreExtraProperties
public class Coche {

    public int Fabricado;
    public String Marca;
    public String Nombre;
    public double lat;
    public double lon;
    public String imgurl;




    public Coche(){

    }

    public Coche(int fabricado, String marca, String nombre, double lat, double lon,String imgurl) {
        this.Fabricado = fabricado;
        this.Marca = marca;
        this.Nombre = nombre;
        this.lat = lat;
        this.lon = lon;
        this.imgurl = imgurl;
    }
}

package ila.fr.dao;

/**
 * Created by gbrossault on 16/03/18.
 */

public class Site {


    private int id;
    private String nom;
    private float latitude;
    private float longitude;

    public Site(){
    }

    public Site(int id, String nom, float latitude, float longitude){
        this.id = id;
        this.nom = nom;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

}

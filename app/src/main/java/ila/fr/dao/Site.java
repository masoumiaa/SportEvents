package ila.fr.dao;

public class Site {


    private int id;
    private String nom;
    private double latitude;
    private double longitude;

    public Site(){
    }

    public Site(int id, String nom, double latitude, double longitude){
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

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

}

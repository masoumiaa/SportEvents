package ila.fr.sportevents.DAO;

/**
 * Created by aminesoumiaa on 08/02/18.
 */

class Address {
    private int id;
    private String longitude;
    private String latitude;

    public Address(String longitude, String latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}

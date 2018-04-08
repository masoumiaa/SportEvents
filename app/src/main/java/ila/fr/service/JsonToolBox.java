package ila.fr.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ila.fr.dao.Site;

public class JsonToolBox {

    private static final String JSON_RECORDS = "records";
    private static final String JSON_FIELDS = "fields";
    private static final String JSON_ID_SITE = "id_site";
    private static final String JSON_NOM_SITE = "nom_org_principal";
    private static final String JSON_LOCATION = "geo_point_2d";
    private static final int JSON_LATITUDE = 0;
    private static final int JSON_LONGITUDE = 1;

    public static List<Site> getSitesFromJSON(JSONObject jsonObject){
        List<Site> sites = new ArrayList<>();
        try {
            JSONArray records =  jsonObject.getJSONArray(JSON_RECORDS);
            for(int i = 0; i<records.length(); i++){
                System.out.println("new site");
                JSONObject record = records.getJSONObject(i);
                JSONObject fields = record.getJSONObject(JSON_FIELDS);
                int id = fields.getInt(JSON_ID_SITE);
                String name = fields.getString(JSON_NOM_SITE);

                JSONArray location = fields.getJSONArray(JSON_LOCATION);
                Double latitude = location.getDouble(JSON_LATITUDE);
                Double longitude = location.getDouble(JSON_LONGITUDE);

                Site site = new Site(id, name, latitude, longitude);
                sites.add(site);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sites;
    }
}

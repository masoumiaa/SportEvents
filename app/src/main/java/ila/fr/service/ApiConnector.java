package ila.fr.service;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import ila.fr.dao.Site;

/**
 * Created by gbrossault on 16/03/18.
 */

public class ApiConnector {

    private final String url = "https://data.rennesmetropole.fr/api/records/1.0/search//?dataset=sites_organismes_sites&facet=nom_site&facet=nom_org_principal&facet=nom_specialite_principale&facet=geo_point_2d&refine.nom_theme_principal=Sport";
    private List<Site> sites;

    RequestQueue requestQueue;

    public ApiConnector(Context context){
        requestQueue = Volley.newRequestQueue(context);
        sites = new ArrayList<>();
    }

    public List<Site> getSites(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, this.url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                extractSites(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //set action on error response
            }
        });
        return sites;
    }

    private void extractSites(JSONObject jsonObject){
        if(jsonObject.length() != 0){
            this.sites = JsonToolBox.getSitesFromJSON(jsonObject);
        }
    }

}

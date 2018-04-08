package ila.fr.service;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ila.fr.dao.Site;

public class ApiConnector {

    /**
     * Exemple of use :
     *    ApiConnector api = new ApiConnector(getApplicationContext());
     *    List<Site> sites = null;
     *    try {
     *      api.getSitesFromApi(getApplicationContext());
     *      sites = api.getSites();
     *    } catch (IOException e) {
     *      e.printStackTrace();
     *    }
     */

    private final String url = "https://data.rennesmetropole.fr/api/records/1.0/search//?dataset=sites_organismes_sites&facet=nom_site&facet=nom_org_principal&facet=nom_specialite_principale&facet=geo_point_2d&refine.nom_theme_principal=Sport";
    private List<Site> sites;

    RequestQueue requestQueue;

    public ApiConnector(Context context){
        requestQueue = Volley.newRequestQueue(context);
        sites = new ArrayList<>();
    }

    public void getSitesFromApi(final Context context) throws IOException {
        System.out.println("url : "+url);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, this.url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if(response.length() != 0){
                    List<Site> sites = JsonToolBox.getSitesFromJSON(response);
                    setSites(sites);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.err.println(error.getLocalizedMessage());
            }
        });
        requestQueue.add(jsonObjectRequest);
    }


    public List<Site> getSites() {
        return sites;
    }

    public void setSites(List<Site> sites) {
        this.sites = sites;
    }
}

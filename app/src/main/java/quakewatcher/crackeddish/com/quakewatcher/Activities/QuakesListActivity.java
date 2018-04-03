package quakewatcher.crackeddish.com.quakewatcher.Activities;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import quakewatcher.crackeddish.com.quakewatcher.Model.EarthQuake;
import quakewatcher.crackeddish.com.quakewatcher.R;
import quakewatcher.crackeddish.com.quakewatcher.Util.Constants;

public class QuakesListActivity extends AppCompatActivity {

    private ArrayList<String> arrayList;
    private ListView listView;
    private RequestQueue queue;
    private ArrayAdapter arrayAdapter;

    private List<EarthQuake> quakeList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quakes_list);
        quakeList=new ArrayList<>();
        listView=(ListView)findViewById(R.id.listView);
        queue= Volley.newRequestQueue(this);
        arrayList=new ArrayList<>();
        getAllQuakes(Constants.URL);
    }
    void getAllQuakes(String url){
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                EarthQuake earthQuake=new EarthQuake();
                try {
                    JSONArray jsonArray=response.getJSONArray("features");
                    int limit=Constants.LIMIT;
                    if (jsonArray.length()<limit)
                        limit=jsonArray.length();
                    for (int i=0;i<limit;i++){
                        JSONObject properties=jsonArray.getJSONObject(i).getJSONObject("properties");
                        //get geometry object
                        JSONObject geometry=jsonArray.getJSONObject(i).getJSONObject("geometry");
                        JSONArray coordinates=geometry.getJSONArray("coordinates");
                        double lon=coordinates.getDouble(0);
                        double lat=coordinates.getDouble(1);
                        earthQuake.setPlace(properties.getString("place"));
                        earthQuake.setType(properties.getString("type"));
                        earthQuake.setTime(properties.getLong("time"));
                        earthQuake.setLat(lat);
                        earthQuake.setLon(lon);
                        arrayList.add(earthQuake.getPlace());

                    }
                    arrayAdapter=new ArrayAdapter<>(QuakesListActivity.this,android.R.layout.simple_list_item_1
                    ,android.R.id.text1,arrayList);
                    listView.setAdapter(arrayAdapter);

                    arrayAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(jsonObjectRequest);
    }
}

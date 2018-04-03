package jsonarrayrequest.crackeddish.com.jsonarrayrequest;

import android.app.DownloadManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private final static String URL="https://bittrex.com/api/v1.1/public/getmarkets";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RequestQueue queue= Volley.newRequestQueue(this);
        JsonObjectRequest obj=new JsonObjectRequest(Request.Method.GET, URL, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                    try {
                        JSONArray cryptoObject=response.getJSONArray("result");

                        for (int i=0;i<cryptoObject.length();i++){
                            JSONObject currency=cryptoObject.getJSONObject(i);
                            Log.d("Currency",currency.getString("MarketCurrencyLong"));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

//                Log.d("Response1:",response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Error1",error.getMessage());
            }
        });
//        JsonArrayRequest arrayRequest=new JsonArrayRequest(Request.Method.GET, URL, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                VolleyLog.d("Response2",response.toString());
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                VolleyLog.d("Erro2r",error.getMessage());
//            }
//        });
        queue.add(obj);
    }
}

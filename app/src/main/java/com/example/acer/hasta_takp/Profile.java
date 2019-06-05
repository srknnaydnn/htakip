package com.example.acer.hasta_takp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.acer.hasta_takp.api.JsonObjectRequest;
import com.example.acer.hasta_takp.api.MySingleton;

import org.json.JSONException;
import org.json.JSONObject;

public class Profile extends AppCompatActivity {


    TextView userName,userTc;
    TextView userSurname;
    TextView userType;
    String tc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        userTc = findViewById(R.id.tc_no);
        userName = findViewById(R.id.name);
        userSurname = findViewById(R.id.surname);
        userType = findViewById(R.id.type);


        Bundle bundle =getIntent().getExtras();
        tc= bundle.getString("id");

        String url="http://htakip.dx.am/database/show.php?tc="+tc;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                 Request.Method.GET, url,null,
                 new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {

                            userTc.setText(response.getString("tc"));
                            userName.setText(response.getString("name"));
                            userSurname.setText(response.getString("surname"));
                            userType.setText(response.getString("department"));
                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(jsonObjectRequest);
        }

    }




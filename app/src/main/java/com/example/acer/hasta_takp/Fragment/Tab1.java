package com.example.acer.hasta_takp.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.acer.hasta_takp.R;
import com.example.acer.hasta_takp.api.JsonObjectRequest;
import com.example.acer.hasta_takp.api.MySingleton;

import org.json.JSONException;
import org.json.JSONObject;

public class Tab1 extends Fragment {
    View view;
    TextView user_tc,user_name, user_surname,user_age,user_length,user_weight,user_gender,user_blood,user_tel;
    Intent ıntent;
    Context context;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        view=inflater.inflate(R.layout.fragment_tab1,container,false);
        user_tc=view.findViewById(R.id.tc_no);
        user_name=view.findViewById(R.id.name);
        user_surname=view.findViewById(R.id.surname);
        user_gender=view.findViewById(R.id.gender);
        user_blood=view.findViewById(R.id.blood_group);
        user_tel=view.findViewById(R.id.tel);

        Bundle bundle=this.getArguments();
        if(bundle !=null) {
            final String _tc = bundle.getString("tc");


            String url = "http://htakip.dx.am/database/hgoster.php?tc=" + _tc;
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {

                            try {
                                user_tc.setText(response.getString("tc"));
                                user_name.setText(response.getString("name"));
                                user_surname.setText(response.getString("surname"));
                                user_gender.setText(response.getString("gender"));
                                user_blood.setText(response.getString("blood_group"));
                                user_tel.setText(response.getString("telephone"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            MySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
        }
            return view;
    }
}
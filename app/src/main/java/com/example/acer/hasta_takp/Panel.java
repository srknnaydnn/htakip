package com.example.acer.hasta_takp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.acer.hasta_takp.api.Adapter;
import com.example.acer.hasta_takp.Model.panelModel;
import com.example.acer.hasta_takp.api.MySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Panel extends AppCompatActivity {

   List<panelModel> list;
   Adapter adapter;
   panelModel model;
   ListView liste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.panel);
       liste=findViewById(R.id.patientList);

          }

    }


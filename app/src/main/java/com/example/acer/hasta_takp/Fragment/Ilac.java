package com.example.acer.hasta_takp.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.acer.hasta_takp.Model.İlacModel;
import com.example.acer.hasta_takp.R;
import com.example.acer.hasta_takp.api.MySingleton;
import com.example.acer.hasta_takp.api.İlacAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ilac extends Fragment{

    View view;
    ListView _ilacList;
    EditText ilacAd,_day,_date,_total;
    Button ekle;
    String ilac,gun,tarih,toplam,tc;
    List<İlacModel> list;
    İlacModel ilacModel;
    İlacAdapter ilacAdapter;
    Context context;
    Calendar calendar;
    StringBuilder stringBuilder;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.ilac,container,false);

        _ilacList=view.findViewById(R.id.ilacList);
         ilacAd=view.findViewById(R.id.ilac_ad);
        _date=view.findViewById(R.id.date);
        _day=view.findViewById(R.id.day);
        _total=view.findViewById(R.id.total);
         ekle=view.findViewById(R.id.ekle);


         stringBuilder=new StringBuilder();
         _date.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
                 _date.setText(currentDateTimeString);
             }
         });

        getMedicine();
        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ilac=ilacAd.getText().toString();
                tarih=_date.getText().toString();
                toplam=_total.getText().toString();
                gun=_day.getText().toString();

                add();

                if(!ilac.isEmpty() && !tarih.isEmpty() && !toplam.isEmpty() && !gun.isEmpty())
                {
                    list = new ArrayList<>();
                    ilacModel = new İlacModel(ilac, tarih, toplam, gun);
                    list.add(ilacModel);
                    ilacAdapter = new İlacAdapter(list, getContext());
                    _ilacList.setAdapter(ilacAdapter);

                    ilacAd.setText("");
                    _date.setText("");
                    _day.setText("");
                    _total.setText("");
                }
                else {
                    Toast.makeText(getContext(), "Boş Alanları Doldurun..", Toast.LENGTH_LONG).show();
                }
            }
        });


        return view;
    }

    public void add(){
        if(getArguments() !=null) {
            final String _tc = getArguments().getString("tc");
            String url = "http://htakip.dx.am/database/medicin.php";
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    getMedicine();

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    Toast.makeText(getContext(), "hata" + error, Toast.LENGTH_LONG);
                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String, String> params = new HashMap<String, String>();
                    params.put("medicine_name", ilac);
                    params.put("_date", tarih);
                    params.put("_day", gun);
                    params.put("total", toplam);
                    params.put("patient_tc", _tc);
                    return params;
                }
            };

            MySingleton.getInstance(context).addToRequestQueue(stringRequest);
        }
    }
    public void getMedicine() {


        if(getArguments() !=null){
            final String _tc = getArguments().getString("tc").toString();
        String url1 = "http://htakip.dx.am/database/mshow.php?patient_tc=" + _tc;
        StringRequest request = new StringRequest(Request.Method.GET, url1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject obj = new JSONObject(response);
                    JSONArray jsonArray = obj.getJSONArray("person");
                    list=new ArrayList<>();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        ilacModel = new İlacModel(jsonObject.getString("medicine_name"), jsonObject.getString("_date"),
                                jsonObject.getString("_day"), jsonObject.getString("total"));
                        list.add(ilacModel);
                    }
                    ilacAdapter = new İlacAdapter(list, getContext());
                    _ilacList.setAdapter(ilacAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getContext(), "error" + error, Toast.LENGTH_SHORT).show();
            }
        });
        MySingleton.getInstance(context).addToRequestQueue(request);
        }
    }
}



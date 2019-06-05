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
import com.example.acer.hasta_takp.Model.HastaModel;
import com.example.acer.hasta_takp.Model.İlacModel;
import com.example.acer.hasta_takp.R;
import com.example.acer.hasta_takp.api.HastaAdapter;
import com.example.acer.hasta_takp.api.MySingleton;
import com.example.acer.hasta_takp.api.İlacAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tab3 extends Fragment {
    View view;
    EditText ates,nabiz,solunum,tansiyon,kan_sekeri,idrar,beslenme,saat;
    ListView list;
    Button ekle;
    HastaAdapter hastaAdapter;
    HastaModel hastaModel;
    List<HastaModel> hastaModelList;
    String _ates,_nabiz,_solunum,_tansiyon,_kan_sekeri,_idrar,_beslenme,_saat;
    Context context;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view=inflater.inflate(R.layout.fragment_tab3,container,false);

        list=view.findViewById(R.id.hastaList);
        ates=view.findViewById(R.id._ates);
        nabiz=view.findViewById(R.id._nabiz);
        solunum=view.findViewById(R.id._solunum);
        tansiyon=view.findViewById(R.id._tansiyon);
        kan_sekeri=view.findViewById(R.id._kan_sekeri);
        idrar=view.findViewById(R.id._idrar);
        beslenme=view.findViewById(R.id._beslenme);
        saat=view.findViewById(R.id.saat);
        ekle=view.findViewById(R.id.h_ekle);

        saat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
                saat.setText(currentDateTimeString);
            }
        });

        getPatient();
        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _ates=ates.getText().toString();
                _nabiz=nabiz.getText().toString();
                _solunum=solunum.getText().toString();
                _tansiyon=tansiyon.getText().toString();
                _kan_sekeri=kan_sekeri.getText().toString();
                _idrar=idrar.getText().toString();
                _beslenme=beslenme.getText().toString();
                _saat=saat.getText().toString();

                add();

                if(!_ates.isEmpty() && !_nabiz.isEmpty() && !_solunum.isEmpty() && !_tansiyon.isEmpty() && !_kan_sekeri.isEmpty()
                        && !_idrar.isEmpty() && !_beslenme.isEmpty() && !_saat.isEmpty() )
                {
                hastaModelList=new ArrayList<>();
                hastaModel=new HastaModel(_ates,_nabiz,_solunum,_tansiyon,_kan_sekeri,_idrar,_beslenme,_saat);
                hastaModelList.add(hastaModel);
                hastaAdapter=new HastaAdapter(hastaModelList,getContext());
                list.setAdapter(hastaAdapter);
                    ates.setText("");
                    solunum.setText("");
                    nabiz.setText("");
                    tansiyon.setText("");
                    kan_sekeri.setText("");
                    idrar.setText("");
                    beslenme.setText("");
                    saat.setText("");
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
            String url = "http://htakip.dx.am/database/follow.php";
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    getPatient();

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
                    params.put("ateş",_ates);
                    params.put("nabız", _nabiz);
                    params.put("solunum", _solunum);
                    params.put("tansiyon", _tansiyon);
                    params.put("kan", _kan_sekeri);
                    params.put("idrar", _idrar);
                    params.put("beslenme", _beslenme);
                    params.put("tarih", _saat);
                    params.put("tc", _tc);
                    return params;
                }
            };

            MySingleton.getInstance(context).addToRequestQueue(stringRequest);
        }
    }
    public void getPatient() {


        if(getArguments() !=null){
            final String _tc = getArguments().getString("tc").toString();
            String url1 = "http://htakip.dx.am/database/fshow.php?tc=" + _tc;
            StringRequest request = new StringRequest(Request.Method.GET, url1, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    try {
                        JSONObject obj = new JSONObject(response);
                        JSONArray jsonArray = obj.getJSONArray("person");
                        hastaModelList=new ArrayList<>();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            hastaModel = new HastaModel(jsonObject.getString("ateş"), jsonObject.getString("nabız"),
                                    jsonObject.getString("solunum"), jsonObject.getString("tansiyon"),jsonObject.getString("kan"),
                                    jsonObject.getString("idrar"),jsonObject.getString("beslenme"),jsonObject.getString("tarih"));
                            hastaModelList.add(hastaModel);
                        }
                        hastaAdapter = new HastaAdapter(hastaModelList, getContext());
                        list.setAdapter(hastaAdapter);
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

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
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.acer.hasta_takp.R;
import com.example.acer.hasta_takp.api.MySingleton;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Nurse extends Fragment {

View view;
EditText date,name,surname,message;
String nurse_tarih,nurse_name,nurse_message,nurse_surname;
Button gonder;
Context context;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_nurse,container,false);

      date=view.findViewById(R.id.getDate);
      name=view.findViewById(R.id.getName);
      surname=view.findViewById(R.id.getSurname);
      message=view.findViewById(R.id.getMessage);
      gonder=view.findViewById(R.id.send);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
                date.setText(currentDateTimeString);
            }
        });
        gonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                message();
                if(!nurse_tarih.isEmpty() && !nurse_name.isEmpty() && !nurse_surname.isEmpty() && !nurse_message.isEmpty())
                {
                    date.setText("");
                    name.setText("");
                    surname.setText("");
                    message.setText("");
                }
                else
                {
                    Toast.makeText(getContext(), "boş alanları doldurun", Toast.LENGTH_SHORT).show();
                }
           }
        });
        return view;
   }

   public  void message(){

       if(getArguments() !=null) {
           nurse_tarih=date.getText().toString();
           nurse_name=name.getText().toString();
           nurse_surname=surname.getText().toString();
           nurse_message=message.getText().toString();
           final String _tc = getArguments().getString("tc");
           String url = "http://htakip.dx.am/database/nurse.php";
           StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
               @Override
               public void onResponse(String response) {

                   Toast.makeText(getContext(), response, Toast.LENGTH_LONG);


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
                   params.put("date",nurse_tarih);
                   params.put("name", nurse_name);
                   params.put("surname", nurse_surname);
                   params.put("message", nurse_message);
                   params.put("tc", _tc);
                   return params;
               }
           };
           MySingleton.getInstance(context).addToRequestQueue(stringRequest);
       }
   }
}

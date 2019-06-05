package com.example.acer.hasta_takp.Fragment;

import android.app.DownloadManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.acer.hasta_takp.Model.MessageModel;
import com.example.acer.hasta_takp.R;
import com.example.acer.hasta_takp.api.JsonObjectRequest;
import com.example.acer.hasta_takp.api.MessageAdapter;
import com.example.acer.hasta_takp.api.MySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Message extends Fragment {

View view;
ListView mesajList;
MessageAdapter messageAdapter;
MessageModel messageModel;
List<MessageModel> list;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.activity_message,container,false);


        mesajList=view.findViewById(R.id.mesaj_list);
        if(getArguments() !=null)
        {


            final  String tc=getArguments().getString("tc");
            String url="http://htakip.dx.am/database/message.php?tc="+tc;

            StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {
                    JSONObject jsonObject= null;
                    try {
                        jsonObject = new JSONObject(response);
                        JSONArray jsonArray=jsonObject.getJSONArray("person");
                        list=new ArrayList<>();
                        for (int i=0; i<jsonArray.length();i++){

                            JSONObject object=jsonArray.getJSONObject(i);
                            messageModel=new MessageModel(object.getString("date"),object.getString("message"));
                            list.add(messageModel);
                        }
                        messageAdapter=new MessageAdapter(list,getContext());
                        mesajList.setAdapter(messageAdapter);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    Toast.makeText(getContext(), "hata"+error, Toast.LENGTH_SHORT).show();
                }
            });

            MySingleton.getInstance(getContext()).addToRequestQueue(stringRequest);
        }


        return view;
    }
}

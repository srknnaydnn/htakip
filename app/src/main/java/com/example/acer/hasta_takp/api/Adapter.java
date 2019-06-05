package com.example.acer.hasta_takp.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.acer.hasta_takp.Model.panelModel;
import com.example.acer.hasta_takp.Patient;
import com.example.acer.hasta_takp.R;

import java.util.List;

public class Adapter extends BaseAdapter {

    List<panelModel> list;
    Context context;
    Activity activity;
    public Adapter(List<panelModel> list, Context context,Activity activity) {
        this.list = list;
        this.context = context;
        this.activity=activity;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.show,parent,false);
         final TextView room,tc,name,surname,department;
         LinearLayout showList;
         room=convertView.findViewById(R.id.room);
         tc=convertView.findViewById(R.id.tc);
         name=convertView.findViewById(R.id.name);
         surname=convertView.findViewById(R.id.surname);
         department=convertView.findViewById(R.id.department);
         showList=convertView.findViewById(R.id.showList);

        room.setText(""+list.get(position).getRoom());
        tc.setText(""+list.get(position).getTc());
        name.setText(list.get(position).getName());
        surname.setText(list.get(position).getSurname());
        department.setText(list.get(position).getDepartment());

        final String _tc= ""+list.get(position).getTc();


        showList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ıntent =new Intent(activity, Patient.class);
                ıntent.putExtra("tc",_tc);
                activity.startActivity(ıntent);
            }
        });


        return convertView;
    }
}

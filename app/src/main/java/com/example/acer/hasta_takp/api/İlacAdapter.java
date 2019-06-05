package com.example.acer.hasta_takp.api;

import android.content.Context;
import android.icu.util.Calendar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import com.example.acer.hasta_takp.Model.İlacModel;
import com.example.acer.hasta_takp.R;

import java.util.List;

import static com.example.acer.hasta_takp.R.id.tarih;

public class İlacAdapter extends BaseAdapter {

    List<İlacModel> list;
    Context context;
    public İlacAdapter(List<İlacModel> list, Context context) {
        this.list = list;
        this.context = context;
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
    public View getView(final int position, View convertView, ViewGroup parent) {

        convertView= LayoutInflater.from(context).inflate(R.layout.table,parent,false);

        final TextView ilac=convertView.findViewById(R.id.ilac);
        final TextView tarih=convertView.findViewById(R.id.tarih);
        final TextView gun=convertView.findViewById(R.id.gun);
        final TextView toplam=convertView.findViewById(R.id.toplam);


                ilac.setText(""+list.get(position).getIlac_adı());
                tarih.setText(""+list.get(position).getTarih());
                gun.setText(""+list.get(position).getGun());
                toplam.setText(""+list.get(position).getToplam());


        return convertView;
    }
}

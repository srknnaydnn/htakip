package com.example.acer.hasta_takp.api;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.acer.hasta_takp.Model.HastaModel;
import com.example.acer.hasta_takp.R;

import java.util.List;

public class HastaAdapter extends BaseAdapter {

    List<HastaModel> hastaModelList;
    Context context;

    public HastaAdapter(List<HastaModel> hastaModelList,Context context) {
        this.hastaModelList = hastaModelList;
        this.context=context;
    }

    @Override
    public int getCount() {
        return hastaModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return hastaModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView=LayoutInflater.from(context).inflate(R.layout.hasta_kontrol,parent,false);
        final TextView ates=convertView.findViewById(R.id.ates);
        final TextView nabız=convertView.findViewById(R.id.nabiz);
        final TextView solunum=convertView.findViewById(R.id.solunum);
        final TextView tansiyon=convertView.findViewById(R.id.tansiyon);
        final TextView kan_seker=convertView.findViewById(R.id.kan_seker);
        final TextView idrar=convertView.findViewById(R.id.idrar);
        final TextView beslenme=convertView.findViewById(R.id.beslenme);
        final TextView saat=convertView.findViewById(R.id.saat);

        ates.setText(hastaModelList.get(position).getAtes());
        nabız.setText(hastaModelList.get(position).getNabız());
        solunum.setText(hastaModelList.get(position).getSolunum());
        tansiyon.setText(hastaModelList.get(position).getTansiyon());
        kan_seker.setText(hastaModelList.get(position).getKan_sekeri());
        idrar.setText(hastaModelList.get(position).getIdrar());
        beslenme.setText(hastaModelList.get(position).getBeslenme());
        saat.setText(hastaModelList.get(position).getSaat());
        return convertView;
    }
}

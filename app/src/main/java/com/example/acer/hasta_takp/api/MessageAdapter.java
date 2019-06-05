package com.example.acer.hasta_takp.api;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.acer.hasta_takp.Model.MessageModel;
import com.example.acer.hasta_takp.R;

import java.util.List;

public class MessageAdapter extends BaseAdapter {

    private List<MessageModel> messageModels;
    Context context;
    Activity activity;

    public MessageAdapter(List<MessageModel> messageModels, Context context) {
        this.messageModels = messageModels;
        this.context = context;
    }
    @Override
    public int getCount() {
        return messageModels.size();
    }

    @Override
    public Object getItem(int position) {
        return messageModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView= LayoutInflater.from(context).inflate(R.layout.mesagge_show,parent,false);
        final TextView  mDate=convertView.findViewById(R.id.m_date);
        final TextView mMessage=convertView.findViewById(R.id.m_message);
        final LinearLayout message_show=convertView.findViewById(R.id.message_show);

        mDate.setText(messageModels.get(position).getTarih());
        mMessage.setText(messageModels.get(position).getMesaj());

        final String tarih=mDate.getText().toString();
        final String message=mMessage.getText().toString();

        message_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater layoutInflater = LayoutInflater.from(context);
               final View view2=layoutInflater.inflate(R.layout.message_alert,null);

                final TextView date=view2.findViewById(R.id.a_date);
                final TextView mesaj=view2.findViewById(R.id.a_message);
                final  TextView close=view2.findViewById(R.id.a_tamam);

                AlertDialog.Builder alert=new AlertDialog.Builder(context);
                alert.setView(view2);
                alert.setCancelable(false);
                final AlertDialog alertDialog=alert.create();
                date.setText(tarih);
                mesaj.setText(message);
                alertDialog.show();
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        alertDialog.cancel();
                    }
                });

            }
        });


        return convertView;
    }
    public void dialog()
    {



    }
}

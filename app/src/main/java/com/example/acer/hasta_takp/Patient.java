package com.example.acer.hasta_takp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.acer.hasta_takp.Fragment.Ilac;
import com.example.acer.hasta_takp.Fragment.Message;
import com.example.acer.hasta_takp.Fragment.Nurse;
import com.example.acer.hasta_takp.Fragment.Tab3;
import com.example.acer.hasta_takp.Fragment.Tab1;
import com.example.acer.hasta_takp.api.ViewPagerAdapter;


public class Patient extends AppCompatActivity {

    Toolbar toolbar;
    ViewPager viewPager;
    TabLayout tabLayout;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);


        toolbar=findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        tabLayout=findViewById(R.id.tab_layout);
        viewPager=findViewById(R.id.view_pager);
        viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        Bundle bundle=getIntent().getExtras();
        final  String tc=bundle.getString("tc").trim();

        Bundle args = new Bundle();
        args.putString("tc", tc);
        Tab1 tab1 = new Tab1();
        Ilac ılac=new Ilac();
        Tab3 tab3=new Tab3();
        Nurse nurse=new Nurse();
        Message message=new Message();
        tab1.setArguments(args);
        ılac.setArguments(args);
        tab3.setArguments(args);
        nurse.setArguments(args);
        message.setArguments(args);
        viewPagerAdapter.addFragment(tab1,"PROFİL");
        viewPagerAdapter.addFragment(ılac,"İLAÇ TEDAVİ");
        viewPagerAdapter.addFragment(tab3,"GÖZETİM");
        viewPagerAdapter.addFragment(nurse,"HEMŞİRE RAPOR");
        viewPagerAdapter.addFragment(message,"MESAJ");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);


    }
}

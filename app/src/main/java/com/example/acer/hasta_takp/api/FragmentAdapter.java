package com.example.acer.hasta_takp.api;


import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentAdapter extends FragmentPagerAdapter {

  List<Fragment> list=new ArrayList<>();
  List<String> liste=new ArrayList<>();
    public FragmentAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int i)
    {
        switch (i){


        }

        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        return liste.get(position);
    }

    public void addTittle(Fragment fragment,String tittle){

        list.add(fragment);
        liste.add(tittle);

    }

}

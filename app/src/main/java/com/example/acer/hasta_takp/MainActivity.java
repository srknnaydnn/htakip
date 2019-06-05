package com.example.acer.hasta_takp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadingGecis();
    }
    public void loadingGecis(){

        Intent ıntent=new Intent(this,Loading.class);
        startActivity(ıntent);

    }

}

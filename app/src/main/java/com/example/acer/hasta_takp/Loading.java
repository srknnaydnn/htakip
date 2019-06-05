package com.example.acer.hasta_takp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Loading extends AppCompatActivity {

    TextView loading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_);

        loading = findViewById(R.id.loading);
    }
    @Override
    protected void onStart() {
        super.onStart();
        onboardingGecis();
    }
    public void onboardingGecis(){
         new CountDownTimer(1500,1000) {

             @Override
             public void onTick(long l) {
             }
             @Override
             public void onFinish() {
                 Intent intent =new Intent(getApplicationContext(),Login.class);
                 startActivity(intent);
             }
         }.start();
    }
}
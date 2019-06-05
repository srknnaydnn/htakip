package com.example.acer.hasta_takp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.acer.hasta_takp.api.MySingleton;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    EditText userName, userPassword;
    Button login;
    Spinner userSection;
    String name, password,section,id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName = findViewById(R.id.username);
        userPassword = findViewById(R.id.password);
        login = findViewById(R.id.giris);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
                if (!name.isEmpty() || !password.isEmpty()) {
                    userName.setText("");
                    userPassword.setText("");
                } else {
                    Toast.makeText(getApplicationContext(), "Boş Alanları Doldurun..", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void login() {

        name = userName.getText().toString().trim();
        password = userPassword.getText().toString().trim();


        String url = "http://htakip.dx.am/database/giris.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if (response.equals("Giriş Başarılı")) {
                            Intent ıntent = new Intent(getApplicationContext(), Dassboard.class);
                            ıntent.putExtra("password",password);
                            startActivity(ıntent);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "hata..", Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();
                params.put("name", name);
                params.put("tc", password);
                return params;
            }
        };
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
    }

}

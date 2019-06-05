package com.example.acer.hasta_takp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity  {

    EditText userName, userSurname, userEmail, userPassword;
    RadioGroup userType;
    RadioButton radioButton;
    Button add;
    String name,surname,email,password,type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userName = findViewById(R.id.name);
        userSurname = findViewById(R.id.surname);
        userEmail = findViewById(R.id.email);
        userPassword = findViewById(R.id.password);
        userType=findViewById(R.id.type);
        add = findViewById(R.id.rgstr);


      add.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              name=userName.getText().toString().trim();
              surname=userSurname.getText().toString().trim();
              email=userEmail.getText().toString().trim();
              password=userPassword.getText().toString().trim();
              type = ((RadioButton)findViewById(userType.getCheckedRadioButtonId())).getText().toString();

              String url = "http://serkan.bugsoft.net/database/ekle.php";
              RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
              StringRequest request = new StringRequest(Request.Method.POST, url,
                      new Response.Listener<String>() {
                          @Override
                          public void onResponse(String response) {
                              if (name.isEmpty() || surname.isEmpty() || email.isEmpty() || password.isEmpty() || type.isEmpty()) {

                                  Toast.makeText(getApplicationContext(), "Boş alanları doldurun..", Toast.LENGTH_SHORT).show();
                              }
                              else
                              {
                                  Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                              }

                             userName.setText("");
                             userSurname.setText("");
                             userEmail.setText("");
                             userPassword.setText("");
                          }
                      },
                      new Response.ErrorListener() {
                          @Override
                          public void onErrorResponse(VolleyError error) {

                                  Toast.makeText(getApplicationContext(), "Unsuccessful"+error , Toast.LENGTH_SHORT).show();
                          }
                      })  {
                  @Override
                  protected Map<String, String> getParams() {
                      Map<String, String> params = new HashMap<String, String>();

                          params.put("name", name);
                          params.put("surname", surname);
                          params.put("email", email);
                          params.put("password", password);
                          params.put("type", type);
                      return params;

                  }
              };
              queue.add(request);
          }
      });
    }

}




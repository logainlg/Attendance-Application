package com.project.sairam;


import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Edit extends AppCompatActivity {
    EditText name1, time1, photo1;
    String profilename, email, imagepath, Id;
    Button button;
    Boolean valid = true;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e);


        name1 = (EditText) findViewById(R.id.name1);
        time1 = (EditText) findViewById(R.id.time1);
        photo1 = (EditText) findViewById(R.id.photo1);
        progressDialog = new ProgressDialog(this);
        button = (Button) findViewById(R.id.button);

        Id = getIntent().getStringExtra("id");
        name1.setText(getIntent().getStringExtra("name"));
        time1.setText(getIntent().getStringExtra("time"));
        photo1.setText(getIntent().getStringExtra("photo"));
        //phone.setText(getIntent().getStringExtra("phone"));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profilename = name1.getText().toString();
                email = time1.getText().toString();
                imagepath = photo1.getText().toString();

                if(TextUtils.isEmpty(profilename)){
                    name1.setError("UID Cannot be Empty");
                    valid = false;
                }else {
                    valid = true;

                    if(TextUtils.isEmpty(email)){
                        time1.setError("Name Cannot be Empty");
                        valid = false;
                    }else {
                        valid = true;

                        if(TextUtils.isEmpty(imagepath)){
                            photo1.setError("Address Cannot be Empty");
                            valid = false;
                        }else {
                            valid = true;


                        }

                    }
                }

                if(valid){
                    progressDialog.setMessage("Loading");
                    progressDialog.show();

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_UPDATE_CLASS, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            progressDialog.dismiss();
                            try{
                                JSONObject jsonObject = new JSONObject(response);
                                Toast.makeText(Edit.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                                if(jsonObject.getString("message").equals("Edit Data Successful")){
                                    ListActivity.ma.refresh_list();
                                    finish();
                                }
                            }catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            progressDialog.hide();
                            Toast.makeText(Edit.this, "Failed",Toast.LENGTH_SHORT).show();
                        }
                    }){
                        protected Map<String , String> getParams() throws AuthFailureError {
                            Map<String , String> params = new HashMap<>();
                            params.put("id", Id);
                            params.put("name", profilename);
                            params.put("time", email);
                            params.put("photo", imagepath );

                            return params;
                        }
                    };
                    RequestHandler.getInstance(Edit.this).addToRequestQueue(stringRequest);

                }
            }
        });
    }
}

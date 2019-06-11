package com.project.sairam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class ed extends AppCompatActivity {
    ImageView btnadd;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        btnadd = (ImageView) findViewById(R.id.addbtn);


        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

                Intent intent = new Intent(ed.this, Edit.class);

                startActivity(intent);

                Toast.makeText(ed.this, "Update Profile", Toast.LENGTH_LONG).show();
            }
        });

    }}

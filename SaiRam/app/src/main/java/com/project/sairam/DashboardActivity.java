package com.project.sairam;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class DashboardActivity extends AppCompatActivity {
    ImageView logout , profile, html ,add;
    Button LogOut;
    TextView EmailShow;
    String EmailHolder;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().setTitle("Home Page");


        //LogOut = (Button)findViewById(R.id.button);
        profile = (ImageView)findViewById(R.id.prof);
        logout = (ImageView)findViewById(R.id.logout);
        EmailShow = (TextView)findViewById(R.id.EmailShow);
        html  = (ImageView)findViewById(R.id.htmlbtn);
        add  = (ImageView)findViewById(R.id.addbtn);





        Intent intent = getIntent();
        EmailHolder = intent.getStringExtra(UserLoginActivity.UserEmail);


        html.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();

                Intent intent = new Intent(DashboardActivity.this, list1.class);

                startActivity(intent);

                Toast.makeText(DashboardActivity.this, "Class List ", Toast.LENGTH_LONG).show();
            }
        });


        EmailShow.setText(EmailHolder);


        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder builder
                        = new AlertDialog
                        .Builder(DashboardActivity.this);

                builder.setMessage("Do you want to update your user profile information?");


                builder.setTitle("Alert !!");


                builder.setCancelable(false);



                builder
                        .setPositiveButton(
                                "Yes",
                                new DialogInterface
                                        .OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which)
                                    {

                                        finish();

                                        Intent intent = new Intent(DashboardActivity.this, view.class);

                                        startActivity(intent);

                                        Toast.makeText(DashboardActivity.this, "User Profile Page", Toast.LENGTH_LONG).show();

                                        //finish();
                                    }
                                });

                // Set the Negative button with No name
                // OnClickListener method is use
                // of DialogInterface interface.
                builder
                        .setNegativeButton(
                                "No",
                                new DialogInterface
                                        .OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which)
                                    {

                                        // If user click no
                                        // then dialog box is canceled.
                                        dialog.cancel();
                                    }
                                });

                // Create the Alert dialog
                AlertDialog alertDialog = builder.create();

                // Show the Alert Dialog box
                alertDialog.show();



                //Toast.makeText(DashboardActivity.this, " ", Toast.LENGTH_LONG).show();


            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();

                Intent intent = new Intent(DashboardActivity.this, list.class);

                startActivity(intent);

                Toast.makeText(DashboardActivity.this, "Student List ", Toast.LENGTH_LONG).show();


            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder builder
                        = new AlertDialog
                        .Builder(DashboardActivity.this);

                builder.setMessage("Do you want to log out from this app?");


                builder.setTitle("Alert !!");


                builder.setCancelable(false);



                builder
                        .setPositiveButton(
                                "Yes",
                                new DialogInterface
                                        .OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which)
                                    {

                                        finish();

                                        Intent intent = new Intent(DashboardActivity.this, UserLoginActivity.class);

                                        startActivity(intent);

                                        Toast.makeText(DashboardActivity.this, "Thank You ", Toast.LENGTH_LONG).show();

                                        //finish();
                                    }
                                });

                // Set the Negative button with No name
                // OnClickListener method is use
                // of DialogInterface interface.
                builder
                        .setNegativeButton(
                                "No",
                                new DialogInterface
                                        .OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which)
                                    {

                                        // If user click no
                                        // then dialog box is canceled.
                                        dialog.cancel();
                                    }
                                });

                // Create the Alert dialog
                AlertDialog alertDialog = builder.create();

                // Show the Alert Dialog box
                alertDialog.show();



                //Toast.makeText(DashboardActivity.this, " ", Toast.LENGTH_LONG).show();


            }
        });



    }




}
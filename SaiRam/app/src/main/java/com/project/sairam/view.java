package com.project.sairam;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class view extends AppCompatActivity {


    ImageView imgView,img1,img2;
    Button btnTakePicture,btnUpload;

    Button update;
    TextView EmailShow;

    EditText First_Name, Last_Name, Email, Password ;
    String F_Name_Holder, L_Name_Holder, EmailHolder, PasswordHolder;

    String finalResult ;
    String HttpURL = "https://dropping-dozens.000webhostapp.com/User/UpdateStudent.php";
    //String HttpURL = "https://10.19.80.23/User/UpdateStudent.php";

    Boolean CheckEditText ;
    ProgressDialog progressDialog;

    HashMap<String,String> hashMap = new HashMap<>();
    HttpParse httpParse = new HttpParse();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        getSupportActionBar().setTitle("User Profile");


        EmailShow = (TextView)findViewById(R.id.EmailShow);

        First_Name = (EditText) findViewById(R.id.editTextF_Name);
        Last_Name = (EditText) findViewById(R.id.editTextL_Name);
        Email = (EditText) findViewById(R.id.editTextEmail);
        Password = (EditText) findViewById(R.id.editTextPassword);


        Intent intent = getIntent();
        EmailHolder = intent.getStringExtra(UserLoginActivity.UserEmail);

        update = (Button) findViewById(R.id.updatebtn);

        F_Name_Holder = getIntent().getStringExtra("FName");
        L_Name_Holder = getIntent().getStringExtra("LNAME");
        EmailHolder = getIntent().getStringExtra("EMAIL");
        PasswordHolder = getIntent().getStringExtra("PASSWORD");


        First_Name.setText(F_Name_Holder);
        Last_Name.setText(L_Name_Holder);
        Email.setText(EmailHolder);
        Password.setText(PasswordHolder);

        update.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view) {


                    AlertDialog.Builder builder
                            = new AlertDialog
                            .Builder(view.this);

                    builder.setMessage("Are you sure want to save your information?");


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
                                            GetDataFromEditText();
                                            RecordUpdate(F_Name_Holder, L_Name_Holder, EmailHolder, PasswordHolder);

                                            finish();

                                            Intent intent = new Intent(view.this, DashboardActivity.class);

                                            startActivity(intent);

                                            Toast.makeText(view.this, "Your Information has been updated ", Toast.LENGTH_LONG).show();

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


        imgView = findViewById(R.id.imageView);
        btnTakePicture = findViewById(R.id.button);
        //btnUpload = findViewById(R.id.button2);

        btnTakePicture = findViewById(R.id.button);
        //btnUpload = findViewById(R.id.button2);

        btnTakePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, 1);
                }
            }
        });


        EmailShow.setText(EmailHolder);

    }

       public void GetDataFromEditText(){
        F_Name_Holder = First_Name.getText().toString();
        L_Name_Holder = Last_Name.getText().toString();
        EmailHolder = Email.getText().toString();
        PasswordHolder = Password.getText().toString();


    }


    public void RecordUpdate(final String F_Name, final String L_Name, final String email, final String password){

        class RecordUpdateClass extends AsyncTask<String,Void,String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                progressDialog = ProgressDialog.show(view.this,"Loading Data",null,true,true);
            }

            @Override
            protected void onPostExecute(String httpResponseMsg) {

                super.onPostExecute(httpResponseMsg);

                progressDialog.dismiss();

                Toast.makeText(view.this,httpResponseMsg.toString(), Toast.LENGTH_LONG).show();

            }

            @Override
            protected String doInBackground(String... params) {

                hashMap.put("f_name",params[0]);

                hashMap.put("L_name",params[1]);

                hashMap.put("email",params[2]);

                hashMap.put("password",params[3]);

                finalResult = httpParse.postRequest(hashMap, HttpURL);

                return finalResult;
            }
        }

        RecordUpdateClass recordUpdateClass = new RecordUpdateClass();

        recordUpdateClass.execute(F_Name,L_Name,email,password);
    }


    public String getDir(){
        ContextWrapper cw = new ContextWrapper(this);
        File pictureFileDir = cw.getDir("basic", Context.MODE_PRIVATE);
        if (!pictureFileDir.exists()) {
            pictureFileDir.mkdir();
        }
        Log.d("GETDIR",pictureFileDir.getAbsolutePath());
        return pictureFileDir.getAbsolutePath()+"/picture.jpg";
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imgView.setImageBitmap(imageBitmap);
            ContextWrapper cw = new ContextWrapper(this);
            File pictureFileDir = cw.getDir("basic", Context.MODE_PRIVATE);
            if (!pictureFileDir.exists()) {
                pictureFileDir.mkdir();
            }
            FileOutputStream outStream = null;
            String photoFile = "picture.jpg";
            File outFile = new File(pictureFileDir, photoFile);
            try {
                outStream = new FileOutputStream(outFile);
                imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, outStream);
                outStream.flush();
                outStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (outFile.exists()){
                Toast.makeText(cw, "File save in "+outFile.getAbsolutePath(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    public class Encode_image extends AsyncTask<String,String,Void> {
        private String encoded_string, image_name;
        Bitmap bitmap;

        @Override
        protected Void doInBackground(String... args) {
            String filename = args[0];
            image_name = args[1];
            bitmap = BitmapFactory.decodeFile(filename);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream);
            byte[] array = stream.toByteArray();
            encoded_string = Base64.encodeToString(array, 0);
            return null;
        }

        @Override
        protected void onPostExecute(Void avoid) {
            makeRequest(encoded_string, image_name);
        }
    }
    private void makeRequest(final String encoded_string, final String image_name) {
        class UploadAll extends AsyncTask<Void, Void, String> {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected String doInBackground(Void... params) {
                HashMap<String, String> map = new HashMap<>();
                map.put("encoded_string", encoded_string);
                map.put("image_name", image_name);
                RequestHandler1 rh = new RequestHandler1();//request server connection
                //String s = rh.sendPostRequest("http://10.19.80.23/upload.php", map);
                String s = rh.sendPostRequest("http://dropping-dozens.000webhostapp.com/User/upload.php", map);
                //dropping-dozens.000webhostapp.com/User
                return s;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                if (s.equalsIgnoreCase("Success")) {
                    Toast.makeText(view.this, "Success Class Image Sent To Server", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(view.this, "Failed Sent Class Image To Server", Toast.LENGTH_SHORT).show();
                }
            }
        }
        UploadAll uploadall = new UploadAll();
        uploadall.execute();
    }
}

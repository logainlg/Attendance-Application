package com.project.sairam;


import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class att extends AppCompatActivity {
    ImageView imgView,img1,img2;
    Button btnTakePicture,btnUpload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_att);
        imgView = findViewById(R.id.imageView);
        img1 = findViewById(R.id.imageView1);
        img2 = findViewById(R.id.imageView2);

        btnTakePicture = findViewById(R.id.button);
        //btnUpload = findViewById(R.id.button2);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, 1);
                }
            }
        });



        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Encode_image().execute(getDir(),"class.jpg");
                //new Encode_image().execute(getDir());

            }
        });
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
                String s = rh.sendPostRequest("http://dropping-dozens.000webhostapp.com/User/upload1.php", map);

                return s;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                if (s.equalsIgnoreCase("Success")) {
                    Toast.makeText(att.this, "Success Class Image Sent To Server", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(att.this, "Failed Sent Class Image To Server", Toast.LENGTH_SHORT).show();
                }
            }
        }
        UploadAll uploadall = new UploadAll();
        uploadall.execute();
    }
}


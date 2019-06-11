package com.project.sairam;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class list1 extends AppCompatActivity {

    //String urladdress="http://10.19.80.23/displayprofile.php";
    String urladdress="http://dropping-dozens.000webhostapp.com/displayprofile.php";
    String[] name;
    String[] email;
    String[] imagepath;
    ListView listView;


    BufferedInputStream is;
    String line=null;
    String result=null;

    //private static final String TAG = "list";

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sett, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.sett) {

            Intent tes = new Intent(list1.this, ListActivityClass.class);
            startActivity(tes);
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_a);
        getSupportActionBar().setTitle("Take Attendance");
        //Log.d(TAG, "onCreate: Started.");

        listView=(ListView)findViewById(R.id.lview);

        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        collectData();

        CustomListView1 customListView1 =new CustomListView1(this,name,email,imagepath);
        listView.setAdapter(customListView1);




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object listItem = listView.getItemAtPosition(position);



                Intent intent = new Intent(list1.this, att.class);

                startActivity(intent);

                Toast.makeText(list1.this, "Class List", Toast.LENGTH_LONG).show();

            }
        });





    }


    private void collectData()
    {
//Connection
        try{

            URL url=new URL(urladdress);
            HttpURLConnection con=(HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            is=new BufferedInputStream(con.getInputStream());

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        //content
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            StringBuilder sb=new StringBuilder();
            while ((line=br.readLine())!=null){
                sb.append(line+"\n");
            }
            is.close();
            result=sb.toString();

        }
        catch (Exception ex)
        {
            ex.printStackTrace();

        }

//JSON
        try{
            JSONArray ja=new JSONArray(result);
            JSONObject jo=null;
            name=new String[ja.length()];
            email=new String[ja.length()];
            imagepath=new String[ja.length()];

            for(int i=0;i<=ja.length();i++){
                jo=ja.getJSONObject(i);
                name[i]=jo.getString("uid");
                email[i]=jo.getString("name");
                imagepath[i]=jo.getString("phone");
            }
        }
        catch (Exception ex)
        {

            ex.printStackTrace();
        }


    }
}

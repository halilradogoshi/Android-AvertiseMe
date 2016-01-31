package com.dovelaqm.advertiseme;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    //Declare the EditText fields and SharePreferences

    EditText editText_title;
    EditText editText_title2;
    EditText editText_name;
    EditText editText_name2;
    EditText editText_text;
    EditText editText_text2;
    EditText editText_phone;
    EditText editText_phone2;
    EditText editText_price;
    EditText editText_price2;

    public static final String MY_PREFERENCES = "MyPrefsFile";
    public static final String TITLE = "titleKey";
    public static final String NAME = "nameKey";
    public static final String TEXT = "textKey";
    public static final String PHONE = "phoneKey";
    public static final String PRICE = "priceKey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //Method to save data and switch between the visibility of layouts
    private void saveAdvertisement(){


        //Switch the visibility of layouts
        findViewById(R.id.layout_content).setVisibility(View.GONE);
        findViewById(R.id.layout_overview).setVisibility(View.VISIBLE);
    }

    //Method to make the phone call. Do not forget to add the permission to call on the manifest
    private void callMe(View view){
        //Get the phone number from the relevant field on the overview_main
        String phoneNumber = findViewById(R.id.editText_phone2).toString().replace("-","");         //remove possible minus signs from the string

        //Start the phone activity
        Intent phoneIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
        try{
            startActivity(phoneIntent);
        }catch(android.content.ActivityNotFoundException ex) {
            Toast.makeText(getApplicationContext(),"You might not be able to make phone call on this device", Toast.LENGTH_SHORT).show();
        }
    }


        //Method to read the data
        private void readAdvertisement(View view){



    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

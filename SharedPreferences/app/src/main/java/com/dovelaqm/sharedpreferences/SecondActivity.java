package com.dovelaqm.sharedpreferences;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    //Declare the edittext fields
    EditText edtTitle;
    EditText edtName;
    EditText edtText;
    EditText edtPhone;
    EditText edtPrice;


    //Declare the button
    Button btnCall;

    //Declare the static holders
    public static final String MY_PREFS = "MyPrefs";
    public static final String TITLE = "titleKey";
     public static final String NAME ="nameKey";
    public static final String TEXT ="textKey";
    public static final String PHONE ="phoneKey";
    public static final String PRICE ="priceKey";

    //Deaclare the shared preferences
    SharedPreferences shp;
    /*
    Intent callIntent = new Intent(Intent.ACTION_CALL);
    callIntent.setData(Uri.parse("tel:738220096"));*/

    public void callZeNumber(View view) {
        String phoneNumber = edtPhone.getText().toString();
        Intent callIntent=new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:"+phoneNumber));
        try{
            startActivity(callIntent);
        }

        catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(getApplicationContext(),"Could not make the phone call", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Link the declared edittexts to the ones in the form
        edtTitle = (EditText)findViewById(R.id.edtTitle);
        edtName = (EditText)findViewById(R.id.edtName);
        edtText =(EditText)findViewById(R.id.edtText);
        edtPhone = (EditText)findViewById(R.id.edtPhone);
        edtPrice = (EditText)findViewById(R.id.edtPrice);


        //Link the declared button to the one in the form
        btnCall = (Button)findViewById(R.id.btnCall);

        //Initiate the shared preferences
        shp = getSharedPreferences(MY_PREFS, Context.MODE_PRIVATE);

        //Get the values from saved preferences
        String titleValue = shp.getString(TITLE,"DEF");
        String nameValue = shp.getString(NAME, "DEF");
        String textValue = shp.getString(TEXT,"DEF");
        String phoneValue = shp.getString(PHONE,"DEF");
        String priceValue = shp.getString(PRICE, "DEF");


        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                callZeNumber(v);

            }
        });



        //Add the values to the form
        edtTitle.setText(titleValue);
        edtName.setText(nameValue);
        edtText.setText(textValue);
        edtPhone.setText(phoneValue);
        edtPrice.setText(priceValue);




    }





}

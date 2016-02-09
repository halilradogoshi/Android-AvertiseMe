package com.dovelaqm.sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declare the edittext fields
    EditText edtTitle;
    EditText edtName;
    EditText edtText;
    EditText edtPhone;
    EditText edtPrice;

    //Declare the button
      Button btnSave;


    //Declare the static holders
    public static final String MY_PREFS ="MyPrefs";
    public static final String TITLE ="titleKey";
    public static final String NAME ="nameKey";
    public static final String TEXT ="textKey";
    public static final String PHONE ="phoneKey";
    public static final String PRICE ="priceKey";


    //Deaclare the shared preferences
    SharedPreferences shp;

    //Method to switch to the other activity
    public void switchActivity(View view){
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Link the declared edittexts to the ones in the form
        edtTitle = (EditText)findViewById(R.id.edtTitle);
        edtName = (EditText)findViewById(R.id.edtName);
        edtText =(EditText)findViewById(R.id.edtText);
        edtPhone = (EditText)findViewById(R.id.edtPhone);
        edtPrice = (EditText)findViewById(R.id.edtPrice);



        //Link the declared button to the one in the form
        btnSave = (Button)findViewById(R.id.btnSave);


        //Initiate the shared preferences
        shp = getSharedPreferences(MY_PREFS, Context.MODE_PRIVATE);



        //Set the actions when clicking on the button
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Get the value from the edittext fields
                String t = edtTitle.getText().toString();
                String n = edtName.getText().toString();
                String tx = edtText.getText().toString();
                String p = edtPhone.getText().toString();
                String pr = edtPrice.getText().toString();


                SharedPreferences.Editor editor = shp.edit();

                editor.putString(TITLE,t);
                editor.putString(NAME,n);
                editor.putString(TEXT,tx);
                editor.putString(PHONE,p);
                editor.putString(PRICE,pr);
                editor.commit();
                switchActivity(v);

            }
        });




    }
}

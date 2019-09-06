package com.example.newapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.view.View;
import android.widget.Toast;
import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;
import android.view.Gravity;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Context context = this;
    private EditText numberID;
    private TextView updatedID;
    private Button button;
    private String dummy;
    public int sp1meter;
    public int sp1centimeter;
    public int sp1inch;
    public int sp2meter;
    public int sp2centimeter;
    public int sp2inch;

    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        switch(adapterView.getId()) {
            case R.id.spinner1:
                String text = adapterView.getItemAtPosition(position).toString();
                Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT);
                adapterView.getItemAtPosition(position);
                if (text.equals("Meter")) {
                    sp1meter = 1;
                    Log.d("CREATION", text);
                }
                if (text.equals("Centimeter")) {
                    sp1centimeter = 1;
                }
                if (text.equals("Inch")) {
                    sp1inch = 1;
                }
                break;
            case R.id.spinner2:
                String text1 = adapterView.getItemAtPosition(position).toString();
                Toast.makeText(adapterView.getContext(), text1, Toast.LENGTH_SHORT);
                adapterView.getItemAtPosition(position);
                if (text1.equals("Meter")) {
                    sp2meter = 1;
                    Log.d("CREATION", text1);
                }
                if (text1.equals("Centimeter")) {
                    sp2centimeter = 1;
                }
                if (text1.equals("Inch")) {
                    sp2inch = 1;
                }
                break;
            default:
                break;
        }
        Log.d("CREATION", "DEBUG");
    }

  /*  public void setDummy(String s){
        this.dummy = s;
    }

    public String getDummy(){}*/


    /*public String getSpinnerVal(AdapterView<?> adapterView, View view, int position, long l) {
        String text = adapterView.getItemAtPosition(position).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT);
        adapterView.getItemAtPosition(position);
        return text;*/
       /* if (text.equals("Inch")) {
            //Log.d("CREATION", text);
        }*/
        //Log.d("CREATION", "YO DAMN GURL YOU GOT ME ACTIN BRAZY");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Spinner spinner1 = findViewById(R.id.spinner1);
        final Spinner spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, R.array.numbers, android.R.layout.simple_spinner_item);
        //ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(context, R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(this);

        numberID = (EditText) findViewById(R.id.numberID); //EditText is defined as edittext in xml
        updatedID = (TextView) findViewById(R.id.updatedID); //TextView is defined as textview in xml
        button = (Button) findViewById(R.id.button); //Button is defined as button in xml



        //When button is clicked
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner1.setSelection(0);
                spinner2.setSelection(0);
                //String sVal1 = spinner1.getSpinnerVal(AdapterView<?> adapterView, View view, int position, long l);
                //String sVal2 = getSpinnerVal();
                //String txt = numberID.getText().toString(); //Get txt from et when button is clicked
                //int desiredValue = Integer.parseInt(txt);
                int number = Integer.parseInt(numberID.getText().toString());
                //doMath(number, sp1, sp2);
                if(sp1meter==0 && sp2centimeter==1) {
                    number = number * 100;
                }
                if(sp1meter==0 && sp2centimeter==0) {
                    number = number * 1;
                }
                else {
                    number = number * 4;
                }
                updatedID.setText(String.valueOf(number));
            }
        });


       /* public void doMath(number, spinner1, spinner2) {
            if ( "Inch" && "Centimeter") {

            }
            updatedID.setText(String.valueOf(number));
        }*/
    }

  /*  @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        String text = adapterView.getItemAtPosition(position).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT);
        adapterView.getItemAtPosition(position);
        if(text == "Meter") {
        }
    }*/

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}
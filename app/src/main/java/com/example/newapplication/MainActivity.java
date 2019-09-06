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


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Context context = this;
    private EditText numberID;
    private TextView updatedID;
    private Button button;
    public int x;
    public int y;

    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        switch (adapterView.getId()) {
            case R.id.spinner1:
                String text = adapterView.getItemAtPosition(position).toString();
                Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT);
                adapterView.getItemAtPosition(position);
                if (text.equals("Meter")) {
                    x = 0;
                    Log.d("CREATION", text);
                }
                if (text.equals("Centimeter")) {
                    x = 2;
                }
                if (text.equals("Inch")) {
                    x = 3;
                }
                break;
            case R.id.spinner2:
                String text1 = adapterView.getItemAtPosition(position).toString();
                Toast.makeText(adapterView.getContext(), text1, Toast.LENGTH_SHORT);
                adapterView.getItemAtPosition(position);
                if (text1.equals("Meter")) {
                    y = 1;
                    Log.d("CREATION", text1);
                }
                if (text1.equals("Centimeter")) {
                    y = 2;
                }
                if (text1.equals("Inch")) {
                    y = 3;
                }
                break;
            default:
                break;
        }
        Log.d("CREATION", "DEBUG");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Spinner spinner1 = findViewById(R.id.spinner1);
        final Spinner spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(this);

        numberID = (EditText) findViewById(R.id.numberID);
        updatedID = (TextView) findViewById(R.id.updatedID);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner1.setSelection(0);
                spinner2.setSelection(0);
                double number = Double.parseDouble("0" + numberID.getText().toString());
               // int number = Integer.parseInt(numberID.getText().toString());
                double result = 0;
                //Meters to Centimeters
                if (x == 0 && y == 2) {
                    result = number * 100;
                }
                //Meters to Meters
                if (x == 0 && y == 1) {
                    result = number;
                }
                //Centimeters to Meters
                if (x == 2 && y == 1) {
                    result = (double) number / 100;
                }
                //Meters to Inches
                if (x == 0 && y == 3) {
                    result = (double) number * 39.37;
                }
                //Inches to Meters
                if (x == 3 && y == 1) {
                    result = (double) number / 39.37;
                }
                //Centimeters to Inches
                if (x == 2 && y == 3) {
                    result = (double) number / 2.54;
                }
                //Inches to Centimeters
                if (x == 3 && y == 2) {
                    result = (double) number * 2.54;
                }
                //Inches to Inches
                if (x == 3 && y == 3) {
                    result = number;
                }
                //Centimeters to Centimeters
                if (x == 2 && y == 2) {
                    result = number;
                }
                updatedID.setText(String.valueOf(result));
            }
        });

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
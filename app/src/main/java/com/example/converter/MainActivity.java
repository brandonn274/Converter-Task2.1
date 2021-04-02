package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
    EditText editTextNumber;
    TextView ConversionOne, ConversionTwo, ConversionThree, NumberOne, NumberTwo, NumberThree;
    ImageButton MetreButton, CelsiusButton, WeightButton;
    Spinner spinner;


    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConversionOne = findViewById(R.id.ConversionOne);
        ConversionTwo = findViewById(R.id.ConversionTwo);
        ConversionThree = findViewById(R.id.ConversionThree);

        NumberOne = findViewById(R.id.NumberOne);
        NumberTwo = findViewById(R.id.NumberTwo);
        NumberThree = findViewById(R.id.NumberThree);
        editTextNumber = findViewById(R.id.editTextNumber);

        MetreButton = findViewById(R.id.MetreButton);
        CelsiusButton = findViewById(R.id.CelsiusButton);
        WeightButton = findViewById(R.id.WeightButton);
        spinner=findViewById(R.id.spinner);

        SpinnerMethd();


        MetreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spinner.getSelectedItemPosition() == 0) {


                    ConvertFromMetreToCentimetres();
                    ConvertFromMetreToFeet();
                    ConvertFromMetreToInch();
                } else
                    Toast.makeText(MainActivity.this, "Please select the correct conversion icon. ", Toast.LENGTH_SHORT).show();
            }

        });

        CelsiusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spinner.getSelectedItemPosition() == 1) {

                    ConversionThree.setText("");
                    NumberThree.setText("");
                    ConvertFromCelsiusToFahrenheit();
                    ConvertFromCelsiusToKelvin();
                } else
                    Toast.makeText(MainActivity.this, "Please select the correct conversion icon. ", Toast.LENGTH_SHORT).show();
            }
        });
        WeightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (spinner.getSelectedItemPosition() == 2) {
                    ConvertFromKiloToGram();
                    ConvertFromKiloToOunce();
                    ConvertFromKiloToPound();
                } else
                    Toast.makeText(MainActivity.this, "Please select the correct conversion icon. ", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void SpinnerMethd() {
        ArrayAdapter<String> Units = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.ConversionUnit));
        Units.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter((Units));
    }

    private void ConvertFromKiloToGram() {
        String UserInput = editTextNumber.getText().toString();
        double Kilo = Double.parseDouble((UserInput));
        double gram = Kilo * 1000;
        ConversionOne.setText("Grams");
        NumberOne.setText(String.format("%.2f", gram));

    }

    private void ConvertFromKiloToOunce() {
        String UserInput = editTextNumber.getText().toString();
        double Kilo = Double.parseDouble((UserInput));
        double Ounce = Kilo * 35.274;
        ConversionTwo.setText("Ounce (Oz)");
        NumberTwo.setText(String.format("%.2f", Ounce));
    }

    private void ConvertFromKiloToPound() {
        String UserInput = editTextNumber.getText().toString();
        double Kilo = Double.parseDouble((UserInput));
        double Pound = Kilo * 2.205;
        ConversionThree.setText("Pounds");
        NumberThree.setText(String.format("%.2f", Pound));
    }


    private void ConvertFromCelsiusToFahrenheit() {

        String UserInput = editTextNumber.getText().toString();
        double Degree = Double.parseDouble((UserInput));
        double fahrenheit = (Degree * 9 / 5) + 32;
        ConversionOne.setText("Fahrenheit");
        NumberOne.setText(String.format("%.2f", fahrenheit));


    }

    private void ConvertFromCelsiusToKelvin() {
        String UserInput = editTextNumber.getText().toString();
        double Degree = Double.parseDouble((UserInput));
        double Kelvin = Degree + 273.15;
        ConversionTwo.setText("Kelvin");
        NumberTwo.setText(String.format("%.2f", Kelvin));

    }


    private void ConvertFromMetreToCentimetres() {
        String UserInput = editTextNumber.getText().toString();
        double Metre = Double.parseDouble((UserInput));
        double centrimetre = Metre * 100;
        ConversionOne.setText("Centimetres");
        NumberOne.setText(String.format("%.2f", centrimetre));
    }


    private void ConvertFromMetreToFeet() {
        String UserInput = editTextNumber.getText().toString();
        double Metre = Double.parseDouble((UserInput));
        double feet = Metre * 3.281;
        ConversionTwo.setText("Feet");
        NumberTwo.setText(String.format("%.2f", feet));
    }

    private void ConvertFromMetreToInch() {
        String UserInput = editTextNumber.getText().toString();
        double Metre = Double.parseDouble((UserInput));
        double Inches = Metre * 39.37;
        ConversionThree.setText("Inches");
        NumberThree.setText(String.format("%.2f", Inches));

    }




}
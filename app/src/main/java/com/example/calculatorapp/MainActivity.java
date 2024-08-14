package com.example.calculatorapp;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.calculatorapp.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText firstNumber = findViewById(R.id.firstNumber);
        EditText secondNumber = findViewById(R.id.secondNumber);
        Button add =  findViewById(R.id.addButton);
        Button subtract = findViewById(R.id.subtractButton);
        Button multiply = findViewById(R.id.multiplyButton);
        Button divide = findViewById(R.id.divideButton);
        TextView result = findViewById(R.id.result);



        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                double i = Double.parseDouble(firstNumber.getText().toString());
                double j = Double.parseDouble(secondNumber.getText().toString());
                double sum = i + j;
                result.setText(String.valueOf(sum));
            }
        });


        subtract.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                double i = Double.parseDouble(firstNumber.getText().toString());
                double j = Double.parseDouble(secondNumber.getText().toString());
                double sum = i - j;
                result.setText(String.valueOf(sum));
            }
        });

        multiply.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                double i = Double.parseDouble(firstNumber.getText().toString());
                double j = Double.parseDouble(secondNumber.getText().toString());
                double sum = i * j;
                result.setText(String.valueOf(sum));
            }
        });

        divide.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                double i = Double.parseDouble(firstNumber.getText().toString());
                double j = Double.parseDouble(secondNumber.getText().toString());
                double sum = i / j;
                result.setText(String.valueOf(sum));
            }
        });
    }

}
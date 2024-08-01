package com.example.calculatorapp;

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
        TextView result = findViewById(R.id.result);



        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int i = Integer.parseInt(firstNumber.getText().toString());
                int j = Integer.parseInt(secondNumber.getText().toString());
                int sum = i + j;
                result.setText(String.valueOf(sum));
            }
        });
    }

}
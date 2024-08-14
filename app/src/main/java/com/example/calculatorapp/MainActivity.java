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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText firstNumber = findViewById(R.id.firstNumber);
        EditText secondNumber = findViewById(R.id.secondNumber);
        Button add = findViewById(R.id.addButton);
        Button subtract = findViewById(R.id.subtractButton);
        Button multiply = findViewById(R.id.multiplyButton);
        Button divide = findViewById(R.id.divideButton);
        TextView result = findViewById(R.id.result);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleOperation(view, firstNumber, secondNumber, result, "add");
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleOperation(view, firstNumber, secondNumber, result, "subtract");
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleOperation(view, firstNumber, secondNumber, result, "multiply");
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleOperation(view, firstNumber, secondNumber, result, "divide");
            }
        });
    }

    private void handleOperation(View view, EditText firstNumber, EditText secondNumber, TextView result, String operation) {
        try {
            String firstInput = firstNumber.getText().toString();
            String secondInput = secondNumber.getText().toString();

            if (firstInput.isEmpty() || secondInput.isEmpty()) {
                Toast.makeText(view.getContext(), "Please enter both numbers.", Toast.LENGTH_SHORT).show();
                return;
            }

            double i = Double.parseDouble(firstInput);
            double j = Double.parseDouble(secondInput);

            double sum = 0;
            switch (operation) {
                case "add":
                    sum = i + j;
                    break;
                case "subtract":
                    sum = i - j;
                    break;
                case "multiply":
                    sum = i * j;
                    break;
                case "divide":
                    if (j == 0) {
                        secondNumber.setText("");
                        secondNumber.setHint("Enter new value.");
                        Toast.makeText(view.getContext(), "Cannot equal 0. Please enter a new value.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    sum = i / j;
                    break;
            }

            result.setText(String.valueOf(sum));
        } catch (NumberFormatException e) {
            secondNumber.setText("");
            secondNumber.setHint("Enter new value.");
            firstNumber.setText("");
            firstNumber.setHint("Enter new value.");
            Toast.makeText(view.getContext(), "Invalid input. Please enter numeric values.", Toast.LENGTH_SHORT).show();
        } catch (ArithmeticException e) {
            secondNumber.setText("");
            secondNumber.setHint("Enter new value.");
            firstNumber.setText("");
            firstNumber.setHint("Enter new value.");
            Toast.makeText(view.getContext(), "Arithmetic error. Please check your inputs.", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            secondNumber.setText("");
            secondNumber.setHint("Enter new value.");
            firstNumber.setText("");
            firstNumber.setHint("Enter new value.");
            Toast.makeText(view.getContext(), "An unexpected error occurred.", Toast.LENGTH_SHORT).show();
        }
    }

}
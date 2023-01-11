package com.startandroid.calcproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    TextView calcView;
    Boolean isNewNumber = true;
    String expression; // TODO add beautiful expression
    String number;
    String firstOperand;
    String secondOperand;
    String operator;
    Double result = 0.0;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcView = findViewById(R.id.calcView);

    }

    public void clickDigit(View v) {
        if (isNewNumber) {
            calcView.setText("");
        }
        isNewNumber = false;

        number = calcView.getText().toString();

        if (v.getId() == R.id.one) {
            number += "1";
        } else if (v.getId() == R.id.two) {
            number += "2";
        } else if (v.getId() == R.id.three) {
            number += "3";
        } else if (v.getId() == R.id.four) {
            number += "4";
        } else if (v.getId() == R.id.five) {
            number += "5";
        } else if (v.getId() == R.id.six) {
            number += "6";
        } else if (v.getId() == R.id.seven) {
            number += "7";
        } else if (v.getId() == R.id.eight) {
            number += "8";
        } else if (v.getId() == R.id.nine) {
            number += "9";
        } else if (v.getId() == R.id.zero) {
            number += "0";
        } else if (v.getId() == R.id.dot) {
            number += ".";
        }
        calcView.setText(number);
    }

    public void clickOperator(View v) {
        isNewNumber = true;
        firstOperand = calcView.getText().toString();

        if (v.getId() == R.id.division) {
            operator = "/";
        } else if (v.getId() == R.id.multiply) {
            operator = "*";
        } else if (v.getId() == R.id.subtraction) {
            operator = "-";
        } else if (v.getId() == R.id.sum) {
            operator = "+";
        }
    }

    public void clickEquals(View v) {
        secondOperand = calcView.getText().toString();

        if (Objects.equals(operator, "/")) {
            result = Double.parseDouble(firstOperand) / Double.parseDouble(secondOperand);
        } else if (Objects.equals(operator, "*")) {
            result = Double.parseDouble(firstOperand) * Double.parseDouble(secondOperand);
        } else if (Objects.equals(operator, "-")) {
            result = Double.parseDouble(firstOperand) - Double.parseDouble(secondOperand);
        } else if (Objects.equals(operator, "+")) {
            result = Double.parseDouble(firstOperand) + Double.parseDouble(secondOperand);
        }

        calcView.setText(result+"");
    }

    public void clickCalc(View v) {
        calcView.setText("0");
        isNewNumber = true;
    }
}
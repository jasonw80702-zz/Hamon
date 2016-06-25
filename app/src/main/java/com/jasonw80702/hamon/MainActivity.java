package com.jasonw80702.hamon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public void generateNumbers(View view) {
        EditText answerOne = (EditText) findViewById(R.id.number1);
        EditText answerTwo = (EditText) findViewById(R.id.number2);

        Random rng = new Random();
        int numberOne = rng.nextInt(30) + 1;
        int numberTwo = rng.nextInt(30) + 1;
        String number1 = String.valueOf(numberOne);
        String number2 = String.valueOf(numberTwo);

        answerOne.setText(number1);
        answerTwo.setText(number2);
    }

    // submit answer in EditText
    public void submitAnswer(View view) {
        EditText userAnswer = (EditText) findViewById(R.id.userInput);
        int userAnswerInt = Integer.parseInt(userAnswer.getText().toString());

        EditText answerOne = (EditText) findViewById(R.id.number1);
        int answerOneInt = Integer.parseInt(answerOne.getText().toString());

        EditText answerTwo = (EditText) findViewById(R.id.number2);
        int answerTwoInt = Integer.parseInt(answerTwo.getText().toString());

        EditText currentSymbol = (EditText) findViewById(R.id.symbol);
        String symbol = currentSymbol.getText().toString();

        if (symbol.equals("+")) {
            if (userAnswerInt == (answerOneInt + answerTwoInt)) {
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.correct), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.incorrect), Toast.LENGTH_LONG).show();
            }
        } else if (symbol.equals("-")) {
            if (userAnswerInt == (answerOneInt - answerTwoInt)) {
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.correct), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.incorrect), Toast.LENGTH_LONG).show();
            }
        } else if (symbol.equals("x")) {
            if (userAnswerInt == (answerOneInt * answerTwoInt)) {
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.correct), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.incorrect), Toast.LENGTH_LONG).show();
            }
        } else {
            if (userAnswerInt == (answerOneInt / answerTwoInt)) {
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.correct), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.incorrect), Toast.LENGTH_LONG).show();
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner dropDown = (Spinner) findViewById(R.id.spinner1);
        // Create an ArrayAdapter using string array and a default spinner
        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
                .createFromResource(this, R.array.arithmetic_array,
                        android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        staticAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply adapter to the spinner
        dropDown.setAdapter(staticAdapter);
    }
}

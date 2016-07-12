package com.jasonw80702.hamon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // generate numbers in both EditTexts
    public void generateNumbers(View view) {
        EditText answerOne = (EditText) findViewById(R.id.number1);
        EditText answerTwo = (EditText) findViewById(R.id.number2);
        EditText symbol = (EditText) findViewById(R.id.symbol);
        String symbolStr = symbol.getText().toString();

        int numberOne;
        int numberTwo;
        Random rng = new Random();
        if (symbolStr.equals(getResources().getString(R.string.addition))) {
            numberOne = rng.nextInt(50) + 1;
            numberTwo = rng.nextInt(50) + 1;
        } else if (symbolStr.equals(getResources().getString(R.string.subtraction))) {
            numberOne = rng.nextInt(50) + 50;
            numberTwo = rng.nextInt(35) + 15;
        } else if (symbolStr.equals(getResources().getString(R.string.multiplication))) {
            numberOne = rng.nextInt(14) + 2;
            numberTwo = rng.nextInt(14) + 2;
        } else {
            int numberToMultiply = rng.nextInt(10) + 3;
            numberTwo = rng.nextInt(10) + 3;
            numberOne = numberTwo * numberToMultiply;
        }

        String number1 = String.valueOf(numberOne);
        String number2 = String.valueOf(numberTwo);


        answerOne.setText(number1);
        answerTwo.setText(number2);
    }

    // submit answer in EditText
    public void submitAnswer(View view) {

        // answers
        EditText userAnswer = (EditText) findViewById(R.id.userInput);
        String userAnswerStr = userAnswer.getText().toString().trim();
        EditText answerOne = (EditText) findViewById(R.id.number1);
        EditText answerTwo = (EditText) findViewById(R.id.number2);

        // statistics
        EditText combo = (EditText) findViewById(R.id.comboNumber);
        EditText total = (EditText) findViewById(R.id.totalNumber);
        int comboNumber = Integer.parseInt(combo.getText().toString());
        int totalNumber = Integer.parseInt(total.getText().toString());

        // symbol
        EditText currentSymbol = (EditText) findViewById(R.id.symbol);
        String symbol = currentSymbol.getText().toString();

        if ("".equals(userAnswerStr)) {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.noinput), Toast.LENGTH_LONG).show();
        } else {
            int userAnswerInt = Integer.parseInt(userAnswer.getText().toString());
            int answerOneInt = Integer.parseInt(answerOne.getText().toString());
            int answerTwoInt = Integer.parseInt(answerTwo.getText().toString());

            if (symbol.equals("+")) {
                if (userAnswerInt == (answerOneInt + answerTwoInt)) {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.correct), Toast.LENGTH_LONG).show();
                    generateNumbers(view);
                    comboNumber++;
                    totalNumber++;
//                    String updatedCombo = String.valueOf(comboNumber);
//                    String updatedTotal = String.valueOf(totalNumber);
//                    combo.setText(updatedCombo);
//                    total.setText(updatedTotal);

                } else {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.incorrect), Toast.LENGTH_LONG).show();
                    totalNumber++;
                    comboNumber = 0;
//                    String updatedCombo = String.valueOf(comboNumber);
//                    String updatedTotal = String.valueOf(totalNumber);
//                    combo.setText(updatedCombo);
//                    total.setText(updatedTotal);
                }
            } else if (symbol.equals("-")) {
                if (userAnswerInt == (answerOneInt - answerTwoInt)) {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.correct), Toast.LENGTH_LONG).show();
                    generateNumbers(view);
                    comboNumber++;
                    totalNumber++;
//                    String updatedCombo = String.valueOf(comboNumber);
//                    String updatedTotal = String.valueOf(totalNumber);
//                    combo.setText(updatedCombo);
//                    total.setText(updatedTotal);
                } else {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.incorrect), Toast.LENGTH_LONG).show();
                    totalNumber++;
                    comboNumber = 0;
//                    String updatedCombo = String.valueOf(comboNumber);
//                    String updatedTotal = String.valueOf(totalNumber);
//                    combo.setText(updatedCombo);
//                    total.setText(updatedTotal);
                }
            } else if (symbol.equals("x")) {
                if (userAnswerInt == (answerOneInt * answerTwoInt)) {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.correct), Toast.LENGTH_LONG).show();
                    generateNumbers(view);
                    comboNumber++;
                    totalNumber++;
//                    String updatedCombo = String.valueOf(comboNumber);
//                    String updatedTotal = String.valueOf(totalNumber);
//                    combo.setText(updatedCombo);
//                    total.setText(updatedTotal);
                } else {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.incorrect), Toast.LENGTH_LONG).show();
                    totalNumber++;
                    comboNumber = 0;
//                    String updatedCombo = String.valueOf(comboNumber);
//                    String updatedTotal = String.valueOf(totalNumber);
//                    combo.setText(updatedCombo);
//                    total.setText(updatedTotal);
                }
            } else {
                if (userAnswerInt == (answerOneInt / answerTwoInt)) {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.correct), Toast.LENGTH_LONG).show();
                    generateNumbers(view);
                    comboNumber++;
                    totalNumber++;
//                    String updatedCombo = String.valueOf(comboNumber);
//                    String updatedTotal = String.valueOf(totalNumber);
//                    combo.setText(updatedCombo);
//                    total.setText(updatedTotal);
                } else {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.incorrect), Toast.LENGTH_LONG).show();
                    totalNumber++;
                    comboNumber = 0;

                }
            }
            String updatedCombo = String.valueOf(comboNumber);
            String updatedTotal = String.valueOf(totalNumber);
            combo.setText(updatedCombo);
            total.setText(updatedTotal);
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText symbol = (EditText) findViewById(R.id.symbol);

        Spinner dropDown = (Spinner) findViewById(R.id.spinner1);
        // Create an ArrayAdapter using string array and a default spinner
        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
                .createFromResource(this, R.array.arithmetic_array,
                        android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        staticAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply adapter to the spinner
        dropDown.setAdapter(staticAdapter);

        dropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String currentSelected = adapterView.getItemAtPosition(i).toString();
                if (currentSelected.equals("Addition")) {
                    symbol.setText(getResources().getString(R.string.addition));
                    generateNumbers(view);
                } else if (currentSelected.equals("Subtraction")) {
                    symbol.setText(getResources().getString(R.string.subtraction));
                    generateNumbers(view);
                } else if (currentSelected.equals("Multiplication")) {
                    symbol.setText(getResources().getString(R.string.multiplication));
                    generateNumbers(view);
                } else {
                    symbol.setText(getResources().getString(R.string.division));
                    generateNumbers(view);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                symbol.setText(getResources().getString(R.string.addition));
            }
        });

        EditText combo = (EditText) findViewById(R.id.comboNumber);
        combo.setText("0");
    }
}

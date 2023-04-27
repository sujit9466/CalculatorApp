package com.example.calculatorapp;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    TextView txtNumbersForInput, txtAnswer;
    Button btnClearAll, btnClearOne, btnPercent, btnDivide,
            btnMultiply, btnMinus, btnPlus, btnCalculate, btnZero, btnOne,
            btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine;
    String userInput = "";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //id binding
        initViews();

        //handling the user clicks
        setOnClick();

    }

    private void initViews() {

        txtNumbersForInput = findViewById(R.id.txtNumbersForCalculation);
        txtAnswer = findViewById(R.id.txtAnswer);

        btnClearAll = findViewById(R.id.btnClearAll);
        btnClearOne = findViewById(R.id.btnClearOne);
        btnPercent = findViewById(R.id.btnPercent);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnDivide = findViewById(R.id.btnDivide);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnCalculate = findViewById(R.id.btnCalculate);

        btnZero = findViewById(R.id.btnZero);
        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);
        btnFour = findViewById(R.id.btnFour);
        btnFive = findViewById(R.id.btnFive);

        btnSix = findViewById(R.id.btnSix);
        btnSeven = findViewById(R.id.btnSeven);
        btnEight = findViewById(R.id.btnEight);
        btnNine = findViewById(R.id.btnNine);

    }

    private void setOnClick() {
        
        OnClickAction action = new OnClickAction();


        btnClearAll.setOnClickListener(action);
        btnClearOne.setOnClickListener(action);
        btnCalculate.setOnClickListener(action);

        btnZero.setOnClickListener(action);
        btnOne.setOnClickListener(action);
        btnTwo.setOnClickListener(action);
        btnThree.setOnClickListener(action);
        btnFour.setOnClickListener(action);
        btnFive.setOnClickListener(action);
        btnSix.setOnClickListener(action);
        btnSeven.setOnClickListener(action);
        btnEight.setOnClickListener(action);
        btnNine.setOnClickListener(action);

        btnPercent.setOnClickListener(action);
        btnPlus.setOnClickListener(action);
        btnMinus.setOnClickListener(action);
        btnDivide.setOnClickListener(action);
        btnMultiply.setOnClickListener(action);


    }

    class OnClickAction implements View.OnClickListener {
        @SuppressLint("NonConstantResourceId")
        @Override
        public void onClick(View view) {

            // checking which button is clicked and performing the actions

            switch (view.getId()) {

                case R.id.btnClearAll:
                    if (userInput.equals("")) return;
                    userInput = "";
                    txtAnswer.setText("");

                    break;

                case R.id.btnClearOne:
                    if (userInput.equals("")) return;
                    userInput = userInput.substring(0, userInput.length() - 1);
                    break;

                case R.id.btnCalculate:
                    if (userInput.equals("")) return;
                    //do Calculation
                    if (!checkIsValidInput()) {
                        return;
                    }
                    doCalculations();
                    break;

                case R.id.btnPercent:
                    if (userInput.equals("")) return;
                    if (!txtAnswer.getText().toString().equals("")) {
                        userInput = txtAnswer.getText().toString();
                        txtAnswer.setText("");
                    }
                    userInput = userInput + "%";


                    break;

                case R.id.btnDivide:
                    if (userInput.equals("")) return;
                    if (!txtAnswer.getText().toString().equals("")) {
                        userInput = txtAnswer.getText().toString();
                        txtAnswer.setText("");
                    }
                    userInput = userInput + "/";
                    break;

                case R.id.btnMultiply:
                    if (userInput.equals("")) return;
                    if (!txtAnswer.getText().toString().equals("")) {
                        userInput = txtAnswer.getText().toString();
                        txtAnswer.setText("");
                    }
                    userInput = userInput + "*";
                    break;

                case R.id.btnMinus:
                    if (userInput.equals("")) return;
                    if (!txtAnswer.getText().toString().equals("")) {
                        userInput = txtAnswer.getText().toString();
                        txtAnswer.setText("");
                    }
                    userInput = userInput + "-";
                    break;

                case R.id.btnPlus:
                    if (userInput.equals("")) return;
                    if (!txtAnswer.getText().toString().equals("")) {
                        userInput = txtAnswer.getText().toString();
                        txtAnswer.setText("");
                    }

                    userInput = userInput + "+";
                    break;

                case R.id.btnZero:
                    if (!userInput.equals("")){
                        userInput = userInput + "0";
                    }
                    break;

                case R.id.btnOne:
                    userInput = userInput + "1";
                    break;

                case R.id.btnTwo:
                    userInput = userInput + "2";
                    break;

                case R.id.btnThree:
                    userInput = userInput + "3";
                    break;

                case R.id.btnFour:
                    userInput = userInput + "4";
                    break;

                case R.id.btnFive:
                    userInput = userInput + "5";
                    break;

                case R.id.btnSix:
                    userInput = userInput + "6";
                    break;

                case R.id.btnSeven:
                    userInput = userInput + "7";
                    break;

                case R.id.btnEight:
                    userInput = userInput + "8";
                    break;

                case R.id.btnNine:
                    userInput = userInput + "9";
                    break;

                default:
                    Toast.makeText(MainActivity.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
            }

            txtNumbersForInput.setText(userInput);
        }


        private void doCalculations() {

            int num1 = 0;
            int num2 = 0;
            char sign = 0;
            for (int i = 0; i < userInput.length(); i++) {
                if (userInput.charAt(i) == '*' || userInput.charAt(i) == '/' || userInput.charAt(i) == '+' || userInput.charAt(i) == '-' || userInput.charAt(i) == '%') {

                    // check if user only enters single number and sign
                    if (i == userInput.length()-1) {
                        txtAnswer.setText("Invalid");
                        return;
                    }

                    num1 = Integer.parseInt(userInput.substring(0, i));
                    num2 = Integer.parseInt(userInput.substring(i + 1));
                    sign = userInput.charAt(i);
                    switch (sign) {
                        case '+':
                            txtAnswer.setText(String.valueOf(num1 + num2));
                            break;
                        case '-':
                            txtAnswer.setText(String.valueOf(num1 - num2));
                            break;
                        case '*':
                            txtAnswer.setText(String.valueOf(num1 * num2));
                            break;
                        case '/':
                            if (num1 == 0 || num2 ==0){
                                txtAnswer.setText(String.valueOf(0));
                                return;
                            }
                            txtAnswer.setText(String.valueOf(num1 / num2));
                            break;
                        case '%':
                            if (num1 == 0 || num2 ==0){
                                txtAnswer.setText(String.valueOf(0));
                                return;
                            }
                            txtAnswer.setText(String.valueOf(num1 % num2));
                            break;
                    }
                }
            }
        }

        private boolean checkIsValidInput() {
            int count = 0;
            for (int i = 0; i < userInput.length(); i++) {
                if (userInput.charAt(i) == '*' || userInput.charAt(i) == '/' || userInput.charAt(i) == '+' || userInput.charAt(i) == '-' || userInput.charAt(i) == '%') {
                    count++;
                }
            }
            if (count > 1) {
                Toast.makeText(MainActivity.this, "Please enter valid input", Toast.LENGTH_SHORT).show();
                txtAnswer.setText("Invalid!!");
                return false;
            }
            return true;
            
        }

    }
}
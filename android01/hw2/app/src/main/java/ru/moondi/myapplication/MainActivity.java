package ru.moondi.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

     private Button buttonClear;
    private Button  buttonPlus;
    private Button buttonEqually;
    private Button buttonMultiplay;
    private Button buttonMinus;
    private Button buttonDivision;
    private Button buttonOne;
    private Button buttonTwo;
    private Button buttonThree;
    private Button buttonFour;
    private Button buttonFive;
    private Button buttonSix;
    private Button buttonSeven;
    private Button buttonEight;
    private Button buttonNine;
    private Button buttonZero;
    private TextView editTextScoreBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonClear = findViewById(R.id.button_clear);
        buttonPlus = findViewById(R.id.button_plus);
        buttonEqually = findViewById(R.id.button_equally);
        buttonPlus = findViewById(R.id.button_plus);
        buttonMultiplay = findViewById(R.id.button_multiply);
        buttonMinus = findViewById(R.id.button_minus);
        buttonDivision = findViewById(R.id.button_division);
        buttonOne = findViewById(R.id.button1);
        buttonTwo = findViewById(R.id.button2);
        buttonThree = findViewById(R.id.button3);
        buttonFour = findViewById(R.id.button4);
        buttonFive  = findViewById(R.id.button5);
        buttonSix  = findViewById(R.id.button6);
        buttonSeven  = findViewById(R.id.button7);
        buttonEight  = findViewById(R.id.button8);
        buttonNine  = findViewById(R.id.button9);
        buttonZero  = findViewById(R.id.button0);
        editTextScoreBoard = findViewById(R.id.editTextScoreBoard);
    }

    @Override
    public void onClick(View v) {

    }
}
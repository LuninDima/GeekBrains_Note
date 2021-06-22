package ru.moondi.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

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
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonClear = findViewById(R.id.button_clear);
        buttonPlus = findViewById(R.id.button_plus);
        buttonEqually = findViewById(R.id.button_equally);
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
        initOnclickListener();
    }

    private void initOnclickListener() {
        buttonOne.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);
        buttonThree.setOnClickListener(this);
        buttonFour.setOnClickListener(this);
        buttonFive.setOnClickListener(this);
        buttonSix.setOnClickListener(this);
        buttonSeven.setOnClickListener(this);
        buttonEight.setOnClickListener(this);
        buttonNine.setOnClickListener(this);
        buttonZero.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonMultiplay.setOnClickListener(this);
        buttonDivision.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
        buttonEqually.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Toast.makeText(this,"Привет",Toast.LENGTH_SHORT).show();
    }
}
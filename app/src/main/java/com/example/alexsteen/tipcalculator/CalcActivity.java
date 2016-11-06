package com.example.alexsteen.tipcalculator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalcActivity extends AppCompatActivity {

    private double tip;

    RadioButton p12;
    RadioButton p15;
    RadioButton p18;
    RadioButton p20;
    RadioButton pCust;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        RadioButton p12 = (RadioButton) findViewById(R.id.percent12);
        RadioButton p15 = (RadioButton) findViewById(R.id.percent15);
        RadioButton p18 = (RadioButton) findViewById(R.id.percent18);
        RadioButton p20 = (RadioButton) findViewById(R.id.percent20);
        RadioButton pCust = (RadioButton) findViewById(R.id.percentCust);

        EditText currDate = (EditText) findViewById(R.id.currDate);
        currDate.setClickable(false);
        currDate.setFocusable(false);
        currDate.setText(dateFormat.format(date));

        EditText subTotal = (EditText) findViewById(R.id.subtotalAmt);
        subTotal.setText("10.00");

        EditText tax = (EditText) findViewById(R.id.taxAmt);
        tax.setText("7.00");

        tip = 15.0;
    }

    public void onRBClick(View v) {
        boolean clicked = ((RadioButton) v).isChecked();

        switch (v.getId()) {
            case R.id.percent12:
                if (clicked) {
                    p15.setChecked(false);
                    p18.setChecked(false);
                    p20.setChecked(false);
                    pCust.setChecked(false);
                    tip = 12;
                }
                break;
        }

    }
}

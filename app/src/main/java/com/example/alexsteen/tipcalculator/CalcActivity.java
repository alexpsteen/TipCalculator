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
    private double tax;
    private double subTotal;


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

        EditText subTotalField = (EditText) findViewById(R.id.subtotalAmt);
        subTotalField.setText("10.00");
        subTotal = 10;

        EditText taxField = (EditText) findViewById(R.id.taxAmt);
        taxField.setText("7.00");
        tax = 7;

        tip = 15.0;
        recalculate();
    }

    public void onRBClick(View v) {
        boolean clicked = ((RadioButton) v).isChecked();

        switch (v.getId()) {
            case R.id.percent12:
                if (clicked) {
                    tip = 12;
                    recalculate();
                }
                break;
            case R.id.percent15:
                if (clicked) {
                    tip = 15;
                    recalculate();
                }
                break;
            case R.id.percent18:
                if (clicked) {
                    tip = 18;
                    recalculate();
                }
                break;
            case R.id.percent20:
                if (clicked) {
                    tip = 20;
                    recalculate();
                }
                break;
            case R.id.percentCust:
                if (clicked) {
                    //TODO
                }
                break;
        }

    }

    public void recalculate() {
        double taxAmount = ((tax * .01) * subTotal);
        double tipAmount = ((tip * .01) * subTotal);

        EditText tipAmountField = (EditText) findViewById(R.id.tipTotalField);
        tipAmountField.setText("" + tipAmount);

        EditText grandField = (EditText) findViewById(R.id.grandTotalField);
        grandField.setText("" + (subTotal + taxAmount + tipAmount));
    }
}

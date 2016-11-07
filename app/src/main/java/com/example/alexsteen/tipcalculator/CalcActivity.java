package com.example.alexsteen.tipcalculator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
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


        final EditText subTotalField = (EditText) findViewById(R.id.subtotalAmt);
        subTotalField.setText("10.00");
        subTotal = 10;
        subTotalField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().length() <= 1) {
                    subTotalField.setText(".00");
                }
                subTotal = Double.valueOf(s.toString());
                recalculate();
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });


        final EditText taxField = (EditText) findViewById(R.id.taxAmt);
        taxField.setText("7.0");
        tax = 7;
        taxField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().length() <= 1) {
                    taxField.setText(".0");
                }
                tax = Double.valueOf(s.toString());
                recalculate();
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });


        tip = 15.0;

//        p12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                tip = 12;recalculate();
//            }
//        });
//        p15.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                tip = 15;recalculate();
//            }
//        });
        p12.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                tip = 12;recalculate();
                return false;
            }
        });
        p15.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                tip = 15;recalculate();
                return false;
            }
        });
        p18.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                tip = 18;recalculate();
                return false;
            }
        });
        p20.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                tip = 20;recalculate();
                return false;
            }
        });

//        p12.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {tax = 12;recalculate();}});
//        p15.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {tax = 15;recalculate();}});
//        p18.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {tax = 18;recalculate();}});
//        p20.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {tax = 20;recalculate();}});
//        pCust.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {tax = 12;recalculate();}});

        recalculate();
    }

    public void onRBClick() {

    }

    public void recalculate() {
        double taxAmount = ((double)((int) (tax * subTotal))) / 100;
        double tipAmount = ((double)((int) (tip * subTotal))) / 100;

        EditText tipAmountField = (EditText) findViewById(R.id.tipTotalField);
        tipAmountField.setText("" + tipAmount);

        EditText grandField = (EditText) findViewById(R.id.grandTotalField);
        grandField.setText("" + ((double)((int)((subTotal + taxAmount + tipAmount)*100))) / 100);
    }
}

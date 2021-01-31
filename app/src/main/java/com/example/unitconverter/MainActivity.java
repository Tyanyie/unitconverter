package com.example.unitconverter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText inputLeft = (EditText)findViewById(R.id.inputLeft);
        EditText inputRight = (EditText)findViewById(R.id.inputRight);

        TextView textLeft = (TextView)findViewById(R.id.textLeft);
        TextView textRight = (TextView)findViewById(R.id.textRight);


        inputLeft.addTextChangedListener(new TextWatcher()
        {
            Editable input;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                input = inputLeft.getEditableText();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                inputRight.setText(input);
            }

            @Override
            public void afterTextChanged(Editable s)
            {
                inputRight.setText(input);
            }
        });




        //get left and right input value from user
//        float inputFromLeftFloat = Float.parseFloat(inputLeft.getContext().toString());
//        float inputFromRightFloat = Float.parseFloat(inputRight.getContext().toString());



        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e)
        {
            System.out.print("Null Pointer Exception Occurred");
        }
    }
}
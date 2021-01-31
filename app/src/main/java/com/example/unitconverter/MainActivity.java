package com.example.unitconverter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static java.lang.Float.*;

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
                Editable inputRight1;
                double output;

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after)
                {
                    input = inputLeft.getEditableText();
                }

                //Example: (50°F - 32) x .5556 = 10°C
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count)
                {

                    input = inputLeft.getEditableText();
                    float a = Float.parseFloat(String.valueOf(input));
                    float result = (float) ((a - 32.0) * 0.5556);

                    inputRight.setText(String.valueOf(result));
                }

                @Override
                public void afterTextChanged(Editable s)
                {

                }
            });








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
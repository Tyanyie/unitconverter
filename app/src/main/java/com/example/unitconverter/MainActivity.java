package com.example.unitconverter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static java.lang.Float.*;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        final String TAG = ">>>>>>>";
        Log.v(TAG, "Start of On create");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText inputLeft = (EditText)findViewById(R.id.inputLeft);
        EditText inputRight = (EditText)findViewById(R.id.inputRight);

        TextView textLeft = (TextView)findViewById(R.id.textLeft);
        TextView textRight = (TextView)findViewById(R.id.textRight);

        /*
        * Todo:
        *  - input field can not enter negative value (it only works on input number first and then negative sign)         <----------------
        *  - app will auto close after delete value in input field                                                         <----------------
        * */

            inputLeft.addTextChangedListener(new TextWatcher()
            {
                Editable input;
                float result;

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after)
                {
                    input = inputLeft.getEditableText();
                    Log.v(TAG, "Before Text Changed");

                }

                //Example: (50°F - 32) x .5556 = 10°C
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count)
                {
                    //input = inputLeft.getEditableText();
                    float a = Float.parseFloat(String.valueOf(input));
                    result = (float) ((a - 32.0) * 0.5556);
                    Log.v(TAG, "On Text Changed");
                }

                @Override
                public void afterTextChanged(Editable s)
                {
                    inputRight.setText(String.valueOf(result));
                    Log.v(TAG, "After Text Changed");
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

        Log.v(TAG, "End of On create");



    }
}
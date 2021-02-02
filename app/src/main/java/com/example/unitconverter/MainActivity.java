package com.example.unitconverter;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

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
        EditText inputLeft2 = (EditText)findViewById(R.id.inputLeft2);
        EditText inputRight2 = (EditText)findViewById(R.id.inputRight2);

        Toast.makeText(getApplicationContext(),"Welcome to Unit Converter by Tianyi Zhou",Toast.LENGTH_SHORT).show();
        inputLeft.addTextChangedListener(new TextWatcher()
            {
                Editable input;
                double result;
                double a;

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
                    try
                    {
                        a = Float.parseFloat(String.valueOf(input));
                        result = (a - 32) * 0.5556;
                    }
                    catch (NumberFormatException e)
                    {
                        Log.v(TAG, "NumberFormatException");
                    }
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
                Log.v(TAG, "Null pointer exception");
            }
        Log.v(TAG, "End of On create");

            inputLeft2.addTextChangedListener(new TextWatcher()
            {
                Editable input2;
                double b;
                double result2;
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after)
                {
                    input2 = inputLeft2.getEditableText();
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count)
                {
                    try
                    {
                        b = Float.parseFloat(String.valueOf(input2));
                        result2 = (b / 0.5556) + 32;
                    }
                    catch (NumberFormatException e)
                    {
                        Log.v(TAG, "NumberFormatException2");
                    }
                }

                @Override
                public void afterTextChanged(Editable s)
                {
                    inputRight2.setText(String.valueOf(result2));
                }
            });
    }
}
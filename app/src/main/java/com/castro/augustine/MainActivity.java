package com.castro.augustine;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    EditText eName, eAge, eGender;
    TextView tMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eName = findViewById(R.id.etInput_1);
        eAge = findViewById(R.id.etInput_2);
        eGender = findViewById(R.id.etInput_3);

        tMsg = findViewById(R.id.tvMsg);
    }

    public void onSave(View v)
    {
        SharedPreferences sp = getSharedPreferences("data1", Context.MODE_PRIVATE);
        SharedPreferences.Editor writer = sp.edit();

        String name = eName.getText().toString();
        String age = eAge.getText().toString();
        String gender = eGender.getText().toString();

        writer.putString("name", name);
        writer.putString("age", age);
        writer.putString("gender", gender);
        writer.commit();

        Toast.makeText(this, "data saved..", Toast.LENGTH_LONG).show();
    }

    public void onDisplay(View v)
    {
        SharedPreferences sp = getSharedPreferences("data1", Context.MODE_PRIVATE);

        String name = sp.getString("name", null);
        String age = sp.getString("age", null);
        String gender = sp.getString("gender", null);

        String message = name + "\n" + age + "\n" + gender;
        tMsg.setText(message);
    }
}

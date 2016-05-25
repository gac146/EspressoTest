package com.example.moizq.espressotest;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtField;
    TextView text;
    Button btn, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtField = (EditText) findViewById(R.id.editText);
        text = (TextView) findViewById(R.id.textView);
        btn = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences("info", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("string", txtField.getText().toString());
                editor.apply();
                Toast.makeText(MainActivity.this, "Saved Text!", Toast.LENGTH_SHORT).show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences("info", MODE_PRIVATE);
                String txt = prefs.getString("string", "");
                String reverse = new StringBuffer(txt).reverse().toString();
                text.setText(reverse);
                Toast.makeText(MainActivity.this, "Retrieved Text!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}

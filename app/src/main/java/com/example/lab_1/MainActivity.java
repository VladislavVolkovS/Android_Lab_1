package com.example.lab_1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    Button goToSecond;
    EditText colorName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goToSecond = (Button) findViewById(R.id.button_go_to);
        colorName = (EditText) findViewById(R.id.text_field);
        goToSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent colorIntent = new Intent(MainActivity.this, SecondActivity.class);
                String backgroundColor = colorName.getText().toString();
                if (backgroundColor.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter color!", Toast.LENGTH_LONG).show();
                } else {
                    try {
                        Color.parseColor(backgroundColor);
                    } catch (IllegalArgumentException exception) {
                        Toast.makeText(getApplicationContext(), "It isn't color!", Toast.LENGTH_LONG).show();
                        return;
                    }
                    colorIntent.putExtra("color", backgroundColor);
                    startActivity(colorIntent);
                }
            }
        });
    }
}
